package Tests;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegisterBeforeCheckout extends URL {

    @Test
    public void placeOrderRegisterBeforeCheckout() throws InterruptedException {

        // Step 4: Click 'Signup / Login'
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        // Step 5: Fill in details in Signup and create an account
        driver.findElement(By.name("name")).sendKeys("Test User");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("mmww@example.com");
        driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).click();
        // Fill in remaining account creation form fields
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("first_name")).sendKeys("Test");
        driver.findElement(By.id("last_name")).sendKeys("User");
        driver.findElement(By.id("address1")).sendKeys("123 Test Street");
        driver.findElement(By.id("city")).sendKeys("Test City");
        driver.findElement(By.id("state")).sendKeys("Test State");
        driver.findElement(By.id("zipcode")).sendKeys("12345");
        driver.findElement(By.id("mobile_number")).sendKeys("1234567890");
        driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();

        // Step 6: Verify 'ACCOUNT CREATED!' and click 'Continue' button
        // Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'ACCOUNT CREATED!')]")).isDisplayed(), "Account creation failed");
        // driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();

        // Step 7: Verify 'Logged in as username' at the top
        //Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Logged in as Test User')]")).isDisplayed(), "Login was not successful");
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        // Step 8: Add products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click(); // Add the first product
        Thread.sleep(2000);
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();

        // Step 9: Click 'Cart' button
        // Already on cart page after clicking 'View Cart'

        // Step 10: Verify cart page is displayed
        Assert.assertTrue(driver.getTitle().contains("Checkout"), "Cart page is not displayed");

        // Step 11: Click 'Proceed To Checkout'
        driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();

        // Step 12: Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]")).isDisplayed(), "Address details not displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Review Your Order')]")).isDisplayed(), "Review order section not displayed");

        // Step 13: Enter description in comment text area and click 'Place Order'
        driver.findElement(By.name("message")).sendKeys("Please deliver between 9 AM and 5 PM.");
        driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();

        // Step 14: Enter payment details
        driver.findElement(By.name("name_on_card")).sendKeys("Test User");
        driver.findElement(By.name("card_number")).sendKeys("1234123412341234");
        driver.findElement(By.name("cvc")).sendKeys("123");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("2025");

        // Step 15: Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[contains(text(),'Pay and Confirm Order')]")).click();

        // Step 16: Verify success message 'Your order has been placed successfully!'
        //Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Your order has been placed successfully!')]")).isDisplayed(), "Order not placed successfully");

        // Step 17: Click 'Delete Account' button
        driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();

        // Step 18: Verify 'ACCOUNT DELETED!' and click 'Continue' button
        // Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'ACCOUNT DELETED!')]")).isDisplayed(), "Account deletion failed");
        // driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
    }

}
