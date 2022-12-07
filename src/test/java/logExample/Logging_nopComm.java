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

public class Logging_nopComm {

	WebDriver driver;
	Logger log;

	@BeforeTest
	public void launchApp() {
		
		
		
		
		log = Logger.getLogger("HRMOrg_Automation_Logger");
        PropertyConfigurator.configure("./configFolder/log4j.properties");
		
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		log.info("chrome browser launched");
		
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		log.info("HRM application launched - https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
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

		log.info("Clear userName " );
		driver.findElement(By.cssSelector("input#Email")).clear();
		log.info("Enter userName : admin@yourstore.com" );
		driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
		log.info("Enter password : admin" );
		
		driver.findElement(By.cssSelector("input#Password")).clear();
		driver.findElement(By.cssSelector("input#Password")).sendKeys("admin");
		
		log.info("click on login button" );
		driver.findElement(By.tagName("button")).click();
		
		
		Boolean verifyDashboard = driver.findElements(By.tagName("h1")).get(1).isDisplayed();
		
		System.out.println("element presnt on page: " + verifyDashboard);
		
		if(verifyDashboard) {
			
			Assert.assertTrue(driver.findElements(By.tagName("h1")).get(1).getText().contains("Dashboard"));
			log.info("Validation on Dashboard passed" );
		}
		
		else {
			
			//Assert.assertEquals(driver.findElement(By.cssSelector("input#btnLogin")).getText(), "Dashboard");
			log.info("Validation on Dashboard failed" );
			
		}
		
		
		
		
		
		log.info("click on Logout button" );
		driver.findElement(By.linkText("Logout")).click();
		
		
		

		
		

	}

}
