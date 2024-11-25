package Tests;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidRegister extends URL {

    @Test
    public void registerUserWithExistingEmail() throws InterruptedException {
        // Click on "Signup / Login" button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        // Enter name and existing email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Test User");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("testuser@example.com"); // Existing email

        // Click "Signup" button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        // Verify error message is displayed for existing email
        String expectedErrorMessage = "Email Address already exist!";
        String actualErrorMessage = driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message for existing email is incorrect.");
    }
}
