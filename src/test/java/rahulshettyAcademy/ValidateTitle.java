package rahulshettyAcademy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateTitle extends base{

	public static Logger log = LogManager.getLogger(base.class.getName());
	
	LandingPage LP ;
	
	@BeforeTest
	public void openBrowser() throws IOException {
	driver= initializeBrowser();
	log.info("driver is initializing");
	
	driver.get(prop.getProperty("url"));
	log.info("homePage is opening");
	}
	
	@Test
	public void validateTitletext() throws IOException {
		
//		  driver = initializeBrowser(); 
//		  driver.get("http://www.qaclickacademy.com/");
		  //BEFORE THE ANNOTATION USE
		
		LP = new LandingPage(driver);	
	String title = 	LP.getTitle().getText();
	Assert.assertEquals(title, "FEATURED COURSES123");
	log.info("successfully validating text on HomePage");
	//LP.navigationBar().isDisplayed();
	
	Assert.assertTrue(LP.navigationBar().isDisplayed());
		
	}
	
	@Test//----section 27 video 218 -->demostration on clubbing.....
	public void validateHeader() {
		
		LP = new LandingPage(driver);	
		String headerTEXT = LP.getHeader().getText();
		Assert.assertEquals(headerTEXT, "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.out.println("this is change by gitstuff on 2:57pm");
	}
	
}
