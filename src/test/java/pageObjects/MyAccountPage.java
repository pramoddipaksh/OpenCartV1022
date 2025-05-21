package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']") // My Account Page Heading
	WebElement txtMyAccountHeading;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") // Logout link
	WebElement linkLogout;

	public boolean isMyAccountPageExists() {

		try 
		{
			return (txtMyAccountHeading.isDisplayed());
		} 
		
		catch (Exception e) 
		{
			return false;
		}

	}
	
	public void clickLogout()
	{
		linkLogout.click();
	}

}
