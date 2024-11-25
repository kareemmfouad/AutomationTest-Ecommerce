package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProducts extends URL {

    @Test
    public void addProductsToCart() throws InterruptedException {
        // Navigate to the Products page
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();

        // Add a product to the cart (for example, the first product)
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click(); // Add first product

        // Wait for a few seconds to allow the modal to appear (you can use WebDriverWait here)
        Thread.sleep(2000);

        // Click "View Cart" from the modal
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();

        // Verify that the product is added to the cart
        boolean isProductInCart = driver.findElement(By.xpath("//td[@class='cart_description']")).isDisplayed();
        Assert.assertTrue(isProductInCart, "Product is not added to the cart.");

        // Optionally, verify the product details in the cart (e.g., product name, price, etc.)
        String expectedProductName = "Blue Top";  // Example product name; replace with actual product name
        String actualProductName = driver.findElement(By.xpath("//td[@class='cart_description']//a")).getText();
        Assert.assertEquals(actualProductName, expectedProductName, "The product name in the cart is incorrect.");
    }
}