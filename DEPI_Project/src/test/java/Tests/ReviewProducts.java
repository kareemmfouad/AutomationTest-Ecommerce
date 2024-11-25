package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ReviewProducts extends URL {

    @Test
    public void addReviewOnProduct() throws InterruptedException {
        // Step 3: Click on 'Products' button
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();

        // Step 4: Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.getTitle().contains("All Products"), "User is not navigated to ALL PRODUCTS page");

        // Step 5: Click on 'View Product' button for any product
        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]")).click(); // Clicks the first product

        // Step 6: Verify 'Write Your Review' is visible
        // Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Write Your Review')]")).isDisplayed(), "'Write Your Review' is not visible");

        // Step 7: Enter name, email, and review
        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("email")).sendKeys("john@example.com");
        driver.findElement(By.id("review")).sendKeys("This product is amazing!");

        // Step 8: Click 'Submit' button
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

        // Step 9: Verify success message 'Thank you for your review.'
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Thank you for your review.')]")).isDisplayed(), "Success message is not visible");
    }

}
