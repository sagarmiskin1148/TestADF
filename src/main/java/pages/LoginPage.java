package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import utils.WaitUtils;

public class LoginPage extends BasePage {

    public By emailLabel = By.xpath("//label[normalize-space()='E-Mail Address']");
    public By emailInput = By.xpath("//input[@id='TxtUserName']");
    private By emailError = By.xpath("//span[@id='reqUserName']");
    
    private By loginFailureErrorMessage=By.xpath("//span[contains(normalize-space(text()), 'Your login attempt was not successful')]");

    private By passwordLabel = By.xpath("//label[normalize-space()='Password']");
    private By passwordInput = By.xpath("//input[@id='TxtPassword']");
    private By passwordError = By.xpath("//span[@id='reqPassword']");

    private By loginButton = By.xpath("//input[@id='container_0_LbLogin']");
    private By eyeIcon = By.xpath("//span[@class='fa fa-fw fa-eye field-icon perchahage-flow-toggle-password ']");
    private By forgotPasswordLink = By.xpath("//a[@id='container_0_HlForgotPassword']");

    
    
    
    
    public void enterUserName(String username) {
        test.log(Status.INFO, "Entering Username in login form.");
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(username);
        test.log(Status.INFO, "Entered Username: '" + username + "'");
    }

    public void enterPassword(String password) {
        test.log(Status.INFO, "Entering Password in login form.");
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        test.log(Status.INFO, "Entered Password successfully.");
    }

    public void clickLoginButton() {
        test.log(Status.INFO, "Clicking on Login button.");
        driver.findElement(loginButton).click();
        test.log(Status.INFO, "Login button clicked.");
    }

    public String getUserName() {
        test.log(Status.INFO, "Fetching entered Username from input field.");
        String username = driver.findElement(emailInput).getAttribute("value");
        test.log(Status.INFO, "Username retrieved: '" + username + "'");
        return username;
    }

    public boolean IsLoginButtonEnabled() {
        test.log(Status.INFO, "Checking if Login button is enabled.");
        boolean result = driver.findElement(loginButton).isEnabled();
        test.log(Status.INFO, "Login button enabled status: " + result);
        return result;
    }

    public String getInputFontSize(By input) {
        test.log(Status.INFO, "Retrieving font size of input field.");
        String size = driver.findElement(input).getCssValue("font-size");
        test.log(Status.INFO, "Input field font size: " + size);
        return size;
    }

    public String getUsernameLabelText() {
        test.log(Status.INFO, "Getting label text for Username.");
        String text = driver.findElement(emailLabel).getText();
        test.log(Status.INFO, "Username label text: '" + text + "'");
        return text;
    }

    public String getPasswordLabelText() {
        test.log(Status.INFO, "Getting label text for Password.");
        String text = driver.findElement(passwordLabel).getText();
        test.log(Status.INFO, "Password label text: '" + text + "'");
        return text;
    }

    public String getUsernameErrorMessage() {
        test.log(Status.INFO, "Checking for Username error message.");
        try {
            WebElement errorElement = WaitUtils.waitForVisibility(driver, emailError, 5);
            String error = errorElement.getText().trim();

            if (!error.isEmpty()) {
                test.log(Status.INFO, "Username error message found: " + error);
            } else {
                test.log(Status.INFO, "Username error message element found but text is empty.");
            }

            return error;
        } catch (TimeoutException e) {
            test.log(Status.INFO, "Timeout: Username error message not visible within wait time.");
            return "";
        } catch (NoSuchElementException e) {
            test.log(Status.INFO, "NoSuchElementException: Username error message element not found.");
            return "";
        } catch (Exception e) {
            test.log(Status.FAIL, "Unexpected error while fetching username error message: " + e.getMessage());
            return null;
        }
    }


    public String getPasswordErrorMessage() {
        test.log(Status.INFO, "Checking for Password error message.");
        try {
            WebElement errorElement = WaitUtils.waitForVisibility(driver, passwordError, 5);
            String error = errorElement.getText().trim();
            
            if (!error.isEmpty()) {
                test.log(Status.INFO, "Password error message found: " + error);
            } else {
                test.log(Status.INFO, "Password error message element found but text is empty.");
            }
            
            return error;
        } catch (TimeoutException e) {
            test.log(Status.INFO, "Timeout: Password error message not visible within wait time.");
            return "";
        } catch (NoSuchElementException e) {
            test.log(Status.INFO, "NoSuchElementException: Password error message element not found.");
            return "";
        } catch (Exception e) {
            test.log(Status.FAIL, "Unexpected error while fetching password error message: " + e.getMessage());
            return null;
        }       
        
       
    }

    
    public String getloginFailureErrorMessage() {
        test.log(Status.INFO, "Checking for login failure error message");
        try {
            WebElement errorElement = WaitUtils.waitForVisibility(driver, loginFailureErrorMessage, 20);
            String errorMsg = errorElement.getText().trim();
            if (!errorMsg.isEmpty()) {
                test.log(Status.INFO, "Login failure error message found: " + errorMsg);
            } else {
                test.log(Status.INFO, "Login failure error message element found but text is empty.");
            }
            return errorMsg;
        } catch (TimeoutException e) {
            test.log(Status.INFO, "Timeout waiting for login failure error message to appear.");
            return null;
        } catch (NoSuchElementException e) {
            test.log(Status.INFO, "Login failure error message element not found on page.");
            return null;
        } catch (Exception e) {
            test.log(Status.FAIL, "Unexpected error while fetching login failure error message: " + e.getMessage());
            return null;
        }
    }


    public boolean isUsernameTextboxDisplayed() {
        test.log(Status.INFO, "Verifying visibility of Username input box.");
        boolean result = driver.findElement(emailInput).isDisplayed();
        test.log(Status.INFO, "Username textbox displayed: " + result);
        return result;
    }

    public boolean isPasswordTextboxDisplayed() {
        test.log(Status.INFO, "Verifying visibility of Password input box.");
        boolean result = driver.findElement(passwordInput).isDisplayed();
        test.log(Status.INFO, "Password textbox displayed: " + result);
        return result;
    }

    public String getEmailPlaceholder() {
        test.log(Status.INFO, "Fetching placeholder text from Email field.");
        String placeholder = driver.findElement(emailInput).getAttribute("placeholder");
        test.log(Status.INFO, "Email placeholder: '" + placeholder + "'");
        return placeholder;
    }

    public String getPasswordPlaceholder() {
        test.log(Status.INFO, "Fetching placeholder text from Password field.");
        String placeholder = driver.findElement(passwordInput).getAttribute("placeholder");
        test.log(Status.INFO, "Password placeholder: '" + placeholder + "'");
        return placeholder;
    }

    public boolean isEyeIconDisplayed() {
        test.log(Status.INFO, "Checking if Password visibility (eye) icon is displayed.");
        boolean result = driver.findElement(eyeIcon).isDisplayed();
        test.log(Status.INFO, "Eye icon displayed: " + result);
        return result;
    }

    public boolean isForgotPasswordLinkDisplayed() {
        test.log(Status.INFO, "Checking if 'Forgot Password' link is displayed.");
        boolean result = driver.findElement(forgotPasswordLink).isDisplayed();
        test.log(Status.INFO, "'Forgot Password' link displayed: " + result);
        return result;
    }

    public boolean isForgotPasswordLinkClickable() {
        test.log(Status.INFO, "Checking if 'Forgot Password' link is clickable.");
        boolean result = driver.findElement(forgotPasswordLink).isEnabled();
        test.log(Status.INFO, "'Forgot Password' link clickable: " + result);
        return result;
    }

    public boolean isLoginButtonDisplayed() {
        test.log(Status.INFO, "Checking if Login button is displayed.");
        boolean result = driver.findElement(loginButton).isDisplayed();
        test.log(Status.INFO, "Login button displayed: " + result);
        return result;
    }

    public String getLoginButtonText() {
        test.log(Status.INFO, "Fetching text displayed on Login button.");
        String text = driver.findElement(loginButton).getAttribute("value");
        test.log(Status.INFO, "Login button text: '" + text + "'");
        return text;
    }

    public String getLoginButtonColor() {
        test.log(Status.INFO, "Fetching background color of Login button.");
        String color = driver.findElement(loginButton).getCssValue("background-color");
        test.log(Status.INFO, "Login button background color: " + color);
        return color;
    }

    public int getLoginButtonWidth() {
        test.log(Status.INFO, "Fetching width of Login button.");
        int width = driver.findElement(loginButton).getSize().getWidth();
        test.log(Status.INFO, "Login button width: " + width + " px");
        return width;
    }

    public int getLoginButtonHeight() {
        test.log(Status.INFO, "Fetching height of Login button.");
        int height = driver.findElement(loginButton).getSize().getHeight();
        test.log(Status.INFO, "Login button height: " + height + " px");
        return height;
    }

    public String getLabelFontSize(By label) {
        test.log(Status.INFO, "Retrieving font size for label.");
        String size = driver.findElement(label).getCssValue("font-size");
        test.log(Status.INFO, "Label font size: " + size);
        return size;
    }

    public String getLabelColor(By label) {
        test.log(Status.INFO, "Fetching text color of label.");
        String rgbValue = driver.findElement(label).getCssValue("color");
        String color = utils.ColorUtil.getColorFromRGBValue(rgbValue);
        test.log(Status.INFO, "Label color (converted): " + color);
        return color;
    }

    public boolean isEmailInputBelowLabel() {
        test.log(Status.INFO, "Checking if Email input field is placed below Email label.");
        boolean result = driver.findElement(emailInput).getLocation().getY() > driver.findElement(emailLabel).getLocation().getY();
        test.log(Status.INFO, "Is Email input below Email label: " + result);
        return result;
    }

    public boolean isPasswordInputBelowLabel() {
        test.log(Status.INFO, "Checking if Password input field is placed below Password label.");
        boolean result = driver.findElement(passwordInput).getLocation().getY() > driver.findElement(passwordLabel).getLocation().getY();
        test.log(Status.INFO, "Is Password input below Password label: " + result);
        return result;
    }

    public boolean isEmailLabelAboveEmailInput() {
        test.log(Status.INFO, "Checking if Email label is above Email input field.");
        boolean result = driver.findElement(emailLabel).getLocation().getY() < driver.findElement(emailInput).getLocation().getY();
        test.log(Status.INFO, "Is Email label above Email input: " + result);
        return result;
    }

    public boolean isPasswordLabelAbovePasswordInput() {
        test.log(Status.INFO, "Checking if Password label is above Password input field.");
        boolean result = driver.findElement(passwordLabel).getLocation().getY() < driver.findElement(passwordInput).getLocation().getY();
        test.log(Status.INFO, "Is Password label above Password input: " + result);
        return result;
    }

    public boolean isPasswordLabelBelowEmailError() {
        test.log(Status.INFO, "Checking if Password label is below Email error message.");
        boolean result = driver.findElement(emailError).getLocation().getY() < driver.findElement(passwordLabel).getLocation().getY();
        test.log(Status.INFO, "Is Password label below Email error: " + result);
        return result;
    }

    public boolean isForgotPasswordLinkBelowPasswordError() {
        test.log(Status.INFO, "Checking if Forgot Password link is below Password error message.");
        boolean result = driver.findElement(passwordError).getLocation().getY() < driver.findElement(forgotPasswordLink).getLocation().getY();
        test.log(Status.INFO, "Is Forgot Password link below Password error: " + result);
        return result;
    }

    public boolean isLoginButtonBelowForgotPasswordLink() {
        test.log(Status.INFO, "Checking if Login button is below Forgot Password link.");
        boolean result = driver.findElement(forgotPasswordLink).getLocation().getY() < driver.findElement(loginButton).getLocation().getY();
        test.log(Status.INFO, "Is Login button below Forgot Password link: " + result);
        return result;
    }
    
    
    public void loginValidUser() {
        
        driver.get("https://qa-cd.audio-digest.org/Login");

    
        String username = utils.ConfigReader.getProperty("username");
        String password = utils.ConfigReader.getProperty("password");

        
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();

        WaitUtils.waitForUrlToBe(driver, "https://qa-cd.audio-digest.org/Dashboard", 50);
        test.log(Status.INFO, "User logged in successfully and navigated to Dashboard");
    }
    
    
    

}
