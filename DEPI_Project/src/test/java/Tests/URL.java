package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class URL {

    // Declare WebDriver as a protected member so subclasses can access it
    protected WebDriver driver;

    // The setup method to initialize WebDriver and launch the browser
    @BeforeMethod
    public void setup() {
        // Set up WebDriver for Chrome (you can modify this to use other browsers)
        driver = new EdgeDriver();  // Initialize the ChromeDriver instance
        driver.manage().window().maximize();  // Maximize the browser window
        driver.get("http://automationexercise.com");  // Navigate to the website URL
    }

    // The tearDown method to close the browser after each test
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and clean up WebDriver
        }
    }
}
