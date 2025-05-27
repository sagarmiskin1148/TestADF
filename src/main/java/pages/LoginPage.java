package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	private By usernameInput = By.id("TxtUserName");
    private By passwordInput = By.xpath("//input[@id='TxtPassword']");
    private By loginButton = By.xpath("//input[@id='container_0_LbLogin']");
    private By errorMessage = By.id("LblMessage");
    
    public void enterUserName(String username)
    {
    	
    }
    
    public void enterPassword(String password)
    {
    	
    }
    
    public void clickLoginButton()
    {
    	
    }
    
    public String getUserName()
    {
    	return null;
    	
    }
    
    public boolean IsLoginButtonEnabled()
    {
    	return false;
    }
    
    public String getUsernameLabelText()
    {
    	return null;
    }
    
    public String getPasswordLabelText()
    {
    	return null;
    }
    
    public String getUsernameErrorMessage()
    {
    	return null;
    }
    
    public String getPasswordErrorMessage()
    {
    	return null;
    }
    
    public boolean isUsernameTextboxDisplayed()
    {
    	return false;
    }
    
    public boolean isPasswordTextboxDisplayed()
    {
    	return false;
    }
    
}
