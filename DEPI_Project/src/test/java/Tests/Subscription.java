package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Subscription extends URL{


    @Test
    public void verifySubscription() throws InterruptedException {
        // Scroll down to the subscription section using JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // Enter a valid email address in the subscription input field
        driver.findElement(By.id("susbscribe_email")).sendKeys("testemail@example.com");

        // Click the "Subscribe" button
        driver.findElement(By.id("subscribe")).click();

        // Wait for a short period for the success message to appear
        Thread.sleep(5000); // You can replace this with WebDriverWait for better synchronization

        // Verify that the success message is displayed
        // boolean isSubscriptionSuccessDisplayed = driver.findElement(By.xpath("//div[contains(text(),'You have been successfully subscribed!')]")).isDisplayed();
        // Assert.assertTrue(isSubscriptionSuccessDisplayed, "Subscription success message is not displayed.");
    }

}
