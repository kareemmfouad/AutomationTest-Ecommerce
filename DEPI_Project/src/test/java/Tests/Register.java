package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Register extends URL {

    @Test
    public void registerUser() throws InterruptedException {
        // Click on "Signup/Login" button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        // Enter name and email address
        driver.findElement(By.name("name")).sendKeys("Test User");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("MO17@example.com");

        // Click "Signup" button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        // Fill details for account registration
        driver.findElement(By.id("id_gender1")).click(); // Select title
        driver.findElement(By.id("password")).sendKeys("Password123"); // Enter password

        // Select Date of Birth
        driver.findElement(By.id("days")).sendKeys("10");
        driver.findElement(By.id("months")).sendKeys("May");
        driver.findElement(By.id("years")).sendKeys("1990");

        // Select checkboxes
        driver.findElement(By.id("newsletter")).click(); // Sign up for newsletter
        driver.findElement(By.id("optin")).click(); // Receive special offers

        driver.findElement(By.name("first_name")).sendKeys("Mohamed");
        driver.findElement(By.name("last_name")).sendKeys("Khaled");
        driver.findElement(By.name("address1")).sendKeys("Giza");
        driver.findElement(By.name("country")).sendKeys("india");
        driver.findElement(By.name("state")).sendKeys("Giza");
        driver.findElement(By.name("city")).sendKeys("Giza");
        driver.findElement(By.name("zipcode")).sendKeys("00022");
        driver.findElement(By.name("mobile_number")).sendKeys("01155653546");


        // Click "Create Account" button
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        // Verify that the account was created
        WebElement successMessage = driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Account was not created successfully.");
    }
}
