package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class InvalidLogin extends URL {

    @Test
    public void loginUserWithInvalidCredentials() throws InterruptedException {
        // Click on "Signup / Login" button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        // Enter invalid email and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("invaliduser@example.com"); // Invalid email
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("InvalidPassword123"); // Invalid password

        // Click "Login" button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // Verify error message is displayed
        String expectedErrorMessage = "Your email or password is incorrect!";
        String actualErrorMessage = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match.");
    }
}