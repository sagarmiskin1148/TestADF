package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.BasePage;
import pages.LoginPage;

public class BaseTest {
	
	LoginPage loginPage;
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		BasePage.InitWebDriver();
		loginPage = new LoginPage();
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		BasePage.QuitDriver();
	}

}
