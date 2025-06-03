package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utils.ConfigReader;
import customAnnotation.TestId;

public class LoginTests extends BaseTest 
{

    @Test(priority = 1)
    @TestId(id = "123456")
    public void validateValidLogin() throws InterruptedException
    {

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        test.log(Status.INFO, "Waiting for username textbox to be visible...");
        
        Assert.assertTrue(loginPage.isUsernameTextboxDisplayed(), "Username textbox should be displayed");

        test.log(Status.INFO, "Entering username...");
        loginPage.enterUserName(username);
        test.log(Status.PASS, "Username textbox is visible and Username entered successfully");

        test.log(Status.INFO, "Waiting for password textbox to be visible...");
        Assert.assertTrue(loginPage.isPasswordTextboxDisplayed(), "Password textbox should be displayed");

        test.log(Status.INFO, "Entering password...");
        loginPage.enterPassword(password);
        test.log(Status.PASS, "Password textbox is visible and Password entered successfully");

        test.log(Status.INFO, "Clicking on Login button...");
        Assert.assertTrue(loginPage.IsLoginButtonEnabled(), "Login button should be enabled");
        loginPage.clickLoginButton();
        test.log(Status.PASS, "Login button clicked successfully");
    }

    @Test(priority = 2)
    public void validateLoginButtonStatus() 
    {
        test.log(Status.INFO, "Verifying if login button is enabled by default...");
        Assert.assertTrue(loginPage.IsLoginButtonEnabled(), "Login button should be enabled by default");
        test.log(Status.PASS, "Login button is enabled by default");
    }

    @Test(priority = 3)
    public void validateLoginUI()
    {
    	

        
        test.log(Status.INFO, "Step 1: Verifying label text...");
        String expectedUsernameLabel = "E-Mail Address";
        String actualUsernameLabel = loginPage.getUsernameLabelText();
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

        
        String expectedColor = "rgba(0, 122, 195, 1)";
        String actualColor = loginPage.getLoginButtonColor();
        test.log(Status.INFO, "Login Button Color: Expected='" + expectedColor + "', Actual='" + actualColor + "'");
        Assert.assertEquals(actualColor, expectedColor, "Login button color mismatch");
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

        
        test.log(Status.INFO, "Step 9: Verifying label font size and color...");
        String expectedFontSize = "13.33px";
        String expectedFontColor = "rgba(35, 35, 35, 1)";
        String actualFontSize = loginPage.getLabelFontSize(loginPage.emailLabel);
        String actualFontColor = loginPage.getLabelColor(loginPage.emailLabel);
        test.log(Status.INFO, "Label Font Size: Expected='" + expectedFontSize + "', Actual='" + actualFontSize + "'");
        test.log(Status.INFO, "Label Font Color: Expected='" + expectedFontColor + "', Actual='" + actualFontColor + "'");
        Assert.assertEquals(actualFontSize, expectedFontSize, "Label font size mismatch");
        Assert.assertEquals(actualFontColor, expectedFontColor, "Label color mismatch");
        test.log(Status.PASS, "Label font size and color are correct");

        
        test.log(Status.INFO, "Step 10: Verifying input field font size...");
        String expectedInputFontSize = "16px";
        String actualInputFontSize = loginPage.getInputFontSize(loginPage.emailInput);
        test.log(Status.INFO, "Input Font Size: Expected='" + expectedInputFontSize + "', Actual='" + actualInputFontSize + "'");
        Assert.assertEquals(actualInputFontSize, expectedInputFontSize, "Input font size mismatch");
        test.log(Status.PASS, "Input font size is correct");

        test.log(Status.PASS, "All UI validation steps passed successfully");
    }
    
    
    @Test(priority = 4)
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

}
