package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RecommendedItems extends URL{


    @Test
    public void addToCartFromRecommendedItems() throws InterruptedException {
        // Step 3: Scroll to bottom of page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000); // Wait for the page to load

        // Step 4: Verify 'RECOMMENDED ITEMS' are visible
        // Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'RECOMMENDED ITEMS')]")).isDisplayed(), "'RECOMMENDED ITEMS' is not visible");

        // Step 5: Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[last()]")).click(); // Clicks the last recommended product

        Thread.sleep(3000); // Wait for the product to be added to cart

        // Step 6: Click on 'View Cart' button
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();

        // Step 7: Verify that the product is displayed in cart page
        Assert.assertTrue(driver.findElements(By.xpath("//table[contains(@class,'table')]//tbody/tr")).size() > 0, "Product is not displayed in the cart page");
    }

}
