package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@id='input-email']")  // E-Mail Address text field
	WebElement txtEmailAddress;
	
	@FindBy(xpath = "//input[@id='input-password']") // Password text field
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@value='Login']") // Login button
	WebElement btnLogin;
	
	
	
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	
	
	
	

}
