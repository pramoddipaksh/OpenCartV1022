package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{


	@Test
	public void verify_account_registration() {
		
		logger.info("*********Starting TC001_AccountRegistrationTest **********");

		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info(" Clicked on MyAccount link ");
		
		hp.clickRegister();
		logger.info(" Clicked on Register link ");

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

		logger.info("Providing customer details.....");
		regpage.setFirstName(randomString().toUpperCase()); // randomly generates
		regpage.setLastName(randomString().toUpperCase()); // randomly generates

		//	regpage.setEmail("abcdtesr@gmail.com");// this is static test data email which create problem after second-time execution
		regpage.setEmail(randomString()+"@gmail.com");// this method create & return random string then concatenate with '@gmail.com' format

		//	regpage.setTelephone("2345678901"); // static test data
		regpage.setTelephone(randomNumber()); // dynamic test data generates at run-time-randomly  telephone number
		
		String password = randomAlphaNumeric();

	//	regpage.setPassword("xyz12345"); // static test data
	//	regpage.setConfirmPassword("xyz12345"); // static test data		
		regpage.setPassword(password);    // dynamic test data
		regpage.setConfirmPassword(password); // dynamic test data
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message...");
		String confmsg = regpage.getConfirmationMsg();
		
	//	if(confmsg.equals("Yr Account Has Been Created!"))
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else {
			
			logger.error("Test failed.....");
			logger.debug("Debug logs.....");
			Assert.assertTrue(false);
		}
			
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {  // Add try catch block to each test case code so that logger can be applicable to whole code & in error cases in one location i.e. catch block its handled
			

			Assert.fail();
			
		}	
		
		logger.info("*********Finished TC001_AccountRegistrationTest **********");
	}
}
