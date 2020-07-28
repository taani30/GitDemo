package rahulshettyAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePage extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	
	  @BeforeTest public void openBrowser() throws IOException 
	  { 
	  driver=initializeBrowser(); 
	  driver.get(prop.getProperty("url")); 
	  }
	 
	  
	
	@Test(dataProvider="getData")
	public void HomePageNavigation(String Username,String password,String text) throws IOException {
//		driver= initializeBrowser();
		driver.get(prop.getProperty("url"));
		
		LandingPage LP= new LandingPage(driver);
		LP.getLogin().click();
		
		LoginPage logPage= new LoginPage(driver);
		logPage.getEmail().sendKeys(Username);
		logPage.getpassword().sendKeys(password);
		
		log.info(text);
		logPage.clickonLogin().click();
		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		
		System.out.println("browser closing of the homepage automation");
		System.out.println("web automation completed");
		
		System.out.println("divyang is busy with his job work ... huh");
	}
	 
	@DataProvider
	public Object[][] getData() {
		Object [][] data = new Object[2][3];
		
		data[0][0] = "NonRestrictedUser@abc.com";
		data[0][1] ="123456";
		data[0][2] ="Restricted_User";
		
		data[1][0] = "RestrictedUser@xyz.com";
		data[1][1] = "678910";
		data[1][2] ="NonRestricted_user";
		
		return data;
	}
	
	
}
