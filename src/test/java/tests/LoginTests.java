package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.customAnnotations.TestId;

public class LoginTests extends BaseTest{
	
	@Test
	@TestId(id="123456")
	//@Description(description="Valiating valid username")
	public void valdiateValidLogin()
	{
		String username="";
		loginPage.enterUserName(username);
		Assert.assertTrue(loginPage.getUserName().equalsIgnoreCase(username), "The entered username is not displayed in login textbox");
		
		loginPage.enterPassword("");
		
		
		loginPage.clickLoginButton();
	}
	
	@Test
	public void validateLoginButtonStatus()
	{
		
	}
	
	@Test	
	public void validateLoginUI()
	{
		
	}
	
	@Test
	public void validateLoginUIErrorMessages()
	{
		
	}

}
