package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public static WebDriver driver;
	
	public static void InitWebDriver()
	{
		// instantiate Driver
		// navigate to base url
	}
	
	public static void QuitDriver()
	{
		driver.quit();
	}

}
