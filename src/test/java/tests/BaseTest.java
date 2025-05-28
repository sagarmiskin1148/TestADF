package tests;

import java.io.IOException;

import org.testng.annotations.*;

import pages.BasePage;
import pages.LoginPage;

public class BaseTest {
	
	LoginPage loginPage;
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException
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
