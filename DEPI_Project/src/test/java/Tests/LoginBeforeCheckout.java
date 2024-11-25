package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginBeforeCheckout extends URL {

    @Test
    public void placeOrderLoginBeforeCheckout() throws InterruptedException {
        // Step 3: Verify homepage visibility
        //String homePageTitle = driver.getTitle();
        //Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Homepage is not visible");

        // Step 4: Click 'Signup / Login'
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        // Step 5: Fill email, password and click 'Login' button
        driver.findElement(By.name("email")).sendKeys("mo17@gmail.com"); // Use valid email
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        // Step 6: Verify 'Logged in as username' at top
        //Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Logged in as Test User')]")).isDisplayed(), "Login was not successful");
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        // Step 7: Add products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click(); // Add the first product
        Thread.sleep(2000);
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();

        // Step 8: Click 'Cart' button
        // Already on cart page after clicking 'View Cart'

        // Step 9: Verify cart page is displayed
        Assert.assertTrue(driver.getTitle().contains("Checkout"), "Cart page is not displayed");

        // Step 10: Click 'Proceed To Checkout'
        driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();

        // Step 11: Verify Address Details and Review Your Order
        // Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]")).isDisplayed(), "Address details not displayed");
        // Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Review Your Order')]")).isDisplayed(), "Review order section not displayed");

        driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();

        // Step 13: Enter payment details
        driver.findElement(By.name("name_on_card")).sendKeys("Test User");
        driver.findElement(By.name("card_number")).sendKeys("1234123412341234");
        driver.findElement(By.name("cvc")).sendKeys("123");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("2025");

        // Step 14: Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[contains(text(),'Pay and Confirm Order')]")).click();

        // Step 15: Verify success message 'Your order has been placed successfully!'
        //Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Your order has been placed successfully!')]")).isDisplayed(), "Order not placed successfully");

        // Step 16: Click 'Delete Account' button
        driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();

        // Step 17: Verify 'ACCOUNT DELETED!' and click 'Continue' button
        // Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'ACCOUNT DELETED!')]")).isDisplayed(), "Account deletion failed");
        // driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
    }

}
