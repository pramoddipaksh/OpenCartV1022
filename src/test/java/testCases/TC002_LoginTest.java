package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
public class TC002_LoginTest extends BaseClass

{
	@Test
	public void verify_login()
	{
		
		logger.info("*********Starting TC002_LoginTest*********");
		
		try 
		{
			
		//Home Page
		HomePage hp = new HomePage(driver);		
		hp.clickMyAccount();		
		hp.clickLogin();
		
		//Login Page
		LoginPage lp = new LoginPage(driver);		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//My Account Page
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);     // Assert.assertEquals(targetPage, true, "Login failed"); // both are same		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*********Finished TC002_LoginTest*********");
		
		
	}
	
	
	

}
