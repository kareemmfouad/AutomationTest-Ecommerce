package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Search extends URL {

    @Test
    public void searchProduct() throws InterruptedException {

        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();

        // Enter product name in search input (e.g., "T-shirt")
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("blue");

        // Click the search button
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

        // Verify that the search results are displayed
        boolean isSearchResultsDisplayed = driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]")).isDisplayed();
        Assert.assertTrue(isSearchResultsDisplayed, "Search results are not displayed.");

        // Verify that at least one product matching the search is displayed
        boolean isProductDisplayed = driver.findElement(By.xpath("//div[@class='productinfo text-center']")).isDisplayed();
        Assert.assertTrue(isProductDisplayed, "No products matching the search are displayed.");

        // Optionally, click on the first product in the search results
        driver.findElement(By.xpath("(//a[@href='/product_details/1'])")).click();

        // Verify that the product detail page is displayed
        boolean isProductDetailDisplayed = driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed();
        Assert.assertTrue(isProductDetailDisplayed, "Product detail page is not displayed.");
    }

}
