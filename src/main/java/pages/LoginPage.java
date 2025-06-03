package pages;

import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;

public class LoginPage extends BasePage {

    public By emailLabel = By.xpath("//label[normalize-space()='E-Mail Address']");
    public By emailInput = By.xpath("//input[@id='TxtUserName']");
    private By emailError = By.xpath("//span[@id='reqUserName']");

    private By passwordLabel = By.xpath("//label[normalize-space()='Password']");
    private By passwordInput = By.xpath("//input[@id='TxtPassword']");
    private By passwordError = By.xpath("//span[@id='reqPassword']");

    private By loginButton = By.xpath("//input[@id='container_0_LbLogin']");
    private By eyeIcon = By.xpath("//span[@class='fa fa-fw fa-eye field-icon perchahage-flow-toggle-password ']");
    private By forgotPasswordLink = By.xpath("//a[@id='container_0_HlForgotPassword']");

    public void enterUserName(String username) {
        test.log(Status.INFO, "Entering username: " + username);
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(username);
        test.log(Status.INFO, "Username entered successfully.");
    }

    public void enterPassword(String password) {
        test.log(Status.INFO, "Entering password.");
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        test.log(Status.INFO, "Password entered successfully.");
    }

    public void clickLoginButton() {
        test.log(Status.INFO, "Clicking on Login button.");
        driver.findElement(loginButton).click();
        test.log(Status.INFO, "Login button clicked.");
    }

    public String getUserName() {
        test.log(Status.INFO, "Fetching username from input field.");
        String username = driver.findElement(emailInput).getAttribute("value");
        test.log(Status.INFO, "Username fetched: " + username);
        return username;
    }

    public boolean IsLoginButtonEnabled() {
        test.log(Status.INFO, "Checking if Login button is enabled.");
        boolean result = driver.findElement(loginButton).isEnabled();
        test.log(Status.INFO, "Login button enabled: " + result);
        return result;
    }

    public String getInputFontSize(By input) {
        test.log(Status.INFO, "Getting font-size for input field.");
        String size = driver.findElement(input).getCssValue("font-size");
        test.log(Status.INFO, "Font size: " + size);
        return size;
    }

    public String getUsernameLabelText() {
        test.log(Status.INFO, "Fetching text from username label.");
        String text = driver.findElement(emailLabel).getText();
        test.log(Status.INFO, "Username label text: " + text);
        return text;
    }

    public String getPasswordLabelText() {
        test.log(Status.INFO, "Fetching text from password label.");
        String text = driver.findElement(passwordLabel).getText();
        test.log(Status.INFO, "Password label text: " + text);
        return text;
    }

    public String getUsernameErrorMessage() {
        test.log(Status.INFO, "Fetching error message for username.");
        String error = driver.findElement(emailError).getText();
        test.log(Status.INFO, "Username error message: " + error);
        return error;
    }

    public String getPasswordErrorMessage() {
        test.log(Status.INFO, "Fetching error message for password.");
        String error = driver.findElement(passwordError).getText();
        test.log(Status.INFO, "Password error message: " + error);
        return error;
    }

    public boolean isUsernameTextboxDisplayed() {
        test.log(Status.INFO, "Checking if username textbox is displayed.");
        boolean result = driver.findElement(emailInput).isDisplayed();
        test.log(Status.INFO, "Username textbox displayed: " + result);
        return result;
    }

    public boolean isPasswordTextboxDisplayed() {
        test.log(Status.INFO, "Checking if password textbox is displayed.");
        boolean result = driver.findElement(passwordInput).isDisplayed();
        test.log(Status.INFO, "Password textbox displayed: " + result);
        return result;
    }

    public String getEmailPlaceholder() {
        test.log(Status.INFO, "Fetching placeholder for email input.");
        String placeholder = driver.findElement(emailInput).getAttribute("placeholder");
        test.log(Status.INFO, "Email placeholder: " + placeholder);
        return placeholder;
    }

    public String getPasswordPlaceholder() {
        test.log(Status.INFO, "Fetching placeholder for password input.");
        String placeholder = driver.findElement(passwordInput).getAttribute("placeholder");
        test.log(Status.INFO, "Password placeholder: " + placeholder);
        return placeholder;
    }

    public boolean isEyeIconDisplayed() {
        test.log(Status.INFO, "Checking if eye icon is displayed.");
        boolean result = driver.findElement(eyeIcon).isDisplayed();
        test.log(Status.INFO, "Eye icon displayed: " + result);
        return result;
    }

    public boolean isForgotPasswordLinkDisplayed() {
        test.log(Status.INFO, "Checking if forgot password link is displayed.");
        boolean result = driver.findElement(forgotPasswordLink).isDisplayed();
        test.log(Status.INFO, "Forgot password link displayed: " + result);
        return result;
    }

    public boolean isForgotPasswordLinkClickable() {
        test.log(Status.INFO, "Checking if forgot password link is clickable.");
        boolean result = driver.findElement(forgotPasswordLink).isEnabled();
        test.log(Status.INFO, "Forgot password link clickable: " + result);
        return result;
    }

    public boolean isLoginButtonDisplayed() {
        test.log(Status.INFO, "Checking if login button is displayed.");
        boolean result = driver.findElement(loginButton).isDisplayed();
        test.log(Status.INFO, "Login button displayed: " + result);
        return result;
    }

    public String getLoginButtonText() {
        test.log(Status.INFO, "Getting text of login button.");
        String text = driver.findElement(loginButton).getAttribute("value");
        test.log(Status.INFO, "Login button text: " + text);
        return text;
    }

    public String getLoginButtonColor() {
        test.log(Status.INFO, "Getting color of login button.");
        String color = driver.findElement(loginButton).getCssValue("background-color");
        test.log(Status.INFO, "Login button color: " + color);
        return color;
    }

    public int getLoginButtonWidth() {
        test.log(Status.INFO, "Getting width of login button.");
        int width = driver.findElement(loginButton).getSize().getWidth();
        test.log(Status.INFO, "Login button width: " + width);
        return width;
    }

    public int getLoginButtonHeight() {
        test.log(Status.INFO, "Getting height of login button.");
        int height = driver.findElement(loginButton).getSize().getHeight();
        test.log(Status.INFO, "Login button height: " + height);
        return height;
    }

    public String getLabelFontSize(By label) {
        test.log(Status.INFO, "Getting font size of label.");
        String size = driver.findElement(label).getCssValue("font-size");
        test.log(Status.INFO, "Label font size: " + size);
        return size;
    }

    public String getLabelColor(By label) {
        test.log(Status.INFO, "Getting color of label.");
        String color = driver.findElement(label).getCssValue("color");
        test.log(Status.INFO, "Label color: " + color);
        return color;
    }

    public boolean isEmailInputBelowLabel() {
        test.log(Status.INFO, "Checking if email input is below its label.");
        boolean result = driver.findElement(emailInput).getLocation().getY() > driver.findElement(emailLabel).getLocation().getY();
        test.log(Status.INFO, "Email input below label: " + result);
        return result;
    }

    public boolean isPasswordInputBelowLabel() {
        test.log(Status.INFO, "Checking if password input is below its label.");
        boolean result = driver.findElement(passwordInput).getLocation().getY() > driver.findElement(passwordLabel).getLocation().getY();
        test.log(Status.INFO, "Password input below label: " + result);
        return result;
    }

    public boolean isEmailLabelAboveEmailInput() {
        test.log(Status.INFO, "Checking if email label is above email input.");
        boolean result = driver.findElement(emailLabel).getLocation().getY() < driver.findElement(emailInput).getLocation().getY();
        test.log(Status.INFO, "Email label above input: " + result);
        return result;
    }

    public boolean isPasswordLabelAbovePasswordInput() {
        test.log(Status.INFO, "Checking if password label is above password input.");
        boolean result = driver.findElement(passwordLabel).getLocation().getY() < driver.findElement(passwordInput).getLocation().getY();
        test.log(Status.INFO, "Password label above input: " + result);
        return result;
    }

    public boolean isPasswordLabelBelowEmailError() {
        test.log(Status.INFO, "Checking if password label is below email error message.");
        boolean result = driver.findElement(emailError).getLocation().getY() < driver.findElement(passwordLabel).getLocation().getY();
        test.log(Status.INFO, "Password label below email error: " + result);
        return result;
    }

    public boolean isForgotPasswordLinkBelowPasswordError() {
        test.log(Status.INFO, "Checking if forgot password link is below password error.");
        boolean result = driver.findElement(passwordError).getLocation().getY() < driver.findElement(forgotPasswordLink).getLocation().getY();
        test.log(Status.INFO, "Forgot password link below password error: " + result);
        return result;
    }

    public boolean isLoginButtonBelowForgotPasswordLink() {
        test.log(Status.INFO, "Checking if login button is below forgot password link.");
        boolean result = driver.findElement(forgotPasswordLink).getLocation().getY() < driver.findElement(loginButton).getLocation().getY();
        test.log(Status.INFO, "Login button below forgot password link: " + result);
        return result;
    }
}
