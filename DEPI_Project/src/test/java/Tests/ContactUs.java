package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ContactUs extends URL {

    @Test
    public void submitContactUsForm() throws InterruptedException {
        // Click on "Contact Us" button
        driver.findElement(By.xpath("//a[contains(text(),'Contact us')]")).click();

        // Enter name, email, subject, and message
        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("Test User");
        driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("testuser@example.com");
        driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("Test Subject");
        driver.findElement(By.xpath("//textarea[@data-qa='message']")).sendKeys("This is a test message for the contact form.");

        // Upload a file (optional step)
        //File file = new File("\"C:\\Users\\HP\\Desktop\\WIN_20241010_18_51_32_Pro.jpg\""); // Replace with the correct file path
        //driver.findElement(By.xpath("//input[@name='upload_file']")).sendKeys(file.getAbsolutePath());

        // Click "Submit" button
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();

        // Handle the alert popup confirmation by accepting it
        driver.switchTo().alert().accept();

        // Verify success message
        String expectedSuccessMessage = "Success! Your details have been submitted successfully.";
        String actualSuccessMessage = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success message does not match.");
    }
}