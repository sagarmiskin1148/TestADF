package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utils.ColorUtil;
import utils.ConfigReader;
import customAnnotation.TestId;
import pages.BasePage;
import pages.DashboardPage;

public class LoginTests extends BaseTest 
{
    
    @Test(priority = 1, description = "Verify UI elements of the login page including labels, placeholders, and buttons")
    @TestId(id = "ADF-1")
    public void validateLoginUI()
    {
  
        test.log(Status.INFO, "Step 1: Verifying label text...");
        String expectedUsernameLabel = "E-Mail Address";
        String actualUsernameLabel = loginPage.getUserName();
        Assert.assertEquals(actualUsernameLabel, expectedUsernameLabel, "Incorrect label for username field");
        test.log(Status.PASS, "Username Label: Expected='" + expectedUsernameLabel + "', Actual='" + actualUsernameLabel + "'");

        String expectedPasswordLabel = "Password";
        String actualPasswordLabel = loginPage.getPasswordLabelText();
        Assert.assertEquals(actualPasswordLabel, expectedPasswordLabel, "Incorrect label for password field");
        test.log(Status.PASS, "Password Label: Expected='" + expectedPasswordLabel + "', Actual='" + actualPasswordLabel + "'");

        
        test.log(Status.INFO, "Step 2: Verifying positions of input fields...");
        Assert.assertTrue(loginPage.isEmailInputBelowLabel(), "Email input should be below its label");
        Assert.assertTrue(loginPage.isPasswordInputBelowLabel(), "Password input should be below its label");
        test.log(Status.PASS, "Input fields positions verified");

        
        test.log(Status.INFO, "Step 3: Verifying placeholders...");
        String expectedEmailPlaceholder = "E.g., your.name@company.com";
        String expectedPasswordPlaceholder = "Enter your password";
        Assert.assertEquals(loginPage.getEmailPlaceholder(), expectedEmailPlaceholder, "Email placeholder mismatch");
        Assert.assertEquals(loginPage.getPasswordPlaceholder(), expectedPasswordPlaceholder, "Password placeholder mismatch");
        test.log(Status.PASS, "Placeholders verified");

        
        test.log(Status.INFO, "Step 4: Verifying eye icon visibility...");
        Assert.assertTrue(loginPage.isEyeIconDisplayed(), "Eye icon should be visible");
        test.log(Status.PASS, "Eye icon is visible");

        
        test.log(Status.INFO, "Step 5: Verifying Forgot Password link...");
        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed(), "Forgot Password link should be displayed");
        Assert.assertTrue(loginPage.isForgotPasswordLinkClickable(), "Forgot Password link should be clickable");
        test.log(Status.PASS, "Forgot Password link is displayed and clickable");

        
        test.log(Status.INFO, "Step 6: Verifying login button...");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button should be visible");

        String expectedButtonText = "Log in";
        String actualButtonText = loginPage.getLoginButtonText();
        Assert.assertEquals(actualButtonText, expectedButtonText, "Login button text mismatch");
        Assert.assertTrue(loginPage.IsLoginButtonEnabled(), "Login button should be enabled");
        test.log(Status.PASS, "Login button: Expected Text='" + expectedButtonText + "', Actual='" + actualButtonText + "'");

        
        String actualColor = loginPage.getLoginButtonColor();
        String actualColorName = ColorUtil.getColorFromRGBValue(actualColor);

        test.log(Status.INFO, "Login Button Color: RGBA='" + actualColor + "', Interpreted as: " + actualColorName);
        Assert.assertEquals(actualColorName, "Blue", "Login button color mismatch");
        test.log(Status.PASS, "Login button color is correct");

        
        int expectedWidth = 455;
        int expectedHeight = 48;
        int actualWidth = loginPage.getLoginButtonWidth();
        int actualHeight = loginPage.getLoginButtonHeight();
        test.log(Status.INFO, "Login Button Size: Expected Width=" + expectedWidth + ", Height=" + expectedHeight +
              " | Actual Width=" + actualWidth + ", Height=" + actualHeight);
        Assert.assertEquals(actualWidth, expectedWidth, "Login button width mismatch");
        Assert.assertEquals(actualHeight, expectedHeight, "Login button height mismatch");
        test.log(Status.PASS, "Login button size is correct");

        
        test.log(Status.INFO, "Step 9: Verifying label color and font size...");
        
        String actualFontColor = loginPage.getLabelColor(loginPage.emailLabel);
        String colorName = ColorUtil.getColorFromRGBValue(actualFontColor);
        test.log(Status.INFO, "Label Font Color: RGBA='" + actualFontColor + "', Interpreted as: " + colorName);
        Assert.assertEquals(colorName, "DarkGray", "Label font color mismatch");
        
        test.log(Status.PASS, "Label font color are correct");

        
        String expectedFontSize = "13.33px";
        String actualFontSize = loginPage.getLabelFontSize(loginPage.emailLabel);       
        test.log(Status.INFO, "Label Font Size: Expected='" + expectedFontSize + "', Actual='" + actualFontSize + "'");      
        Assert.assertEquals(actualFontSize, expectedFontSize, "Label font size mismatch");
        
        test.log(Status.PASS, "Label font size are correct");

        
        test.log(Status.INFO, "Step 10: Verifying input field font size...");
        String expectedInputFontSize = "16px";
        String actualInputFontSize = loginPage.getInputFontSize(loginPage.emailInput);
        test.log(Status.INFO, "Input Font Size: Expected='" + expectedInputFontSize + "', Actual='" + actualInputFontSize + "'");
        Assert.assertEquals(actualInputFontSize, expectedInputFontSize, "Input font size mismatch");
        test.log(Status.PASS, "Input font size is correct");

        test.log(Status.PASS, "All UI validation steps passed successfully");
    }
    
    
    @Test(priority = 2, description = "Verify positions and visibility of login form elements")
    @TestId(id = "ADF-2")
    public void validateLoginFormElementPositions() {
        test.log(Status.INFO, "Verifying positions of login form UI elements...");

        test.log(Status.INFO, "Step 1: Checking if email input is below its label...");
        Assert.assertTrue(loginPage.isEmailInputBelowLabel(), "Email input should be below its label");
        test.log(Status.PASS, "Email input is correctly positioned below its label");

        test.log(Status.INFO, "Step 2: Checking if password input is below its label...");
        Assert.assertTrue(loginPage.isPasswordInputBelowLabel(), "Password input should be below its label");
        test.log(Status.PASS, "Password input is correctly positioned below its label");

        test.log(Status.INFO, "Step 3: Checking if email label is above email input...");
        Assert.assertTrue(loginPage.isEmailLabelAboveEmailInput(), "Email label should be above email input");
        test.log(Status.PASS, "Email label is correctly positioned above email input");

        test.log(Status.INFO, "Step 4: Checking if password label is above password input...");
        Assert.assertTrue(loginPage.isPasswordLabelAbovePasswordInput(), "Password label should be above password input");
        test.log(Status.PASS, "Password label is correctly positioned above password input");

         

        test.log(Status.INFO, "Step 5: Checking if password label is below email error...");
        Assert.assertTrue(loginPage.isPasswordLabelBelowEmailError(), "Password label should be below email error");
        test.log(Status.PASS, "Password label is correctly positioned below email error");

        test.log(Status.INFO, "Step 6: Checking if forgot password link is below password error...");
        Assert.assertTrue(loginPage.isForgotPasswordLinkBelowPasswordError(), "Forgot password link should be below password error");
        test.log(Status.PASS, "Forgot password link is correctly positioned below password error");

        test.log(Status.INFO, "Step 7: Checking if login button is below forgot password link...");
        Assert.assertTrue(loginPage.isLoginButtonBelowForgotPasswordLink(), "Login button should be below forgot password link");
        test.log(Status.PASS, "Login button is correctly positioned below forgot password link");

        test.log(Status.PASS, "All login form UI element position validations passed successfully");
        
        
    }
    @Test(priority =3, description = "Verify error when both username and password fields are left blank")
    @TestId(id = "ADF-3")
    public void loginWithBlankUsernameAndPassword() 
    {
        
    	test.log(Status.INFO, "Login With Blank Username And Password");
    	
    	loginPage.enterUserName("");
    	loginPage.enterPassword("");
    	test.log(Status.INFO, "Blank UserName And Password conform");
    	
    	loginPage.clickLoginButton();
  
        
        String emailError=loginPage.getUsernameErrorMessage();
        String passwordError=loginPage.getPasswordErrorMessage();
        
        test.log(Status.INFO, "Email error message: " + emailError);
        test.log(Status.INFO, "Password error message: " + passwordError);
        
        
        Assert.assertEquals(emailError, "Email address or username required.", "Email error message mismatch");
        Assert.assertEquals(passwordError, "Password required.", "Password error message mismatch");
        
        
        test.log(Status.PASS, "Error messages for blank username and password are displayed correctly");       
    }
    
    @Test(priority = 4, description = "Verify error messages when email is blank but password is filled")
    @TestId(id = "ADF-4")
    public void loginWithBlankEmailButFilledPassword() throws InterruptedException 
    {
    	test.log(Status.INFO, "Login With Blank UserName but Filled Password");
    	
    	loginPage.enterUserName("");
    	loginPage.enterPassword("!QAZxsw2");
    	
    	test.log(Status.INFO, "Blank UserName And Filled Password Entered");    	
 
    	loginPage.clickLoginButton();
        
    	Thread.sleep(2000);
       
        String emailError=loginPage.getUsernameErrorMessage();
        String passwordError=loginPage.getPasswordErrorMessage();
        
        
        test.log(Status.INFO, "Email error message: " + emailError);
        test.log(Status.INFO, "Password error message: " + passwordError);
        
        Assert.assertEquals(emailError, "Email address or username required.", "Email error message mismatch");
        Assert.assertTrue(passwordError.isEmpty() || passwordError == null, "Unexpected password error message displayed");
        test.log(Status.PASS, "No password error message as password was filled");
        
        test.log(Status.PASS, "Error messages for blank username displayed correctly");
    }
    
    @Test(priority= 5, description = "Verify error messages when password is blank but email is filled")
    @TestId(id = "ADF-5")
    public void loginWithBlankPasswordButFilledEmail() throws InterruptedException
    {
    	loginPage.enterUserName("gold_an0206@yopmail.com");
    	loginPage.enterPassword("");
    	
    	test.log(Status.INFO, "Blank Password And Filled Username Entered"); 
    	
    	loginPage.clickLoginButton();
     
        Thread.sleep(2000);
        
        String emailError=loginPage.getUsernameErrorMessage();
        String passwordError=loginPage.getPasswordErrorMessage();
        
        test.log(Status.INFO, "Email error message: " + emailError);
        test.log(Status.INFO, "Password error message: " + passwordError);
        
        
        Assert.assertEquals(passwordError, "Password required.", "Password error message mismatch");
        
        Assert.assertTrue(emailError.isEmpty() || emailError == null, "Unexpected username error message displayed");
        test.log(Status.PASS, "No username error message as username was filled");
        
        test.log(Status.PASS, "Error messages for blank password displayed correctly");  	
  
    	
    }
    
    @Test(priority = 6, description = "Verify login fails with valid username and invalid password")
    @TestId(id = "ADF-6")
    public void loginWithValidUsernameInvalidPassword() {
        loginPage.enterUserName("gold_an0206@yopmail.com");
        loginPage.enterPassword("!QAZvfrdg");

        test.log(Status.INFO, "Valid username and invalid password entered");

        loginPage.clickLoginButton();

        String expectedError = "Your login attempt was not successful. Please try again.";  
        String actualError = loginPage.getloginFailureErrorMessage();

        test.log(Status.INFO, "Login error message: " + actualError);

        Assert.assertEquals(actualError, expectedError, "Login error message mismatch");
        test.log(Status.PASS, "Login error message verified successfully");
    }
    
 
    
    @Test(priority = 7, description = "Verify successful login with valid username and password")
    @TestId(id = "ADF-7")
    public void validateValidLogin() throws InterruptedException {

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        test.log(Status.INFO, "Waiting for username textbox to be visible...");
        Thread.sleep(2000);
        Assert.assertTrue(loginPage.isUsernameTextboxDisplayed(), "Username textbox should be displayed");

        test.log(Status.INFO, "Entering username...");
        loginPage.enterUserName(username);
        test.log(Status.PASS, "Username textbox is visible and Username entered successfully");

        test.log(Status.INFO, "Waiting for password textbox to be visible...");
        Assert.assertTrue(loginPage.isPasswordTextboxDisplayed(), "Password textbox should be displayed");

        test.log(Status.INFO, "Entering password...");
        loginPage.enterPassword(password);
        test.log(Status.PASS, "Password textbox is visible and Password entered successfully");

        
        
        loginPage.clickLoginButton();
     
        
        DashboardPage dashboardPage = new DashboardPage();

        String expectedUrl = "https://www.audio-digest.org/Dashboard";
        WebDriverWait wait = new WebDriverWait(BasePage.driver, Duration.ofSeconds(20));

        test.log(Status.INFO, "Waiting for Dashboard page URL to be loaded...");
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualUrl = dashboardPage.getCurrentPageUrl(); 
        Assert.assertEquals(actualUrl, expectedUrl, "URL after login should be Dashboard page");

        test.log(Status.PASS, "Successfully navigated to Dashboard page. Current URL: " + actualUrl);
    }


    

}
