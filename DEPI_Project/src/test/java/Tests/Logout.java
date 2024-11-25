package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Logout extends URL{

    @Test
    public void logoutUser() throws InterruptedException {
        // Step 1: Click on "Signup / Login" button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        // Step 2: Enter valid email and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("mmww@example.com");  // Replace with valid email
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Password123");        // Replace with valid password

        // Step 3: Click "Login" button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // Step 4: Verify successful login
        Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Logged in as')]")).isDisplayed(),
                "Login was not successful.");

        // Step 5: Click "Logout" button
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

        // Step 6: Verify that the user is redirected to the login page
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).isDisplayed(),
                "User was not redirected to the login page after logout.");
    }

}
