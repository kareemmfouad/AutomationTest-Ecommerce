package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Products extends URL {

    @Test
    public void verifyAllProductsAndDetailPage() throws InterruptedException {
        // Click on "Products" button to navigate to the All Products page
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();

        // Verify that the products list is displayed
        boolean isProductListDisplayed = driver.findElement(By.xpath("//h2[contains(text(),'All Products')]")).isDisplayed();
        Assert.assertTrue(isProductListDisplayed, "The All Products page is not displayed.");

        // Click on the first product to navigate to its detail page
        driver.findElement(By.xpath("(//a[@href='/product_details/1'])[1]")).click();

        // Verify that the product detail page is displayed
        boolean isProductDetailDisplayed = driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed();
        Assert.assertTrue(isProductDetailDisplayed, "Product detail page is not displayed.");

        // Verify product details (e.g., product name)
        String expectedProductName = "Blue Top"; // Example product name; replace with actual product name if needed
        String actualProductName = driver.findElement(By.xpath("//h2[contains(text(),'Blue Top')]")).getText();
        Assert.assertEquals(actualProductName, expectedProductName, "Product name does not match.");

        // You can verify other product details like price, availability, etc., if necessary
    }

}
