package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ConfigReader;
import customAnnotation.TestId;

public class LoginTests extends BaseTest {

    @Test(priority=1)
    @TestId(id = "123456")
    public void validateValidLogin() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        
        System.out.println("Entering username...");
        loginPage.enterUserName(username);
        Assert.assertTrue(loginPage.isUsernameTextboxDisplayed(), "Username textbox is displayed");
        System.out.println("Username entered successfully and textbox is visible");

        
        
        System.out.println("Entering password...");
        loginPage.enterPassword(password);
        Assert.assertTrue(loginPage.isPasswordTextboxDisplayed(), "Password textbox is displayed");
        System.out.println("Password entered successfully and textbox is visible");


        
        System.out.println("Click On LoginButton...");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.IsLoginButtonEnabled(), "Login button is not enabled");
        System.out.println("Login button clicked successfully");


        
        
    }

    @Test(priority=2)
    public void validateLoginButtonStatus() {
        System.out.println("Verifying if login button is enabled by default...");
        Assert.assertTrue(loginPage.IsLoginButtonEnabled(), "Login button should be enabled by default");
    }

    @Test(priority=3)
    public void validateLoginUI() 
    {
        System.out.println("Verifying UI labels for login fields...");
        String usernameLabel = loginPage.getUsernameLabelText();
        String passwordLabel = loginPage.getPasswordLabelText();

        Assert.assertEquals(usernameLabel, "E-Mail Address", "Incorrect label for username field");
        Assert.assertEquals(passwordLabel, "Password", "Incorrect label for password field");

        System.out.println("UI label validation passed.");
    }     
        

    @Test(priority=4)
    public void validateLoginUIErrorMessages() 
    {
        System.out.println("Clicking login button without entering credentials...");
        loginPage.clickLoginButton();

        System.out.println("Verifying error messages for empty username and password...");
        
        String usernameError = loginPage.getUsernameErrorMessage();
        String passwordError = loginPage.getPasswordErrorMessage();

        System.out.println("Username Error Message Displayed: " + usernameError);
        System.out.println("Password Error Message Displayed: " + passwordError);

        Assert.assertEquals(usernameError.trim(), "Email address or username required", "Username error message is incorrect");
        Assert.assertEquals(passwordError.trim(), "Password required", "Password error message is incorrect");
    }  
 }

