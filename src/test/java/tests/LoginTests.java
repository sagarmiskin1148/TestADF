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

        getExtentTest().log(Status.INFO, "Waiting for username textbox to be visible...");
        Thread.sleep(2000);
        Assert.assertTrue(loginPage.isUsernameTextboxDisplayed(), "Username textbox should be displayed");

        getExtentTest().log(Status.INFO, "Entering username...");
        loginPage.enterUserName(username);
        getExtentTest().log(Status.PASS, "Username textbox is visible and Username entered successfully");

        getExtentTest().log(Status.INFO, "Waiting for password textbox to be visible...");
        Assert.assertTrue(loginPage.isPasswordTextboxDisplayed(), "Password textbox should be displayed");

        getExtentTest().log(Status.INFO, "Entering password...");
        loginPage.enterPassword(password);
        getExtentTest().log(Status.PASS, "Password textbox is visible and Password entered successfully");

        getExtentTest().log(Status.INFO, "Clicking on Login button...");
        Assert.assertTrue(loginPage.IsLoginButtonEnabled(), "Login button should be enabled");
        loginPage.clickLoginButton();
        getExtentTest().log(Status.PASS, "Login button clicked successfully");
    }

    @Test(priority = 2)
    public void validateLoginButtonStatus() 
    {
        getExtentTest().log(Status.INFO, "Verifying if login button is enabled by default...");
        Assert.assertTrue(loginPage.IsLoginButtonEnabled(), "Login button should be enabled by default");
        getExtentTest().log(Status.PASS, "Login button is enabled by default");
    }

    @Test(priority = 3)
    public void validateLoginUI()
    {
    	

        
        getExtentTest().log(Status.INFO, "Step 1: Verifying label text...");
        String expectedUsernameLabel = "E-Mail Address";
        String actualUsernameLabel = loginPage.getUsernameLabelText();
        Assert.assertEquals(actualUsernameLabel, expectedUsernameLabel, "Incorrect label for username field");
        getExtentTest().log(Status.PASS, "Username Label: Expected='" + expectedUsernameLabel + "', Actual='" + actualUsernameLabel + "'");

        String expectedPasswordLabel = "Password";
        String actualPasswordLabel = loginPage.getPasswordLabelText();
        Assert.assertEquals(actualPasswordLabel, expectedPasswordLabel, "Incorrect label for password field");
        getExtentTest().log(Status.PASS, "Password Label: Expected='" + expectedPasswordLabel + "', Actual='" + actualPasswordLabel + "'");

        
        getExtentTest().log(Status.INFO, "Step 2: Verifying positions of input fields...");
        Assert.assertTrue(loginPage.isEmailInputBelowLabel(), "Email input should be below its label");
        Assert.assertTrue(loginPage.isPasswordInputBelowLabel(), "Password input should be below its label");
        getExtentTest().log(Status.PASS, "Input fields positions verified");

        
        getExtentTest().log(Status.INFO, "Step 3: Verifying placeholders...");
        String expectedEmailPlaceholder = "E.g., your.name@company.com";
        String expectedPasswordPlaceholder = "Enter your password";
        Assert.assertEquals(loginPage.getEmailPlaceholder(), expectedEmailPlaceholder, "Email placeholder mismatch");
        Assert.assertEquals(loginPage.getPasswordPlaceholder(), expectedPasswordPlaceholder, "Password placeholder mismatch");
        getExtentTest().log(Status.PASS, "Placeholders verified");

        
        getExtentTest().log(Status.INFO, "Step 4: Verifying eye icon visibility...");
        Assert.assertTrue(loginPage.isEyeIconDisplayed(), "Eye icon should be visible");
        getExtentTest().log(Status.PASS, "Eye icon is visible");

        
        getExtentTest().log(Status.INFO, "Step 5: Verifying Forgot Password link...");
        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed(), "Forgot Password link should be displayed");
        Assert.assertTrue(loginPage.isForgotPasswordLinkClickable(), "Forgot Password link should be clickable");
        getExtentTest().log(Status.PASS, "Forgot Password link is displayed and clickable");

        
        getExtentTest().log(Status.INFO, "Step 6: Verifying login button...");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button should be visible");

        String expectedButtonText = "Log in";
        String actualButtonText = loginPage.getLoginButtonText();
        Assert.assertEquals(actualButtonText, expectedButtonText, "Login button text mismatch");
        Assert.assertTrue(loginPage.IsLoginButtonEnabled(), "Login button should be enabled");
        getExtentTest().log(Status.PASS, "Login button: Expected Text='" + expectedButtonText + "', Actual='" + actualButtonText + "'");

        
        String expectedColor = "rgba(0, 122, 195, 1)";
        String actualColor = loginPage.getLoginButtonColor();
        getExtentTest().log(Status.INFO, "Login Button Color: Expected='" + expectedColor + "', Actual='" + actualColor + "'");
        Assert.assertEquals(actualColor, expectedColor, "Login button color mismatch");
        getExtentTest().log(Status.PASS, "Login button color is correct");

        
        int expectedWidth = 455;
        int expectedHeight = 48;
        int actualWidth = loginPage.getLoginButtonWidth();
        int actualHeight = loginPage.getLoginButtonHeight();
        getExtentTest().log(Status.INFO, "Login Button Size: Expected Width=" + expectedWidth + ", Height=" + expectedHeight +
              " | Actual Width=" + actualWidth + ", Height=" + actualHeight);
        Assert.assertEquals(actualWidth, expectedWidth, "Login button width mismatch");
        Assert.assertEquals(actualHeight, expectedHeight, "Login button height mismatch");
        getExtentTest().log(Status.PASS, "Login button size is correct");

        
        getExtentTest().log(Status.INFO, "Step 9: Verifying label font size and color...");
        String expectedFontSize = "13.33px";
        String expectedFontColor = "rgba(35, 35, 35, 1)";
        String actualFontSize = loginPage.getLabelFontSize(loginPage.emailLabel);
        String actualFontColor = loginPage.getLabelColor(loginPage.emailLabel);
        getExtentTest().log(Status.INFO, "Label Font Size: Expected='" + expectedFontSize + "', Actual='" + actualFontSize + "'");
        getExtentTest().log(Status.INFO, "Label Font Color: Expected='" + expectedFontColor + "', Actual='" + actualFontColor + "'");
        Assert.assertEquals(actualFontSize, expectedFontSize, "Label font size mismatch");
        Assert.assertEquals(actualFontColor, expectedFontColor, "Label color mismatch");
        getExtentTest().log(Status.PASS, "Label font size and color are correct");

        
        getExtentTest().log(Status.INFO, "Step 10: Verifying input field font size...");
        String expectedInputFontSize = "16px";
        String actualInputFontSize = loginPage.getInputFontSize(loginPage.emailInput);
        getExtentTest().log(Status.INFO, "Input Font Size: Expected='" + expectedInputFontSize + "', Actual='" + actualInputFontSize + "'");
        Assert.assertEquals(actualInputFontSize, expectedInputFontSize, "Input font size mismatch");
        getExtentTest().log(Status.PASS, "Input font size is correct");

        getExtentTest().log(Status.PASS, "All UI validation steps passed successfully");
    }
}
