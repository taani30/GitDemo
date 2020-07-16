package rahulshettyAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By email = By.id("user_email");
	By pwd =  By.id("user_password");
	By submit = By.name("commit");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getpassword() {
		return driver.findElement(pwd);
	}
	public WebElement clickonLogin() {
		return driver.findElement(submit);
	}
}
