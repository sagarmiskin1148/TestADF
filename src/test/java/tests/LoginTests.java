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

public class LoginTests extends BaseTest {

    // ------------------- UI Test Cases -------------------

    @Test(priority = 1, description = "Verify username label text")
    @TestId(id = "ADF-LOGIN-UI-001")
    public void verifyUsernameLabelText() {
        test.log(Status.INFO, "Verifying Username Label Text");
        String expected = "E-Mail Address";
        String actual = loginPage.getUserName();
        Assert.assertEquals(actual, expected, "Username label mismatch");
        test.log(Status.PASS, "Username label verified: " + actual);
    }

    @Test(priority = 2, description = "Verify password label text")
    @TestId(id = "ADF-LOGIN-UI-002")
    public void verifyPasswordLabelText() {
        test.log(Status.INFO, "Verifying Password Label Text");
        String expected = "Password";
        String actual = loginPage.getPasswordLabelText();
        Assert.assertEquals(actual, expected, "Password label mismatch");
        test.log(Status.PASS, "Password label verified: " + actual);
    }

    @Test(priority = 3, description = "Verify email placeholder")
    @TestId(id = "ADF-LOGIN-UI-003")
    public void verifyEmailPlaceholder() {
        test.log(Status.INFO, "Verifying Email Placeholder");
        String expected = "E.g., your.name@company.com";
        String actual = loginPage.getEmailPlaceholder();
        Assert.assertEquals(actual, expected, "Email placeholder mismatch");
        test.log(Status.PASS, "Email placeholder verified: " + actual);
    }

    @Test(priority = 4, description = "Verify password placeholder")
    @TestId(id = "ADF-LOGIN-UI-004")
    public void verifyPasswordPlaceholder() {
        test.log(Status.INFO, "Verifying Password Placeholder");
        String expected = "Enter your password";
        String actual = loginPage.getPasswordPlaceholder();
        Assert.assertEquals(actual, expected, "Password placeholder mismatch");
        test.log(Status.PASS, "Password placeholder verified: " + actual);
    }

    @Test(priority = 5, description = "Verify eye icon visibility")
    @TestId(id = "ADF-LOGIN-UI-005")
    public void verifyEyeIconVisibility() {
        test.log(Status.INFO, "Checking Eye Icon visibility");
        Assert.assertTrue(loginPage.isEyeIconDisplayed(), "Eye icon should be visible");
        test.log(Status.PASS, "Eye icon is visible");
    }

    @Test(priority = 6, description = "Verify Forgot Password link visibility and clickability")
    @TestId(id = "ADF-LOGIN-UI-006")
    public void verifyForgotPasswordLink() {
        test.log(Status.INFO, "Checking Forgot Password link visibility and clickability");
        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed(), "Forgot Password link should be visible");
        Assert.assertTrue(loginPage.isForgotPasswordLinkClickable(), "Forgot Password link should be clickable");
        test.log(Status.PASS, "Forgot Password link is visible and clickable");
    }

    @Test(priority = 7, description = "Verify login button visibility, text, and enablement")
    @TestId(id = "ADF-LOGIN-UI-007")
    public void verifyLoginButtonProperties() {
        test.log(Status.INFO, "Verifying Login Button visibility and text");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button should be displayed");
        Assert.assertEquals(loginPage.getLoginButtonText(), "Log in", "Login button text mismatch");
        Assert.assertTrue(loginPage.IsLoginButtonEnabled(), "Login button should be enabled");
        test.log(Status.PASS, "Login button properties verified");
    }

    @Test(priority = 8, description = "Verify login button color")
    @TestId(id = "ADF-LOGIN-UI-008")
    public void verifyLoginButtonColor() {
        test.log(Status.INFO, "Verifying Login Button Color");
        String actualColor = loginPage.getLoginButtonColor();
        String actualColorName = ColorUtil.getColorFromRGBValue(actualColor);
        Assert.assertEquals(actualColorName, "Blue", "Login button color mismatch");
        test.log(Status.PASS, "Login button color is correct: " + actualColorName);
    }

    @Test(priority = 9, description = "Verify login button size")
    @TestId(id = "ADF-LOGIN-UI-009")
    public void verifyLoginButtonSize() {
        test.log(Status.INFO, "Verifying Login Button Size");
        int expectedWidth = 455;
        int expectedHeight = 48;
        Assert.assertEquals(loginPage.getLoginButtonWidth(), expectedWidth, "Login button width mismatch");
        Assert.assertEquals(loginPage.getLoginButtonHeight(), expectedHeight, "Login button height mismatch");
        test.log(Status.PASS, "Login button size is correct");
    }

    // ------------------- Position Test Cases -------------------

    @Test(priority = 10, description = "Verify email input is below its label")
    @TestId(id = "ADF-LOGIN-UI-010")
    public void verifyEmailInputBelowLabel() {
        Assert.assertTrue(loginPage.isEmailInputBelowLabel(), "Email input should be below its label");
        test.log(Status.PASS, "Email input is correctly positioned below its label");
    }

    @Test(priority = 11, description = "Verify password input is below its label")
    @TestId(id = "ADF-LOGIN-UI-011")
    public void verifyPasswordInputBelowLabel() {
        Assert.assertTrue(loginPage.isPasswordInputBelowLabel(), "Password input should be below its label");
        test.log(Status.PASS, "Password input is correctly positioned below its label");
    }

    @Test(priority = 12, description = "Verify email label is above email input")
    @TestId(id = "ADF-LOGIN-UI-012")
    public void verifyEmailLabelAboveInput() {
        Assert.assertTrue(loginPage.isEmailLabelAboveEmailInput(), "Email label should be above email input");
        test.log(Status.PASS, "Email label is correctly positioned above email input");
    }

    @Test(priority = 13, description = "Verify password label is above password input")
    @TestId(id = "ADF-LOGIN-UI-013")
    public void verifyPasswordLabelAboveInput() {
        Assert.assertTrue(loginPage.isPasswordLabelAbovePasswordInput(), "Password label should be above password input");
        test.log(Status.PASS, "Password label is correctly positioned above password input");
    }

    @Test(priority = 14, description = "Verify password label is below email error")
    @TestId(id = "ADF-LOGIN-UI-014")
    public void verifyPasswordLabelBelowEmailError() {
        Assert.assertTrue(loginPage.isPasswordLabelBelowEmailError(), "Password label should be below email error");
        test.log(Status.PASS, "Password label is correctly positioned below email error");
    }

    @Test(priority = 15, description = "Verify forgot password link is below password error")
    @TestId(id = "ADF-LOGIN-UI-015")
    public void verifyForgotPasswordLinkBelowError() {
        Assert.assertTrue(loginPage.isForgotPasswordLinkBelowPasswordError(), "Forgot password link should be below password error");
        test.log(Status.PASS, "Forgot password link is correctly positioned below password error");
    }

    @Test(priority = 16, description = "Verify login button is below forgot password link")
    @TestId(id = "ADF-LOGIN-UI-016")
    public void verifyLoginButtonBelowForgotPasswordLink() {
        Assert.assertTrue(loginPage.isLoginButtonBelowForgotPasswordLink(), "Login button should be below forgot password link");
        test.log(Status.PASS, "Login button is correctly positioned below forgot password link");
    }

    // ------------------- Functional Test Cases -------------------

    @Test(priority = 17, description = "Verify login with blank username and password")
    @TestId(id = "ADF-LOGIN-FUNC-017")
    public void loginWithBlankUsernameAndPassword() {
        test.log(Status.INFO, "Trying to login with blank username and password");
        loginPage.enterUserName("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Email address or username required.");
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Password required.");
        test.log(Status.PASS, "Blank credentials error messages verified");
    }

    @Test(priority = 18, description = "Verify login with blank email and filled password")
    @TestId(id = "ADF-LOGIN-FUNC-018")
    public void loginWithBlankEmail() {
        test.log(Status.INFO, "Trying to login with blank email");
        loginPage.enterUserName("");
        loginPage.enterPassword("!QAZxsw2");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Email address or username required.");
        test.log(Status.PASS, "Blank email error message verified");
    }

    @Test(priority = 19, description = "Verify login with filled email and blank password")
    @TestId(id = "ADF-LOGIN-FUNC-019")
    public void loginWithBlankPassword() {
        test.log(Status.INFO, "Trying to login with blank password");
        loginPage.enterUserName("gold_an1208@yopmail.com");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Password required.");
        test.log(Status.PASS, "Blank password error message verified");
    }

    @Test(priority = 20, description = "Verify login fails with valid username and invalid password")
    @TestId(id = "ADF-LOGIN-FUNC-020")
    public void loginWithInvalidPassword() {
        test.log(Status.INFO, "Trying to login with invalid password");
        loginPage.enterUserName("gold_an1208@yopmail.com");
        loginPage.enterPassword("wrongPass123");
        loginPage.clickLoginButton();
        String actual = loginPage.getloginFailureErrorMessage();
        Assert.assertEquals(actual, "Your login attempt was not successful. Please try again.");
        test.log(Status.PASS, "Invalid login error message verified");
    }

    @Test(priority = 21, description = "Verify login with valid credentials")
    @TestId(id = "ADF-LOGIN-FUNC-021")
    public void loginWithValidCredentials() {
        test.log(Status.INFO, "Trying to login with valid credentials");
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        DashboardPage dashboardPage = new DashboardPage();
        String expectedUrl = "https://www.audio-digest.org/Dashboard";
        WebDriverWait wait = new WebDriverWait(BasePage.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualUrl = dashboardPage.getCurrentPageUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        test.log(Status.PASS, "Successfully logged in. Navigated to Dashboard: " + actualUrl);
    }
}
