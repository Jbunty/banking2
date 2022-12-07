package hrmLoginExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import configReadExample.ConfigRead;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest_CrossBrowser {

	
	

	WebDriver driver;
	ConfigRead conf;
	
	
	@Parameters("browser")
	@BeforeTest
	public void launchApp(String browserInfo) throws Exception {
		
		System.out.println("Browser info: " + browserInfo);
		
		if(browserInfo.equalsIgnoreCase("chrome")) 
		{
			
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
			
			
		}
		
		else if(browserInfo.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup(); 
			driver = new EdgeDriver();
		}
		
		else {
			
			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver();
		
		}
		
		
		
		
		conf = new ConfigRead();
		
		
		
		
		driver.get(conf.getApplicationURL());
		driver.manage().window().maximize();
		
	}
	
	

	
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(5000);
		driver.close();
	}
	
	
}
