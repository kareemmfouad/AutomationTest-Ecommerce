package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends URL{

    @Test
    public void verifyTestCasesPage() throws InterruptedException {
        // Click on "Test Cases" button in the header
        driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]")).click();

        // Verify the URL contains "test_cases"
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("test_cases"), "URL does not contain 'test_cases'.");


        // Verify the presence of the test case list/table (optional)
        boolean isTestCaseTableDisplayed = driver.findElement(By.xpath("//section[@id='form']//div[@class='container']")).isDisplayed();
        Assert.assertTrue(isTestCaseTableDisplayed, "Test cases content is not displayed.");
    }

}
