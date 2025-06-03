package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import utils.ConfigReader;

public class BasePage {
    public static WebDriver driver;
    
    public static ExtentTest test;
    

    public static void InitWebDriver() 
    {
    	//instaciate driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        //navigate to url
        driver.get(ConfigReader.getProperty("url"));
    }

    public static void QuitDriver() {
        if (driver != null) {
            driver.quit();
            test=null;
        }
    }
}
