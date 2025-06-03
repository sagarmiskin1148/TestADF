package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Getters
    public String getUserName() {
        return driver.findElement(emailInput).getAttribute("value");
    }

    public boolean IsLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }
    
    public String getInputFontSize(By input) {
        return driver.findElement(input).getCssValue("font-size");
    }

    public String getUsernameLabelText() {
        return driver.findElement(emailLabel).getText();
    }

    public String getPasswordLabelText() {
        return driver.findElement(passwordLabel).getText();
    }

    public String getUsernameErrorMessage() {
        return driver.findElement(emailError).getText();
    }

    public String getPasswordErrorMessage() {
        return driver.findElement(passwordError).getText();
    }

    public boolean isUsernameTextboxDisplayed() {
        return driver.findElement(emailInput).isDisplayed();
    }

    public boolean isPasswordTextboxDisplayed() {
        return driver.findElement(passwordInput).isDisplayed();
    }

    public boolean isEmailInputBelowLabel() {
        return driver.findElement(emailLabel).getLocation().getY()
             < driver.findElement(emailInput).getLocation().getY();
    }

    public boolean isPasswordInputBelowLabel() {
        return driver.findElement(passwordLabel).getLocation().getY()
             < driver.findElement(passwordInput).getLocation().getY();
    }

    public String getEmailPlaceholder() {
        return driver.findElement(emailInput).getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return driver.findElement(passwordInput).getAttribute("placeholder");
    }

    public boolean isEyeIconDisplayed() {
        return driver.findElement(eyeIcon).isDisplayed();
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return driver.findElement(forgotPasswordLink).isDisplayed();
    }

    public boolean isForgotPasswordLinkClickable() {
        return driver.findElement(forgotPasswordLink).isEnabled();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public String getLoginButtonText() {
        return driver.findElement(loginButton).getAttribute("value");
    }

    public String getLoginButtonColor() {
        return driver.findElement(loginButton).getCssValue("background-color");
    }

    public int getLoginButtonWidth() {
        return driver.findElement(loginButton).getSize().getWidth();
    }

    public int getLoginButtonHeight() {
        return driver.findElement(loginButton).getSize().getHeight();
    }

    public String getLabelFontSize(By label) {
        return driver.findElement(label).getCssValue("font-size");
    }

    public String getLabelColor(By label) {
        return driver.findElement(label).getCssValue("color");
    }

    public String getPlaceholderFontSize(By input) {
        return driver.findElement(input).getCssValue("font-size");
    }

    public String getPlaceholderColor(By input) {
        return driver.findElement(input).getCssValue("color");
    }

    public String getInputBoxBorder(By input) {
        return driver.findElement(input).getCssValue("border");
    }

    public void focusInput(By input) {
        WebElement element = driver.findElement(input);
        element.click();
    }

    public String getInputBoxBorderOnFocus(By input) {
        return driver.findElement(input).getCssValue("border");
    }

    //Position Checks for full layout structure

    public boolean isEmailErrorBelowEmailInput() {
        return driver.findElement(emailInput).getLocation().getY()
             < driver.findElement(emailError).getLocation().getY();
    }

    public boolean isPasswordLabelBelowEmailSection() {
        return driver.findElement(emailError).getLocation().getY()
             < driver.findElement(passwordLabel).getLocation().getY();
    }

    public boolean isPasswordErrorBelowPasswordInput() {
        return driver.findElement(passwordInput).getLocation().getY()
             < driver.findElement(passwordError).getLocation().getY();
    }

    public boolean isForgotLinkBelowPasswordError() {
        return driver.findElement(passwordError).getLocation().getY()
             < driver.findElement(forgotPasswordLink).getLocation().getY();
    }

    public boolean isLoginButtonBelowForgotLink() {
        return driver.findElement(forgotPasswordLink).getLocation().getY()
             < driver.findElement(loginButton).getLocation().getY();
    }
}
