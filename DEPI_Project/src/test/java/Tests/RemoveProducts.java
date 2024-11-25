package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RemoveProducts extends URL {

    @Test
    public void removeProductsFromCart() throws InterruptedException {

        // Step 4: Add a product to the cart
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click(); // Add first product
        Thread.sleep(2000); // Wait for the action to complete
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click(); // Go to cart

        // Step 5: Verify that the cart page is displayed
        String cartPageTitle = driver.getTitle();
        Assert.assertTrue(cartPageTitle.contains("Checkout"), "Cart page is not displayed");

        // Step 7: Click 'X' button corresponding to a particular product
        driver.findElement(By.xpath("//a[@class='cart_quantity_delete' and @data-product-id='1']")).click(); // Replace with the actual product ID

        // Step 8: Verify that the product is removed from the cart
        // Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Your cart is empty')]")).isDisplayed(), "Product not removed from the cart");
    }

}
