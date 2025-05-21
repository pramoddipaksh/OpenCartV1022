package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; // Log4j
import org.apache.logging.log4j.Logger;  // Log4j

// this is parent-class of all the test case classes which contains all common(repeatable, re-usable) methods that can be used by rest of the test case classes

public class BaseClass {
	
	
	public WebDriver driver;
	public Logger logger;  // Log4j
	public Properties p; // config.properties file 

	@BeforeClass
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException {
		
		//loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties"); // 
		p=new Properties();
		p.load(file); // this will load the properties file
		
		
		logger = LogManager.getLogger(this.getClass()); // It will automatically fetch log4j2.xml file from default 

		switch(br.toLowerCase()) 
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		default : System.out.println("Invalid browser name..."); return;
		}
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	//	driver.get("https://tutorialsninja.com/demo/index.php");
		driver.get(p.getProperty("appURL")); // after using config.properties file, reading URL values using object of properties file i.e. p
		
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDiwn() {

		driver.quit();
	}
	
	// this method is to create random strings and return to above. 
	public String randomString() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	// this method is to create random numbers for telephone and return to above. 
	public String randomNumber() {
		
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	// this method is to create random alpha-numeric values for password and return to above. 
	public String randomAlphaNumeric() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		
		return (generatedString+"#"+generatedNumber);
	}
	

}
