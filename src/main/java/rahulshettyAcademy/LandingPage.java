package rahulshettyAcademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	By sign_in = By.xpath("//span[contains(text(),'Login')]");
	By title_text = By.xpath("//h2[text()='Featured Courses']");
	By navigation_bar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	By header_ele= By.cssSelector("div[class*='video-banner'] h3");
	By popup_ele= By.xpath("//button[text()='NO THANKS']");
	
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}

	public WebElement getLogin() {
		return driver.findElement(sign_in);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title_text);
	}
	
	public WebElement navigationBar() {
		return driver.findElement(navigation_bar);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header_ele);
	}
	
	public int getpopuSize() {
		return driver.findElements(popup_ele).size();
	}
	public WebElement getpopup() {
		return driver.findElement(popup_ele);
	}
}
