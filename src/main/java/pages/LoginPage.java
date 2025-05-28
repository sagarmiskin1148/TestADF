package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	private By usernameInput = By.id("TxtUserName");
    private By passwordInput = By.xpath("//input[@id='TxtPassword']");
    private By loginButton = By.xpath("//input[@id='container_0_LbLogin']");
    //private By errorMessage = By.id("LblMessage");
    
    public void enterUserName(String username)
    {
    
    	driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }
    
    public void enterPassword(String password)
    {
    	 driver.findElement(passwordInput).clear();
         driver.findElement(passwordInput).sendKeys(password);
    	
    }
    
    public void clickLoginButton()
    {
        driver.findElement(loginButton).click();

    }
    
    public String getUserName()
    {
        return driver.findElement(usernameInput).getAttribute("value");
    	
    }
    
    public boolean IsLoginButtonEnabled()
    {
        return driver.findElement(loginButton).isEnabled();

    }
    
    public String getUsernameLabelText()
    {
      return driver.findElement(By.xpath("//label[normalize-space()='E-Mail Address']")).getText();
    	
    }
    
    public String getPasswordLabelText()
    {
    	return driver.findElement(By.xpath("//label[normalize-space()='Password']")).getText();
    }
    
    public String getUsernameErrorMessage()
    {
        return driver.findElement(By.xpath("//span[@id='reqUserName']")).getText();
    }
    
    public String getPasswordErrorMessage()
    {
        return driver.findElement(By.xpath("//span[@id='reqPassword']")).getText();
    }
    
    public boolean isUsernameTextboxDisplayed()
    {
        return driver.findElement(usernameInput).isDisplayed();
    }
    
    public boolean isPasswordTextboxDisplayed()
    {
        return driver.findElement(passwordInput).isDisplayed();
    }
    
}
