package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import utils.ConfigReader;

public class BasePage {

    public static WebDriver driver;
    public static ExtentTest test;  // This will be set in BaseTest per method

    public static void InitWebDriver() {
        // Instantiate driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to URL from config
        driver.get(ConfigReader.getProperty("url"));

      
    }

    public static void QuitDriver() {
        if (driver != null) {
            driver.quit();
            if (test != null) {
                test.info("Browser closed successfully.");
            }
        }
    }
}
