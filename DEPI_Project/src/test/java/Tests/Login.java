package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Login extends URL{

    @Test
    public void loginUser() throws InterruptedException {
        // Click on "Signup/Login" button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        // Enter email and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("mo123@example.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Password123");

        // Click "Login" button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // Verify login success
        //WebElement loggedInAs = driver.findElement(By.xpath("//li[contains(text(),'Logged in as')]"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/", "not found");
    }

}
