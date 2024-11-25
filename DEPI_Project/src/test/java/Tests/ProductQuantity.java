package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ProductQuantity extends URL {

    @Test
    public void verifyProductQuantityInCart() throws InterruptedException {
        // Step 3: Verify that the homepage is visible successfully
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Homepage is not visible");

        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]")).click(); // Click on first product

        String productDetailTitle = driver.getTitle();
        Assert.assertTrue(productDetailTitle.contains("Product Details"), "Product details page is not opened");

        driver.findElement(By.id("quantity")).clear(); // Clear default value
        driver.findElement(By.id("quantity")).sendKeys("4"); // Set quantity to 4

        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")).click();

        Thread.sleep(2000); // Wait for modal to appear
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();


    }

}
