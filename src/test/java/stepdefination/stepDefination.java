package stepdefination;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import rahulshettyAcademy.LandingPage;
import rahulshettyAcademy.LoginPage;
import rahulshettyAcademy.base;

@RunWith(Cucumber.class)
public class stepDefination extends base{
	

@Given("^Intialize Browser with Chrome$")
public void intialize_Browser_with_Chrome() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	  driver=initializeBrowser(); 
}

@Given("^Navigate to \"([^\"]*)\" site$")
public void navigate_to_site(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    driver.get(arg1);
}

@Given("^click on login link on home page to land on sign in page$")
public void click_on_login_link_on_home_page_to_land_on_sign_in_page() throws Throwable {
	LandingPage LP= new LandingPage(driver);
	if(LP.getpopuSize()>0)
	{
		LP.getpopup().click();
	}
	LP.getLogin().click();
	
    
}

/*@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {

	LoginPage logPage= new LoginPage(driver);
	logPage.getEmail().sendKeys(arg1);
	logPage.getpassword().sendKeys(arg2);
	
	logPage.clickonLogin().click();
   
}----- before parameterization*/

//@When("^user enters (.+) and (.+) and logs in $")
//public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
//	LoginPage logPage= new LoginPage(driver);
//	logPage.getEmail().sendKeys(username);
//	logPage.getpassword().sendKeys(password);
//	
//	logPage.clickonLogin().click();
//}
//
//@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and logs in $")
//public void user_enters_something_and_something_and_logs_in(String username, String password, String strArg1, String strArg2) throws Throwable {
//	LoginPage logPage= new LoginPage(driver);
//	logPage.getEmail().sendKeys(username);
//	logPage.getpassword().sendKeys(password);
//	
//	logPage.clickonLogin().click();
//}

@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	LoginPage logPage= new LoginPage(driver);
	logPage.getEmail().sendKeys(username);
	logPage.getpassword().sendKeys(password);
	
	logPage.clickonLogin().click();
}




@Then("^verify that user is successfully logged in$")
public void verify_that_user_is_successfully_logged_in() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	String headerText = driver.findElement(By.xpath("//a[@class='navbar-brand']")).getText();

if(headerText.contains("WebServices Testing using SoapUI"));

	System.out.println("login was unsuccessful");

}

@And("^close the browser$")
public void close_the_browser() throws Throwable {
    driver.quit();
}

    
}

