package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

public class LoginPage extends BasePage 
{
	

    public By emailLabel = By.xpath("//label[normalize-space()='E-Mail Address']");
    public By emailInput = By.xpath("//input[@id='TxtUserName']");
    private By emailError = By.xpath("//span[@id='reqUserName']");

    private By passwordLabel = By.xpath("//label[normalize-space()='Password']");
    private By passwordInput = By.xpath("//input[@id='TxtPassword']");
    private By passwordError = By.xpath("//span[@id='reqPassword']");

    private By loginButton = By.xpath("//input[@id='container_0_LbLogin']");
    private By eyeIcon = By.xpath("//span[@class='fa fa-fw fa-eye field-icon perchahage-flow-toggle-password ']");
    private By forgotPasswordLink = By.xpath("//a[@id='container_0_HlForgotPassword']");

    
    public void enterUserName(String username) 
    {
    	test.log(Status.INFO, "\"Clearing and entering username: {}\", username");
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

    public String getUserName() {
        return driver.findElement(emailInput).getAttribute("value");
    }

    public boolean IsLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    // Font size, color, placeholder etc.
    public String getInputFontSize(By input) {
        return driver.findElement(input).getCssValue("font-size");
    }

    public String getUsernameLabelText() {
    	//"Started in get username label text
        return driver.findElement(emailLabel).getText();
        //Finished /get username label text
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

    public boolean isEmailInputBelowLabel() {
        return driver.findElement(emailInput).getLocation().getY()
             > driver.findElement(emailLabel).getLocation().getY();
    }

    public boolean isPasswordInputBelowLabel() {
        return driver.findElement(passwordInput).getLocation().getY()
             > driver.findElement(passwordLabel).getLocation().getY();
    }

    
    public boolean isEmailLabelAboveEmailInput() {
    	
    	//test.log(Log.info, "The email label y value us "+driver.findElement(emailLabel).getLocation().ge ())
        return driver.findElement(emailLabel).getLocation().getY()
             < driver.findElement(emailInput).getLocation().getY();
    }

    public boolean isPasswordLabelAbovePasswordInput() {
        return driver.findElement(passwordLabel).getLocation().getY()
             < driver.findElement(passwordInput).getLocation().getY();
    }

    public boolean isPasswordLabelBelowEmailError() {
        return driver.findElement(emailError).getLocation().getY()
             < driver.findElement(passwordLabel).getLocation().getY();
    }

    public boolean isForgotPasswordLinkBelowPasswordError() {
        return driver.findElement(passwordError).getLocation().getY()
             < driver.findElement(forgotPasswordLink).getLocation().getY();
    }

    public boolean isLoginButtonBelowForgotPasswordLink() {
        return driver.findElement(forgotPasswordLink).getLocation().getY()
             < driver.findElement(loginButton).getLocation().getY();
    }

}
