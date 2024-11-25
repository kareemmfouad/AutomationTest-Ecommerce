package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegisterCheckout extends URL {

    @Test
    public void placeOrderRegisterWhileCheckout() throws InterruptedException {
        // Step 3: Verify homepage visibility
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Homepage is not visible");

        // Step 4: Add products to the cart
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click(); // Add the first product
        Thread.sleep(2000);
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();

        // Step 5: Click 'Cart' button
        // Already on cart page after clicking 'View Cart'

        // Step 6: Verify cart page is displayed
        Assert.assertTrue(driver.getTitle().contains("Checkout"), "Cart page is not displayed");

        // Step 7: Click 'Proceed To Checkout'
        driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();

        // Step 8: Click 'Register / Login'
        driver.findElement(By.xpath("//u[contains(text(),'Register / Login')]")).click();

        // Step 9: Fill in details in Signup and create an account
        driver.findElement(By.name("name")).sendKeys("Test User");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("mo1275@example.com");

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
        //driver.findElement(By.id("newsletter")).click(); // Sign up for newsletter
        //driver.findElement(By.id("optin")).click(); // Receive special offers

        driver.findElement(By.name("first_name")).sendKeys("Mohamed");
        driver.findElement(By.name("last_name")).sendKeys("Khaled");
        driver.findElement(By.name("address1")).sendKeys("Giza");
        driver.findElement(By.name("country")).sendKeys("india");
        driver.findElement(By.name("state")).sendKeys("Giza");
        driver.findElement(By.name("city")).sendKeys("Giza");
        driver.findElement(By.name("zipcode")).sendKeys("00022");
        driver.findElement(By.name("mobile_number")).sendKeys("01155653546");

        // Fill the rest of the required fields here...
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        // Step 11: Verify 'Logged in as username' at top
        //Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Logged in as Test User')]")).isDisplayed(), "Login was not successful");

        // Step 12: Click 'Cart' button again
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();

        // Step 13: Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();

        // Step 14: Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]")).isDisplayed(), "Address details not displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Review Your Order')]")).isDisplayed(), "Review order section not displayed");

        // Step 15: Enter description in comment text area and click 'Place Order'
        driver.findElement(By.name("message")).sendKeys("Please deliver between 9 AM and 5 PM.");
        driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();

        // Step 16: Enter payment details
        driver.findElement(By.name("name_on_card")).sendKeys("Test User");
        driver.findElement(By.name("card_number")).sendKeys("1234123412341234");
        driver.findElement(By.name("cvc")).sendKeys("123");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("2025");

        // Step 17: Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[contains(text(),'Pay and Confirm Order')]")).click();

        // Step 18: Verify success message 'Your order has been placed successfully!'
        //Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Your order has been placed successfully!')]")).isDisplayed(), "Order not placed successfully");

        // Step 19: Click 'Delete Account' button
        driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();

        // Step 20: Verify 'ACCOUNT DELETED!' and click 'Continue' button
        //Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'ACCOUNT DELETED!')]")).isDisplayed(), "Account deletion failed");
        //driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
    }

}
