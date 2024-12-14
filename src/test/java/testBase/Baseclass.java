package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class Baseclass {
public WebDriver driver;
public Properties p;
	
	
	@BeforeClass
	public void setup() throws IOException
	{
		//loading properties file
		FileReader file=new FileReader(".//src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		 //ChromeOptions options = new ChromeOptions();
		// options.addArguments("--disable-notifications");
		// options.addArguments("start-maximized");
		 ChromeOptions ops = new ChromeOptions();
	        ops.addArguments("--disable-notifications");
	        // Open the Chrome browser
	        driver  = new ChromeDriver(ops);
		 
		 
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("http://localhost/opencart/");
		
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/");
		//driver.manage().window().maximize();
		
	}
	
	public void teardown()
	{
	driver.quit();	
	}

	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	public String randomNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(4);
		return generatedString;
		
	}
	public String randomalphanumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(2);
		String num=RandomStringUtils.randomNumeric(2);
		return(str+"@"+num);
		
	}
}
