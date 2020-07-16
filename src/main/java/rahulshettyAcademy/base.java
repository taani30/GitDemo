package rahulshettyAcademy;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class base {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws IOException 
	{
	prop = new Properties();
	
	FileInputStream FIS = new FileInputStream("C:\\Users\\Taani\\mavenProject\\src\\main\\java\\resources\\data.properties");
	// before the dynamically path can be written like this...
	//System.getProerty("user.dir")----> use instead your own path
	
	//FileInputStream FIS = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
	prop.load(FIS);
	
	//String browserName = System.getProperty("browser"); //---> for the maven command
	
	String browserName = prop.getProperty("browser");
//	System.out.println(browserName);
	
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", ("C:\\Users\\Taani\\selenium_Driver\\chrome84.0\\chromedriver.exe"));
	/*	//headless mode execution code
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		 driver = new ChromeDriver(options);   */
		
		driver = new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		//System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe"));
		System.setProperty("webdriver.gecko.driver", ("C:\\Users\\Taani\\selenium_Driver\\New folder\\geckodriver.exe"));
		driver = new FirefoxDriver();
	}
	else if (browserName.equals("IE"))
	{
		//System.setProperty("webdriver.ie.driver", (System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe"));
		System.setProperty("webdriver.ie.driver", ("C:\\Users\\Taani\\Desktop\\selenium IDE\\SELENIUM_instaaling files\\geckodriver.exe"));
		 driver = new InternetExplorerDriver();
		
	}
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;
	}
	
	/*public void getScreenShot(String result) throws IOException {
	File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//Files.copy(source, new File("C://Users//Taani//mavenProject//test-output//"+result+"screenshot.png"));
	org.apache.commons.io.FileUtils.copyFile(source, new File("C:\\ss"+result+".png"));
	
	}*/
	
}
