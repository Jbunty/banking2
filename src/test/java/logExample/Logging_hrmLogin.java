package logExample;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logging_hrmLogin {

	WebDriver driver;
	Logger log;

	@BeforeTest
	public void launchApp() {
		
		
		
		
		log = Logger.getLogger("HRMOrg_Automation_Logger");
        PropertyConfigurator.configure("./configFolder/log4j.properties");
		
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		log.info("chrome browser launched");
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		log.info("HRM application launched - https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

	@AfterTest
	public void closeApp() throws Exception {

		log.info("Chrome browser session closed.");
		Thread.sleep(5000);
		driver.close();
	}

	

	@Test
	public void Login_LogoutTest() throws Exception {

		
		log.info("Enter userName : Admin" );
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		log.info("Enter password : admin123" );
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");
		log.info("click on login button" );
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		
		Boolean verifyDashboard = driver.findElement(By.cssSelector("input#btnLogin")).isDisplayed();
		
		System.out.println("element presnt on page: " + verifyDashboard);
		
		if(verifyDashboard) {
			
			Assert.assertEquals(driver.findElement(By.cssSelector("input#btnLogin")).getText(), "Dashboard");
			log.info("Validation on Dashboard passed" );
		}
		
		else {
			
			//Assert.assertEquals(driver.findElement(By.cssSelector("input#btnLogin")).getText(), "Dashboard");
			log.info("Validation on Dashboard failed" );
			
		}
		
		
		
		log.info("click on Welcome button" );
		driver.findElement(By.cssSelector("a#welcome")).click();
		
		log.info("click on Logout button" );
		driver.findElement(By.linkText("Logout")).click();
		
		
		

		
		

	}

}
