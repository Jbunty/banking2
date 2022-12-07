package conditionalWaitExxample;

import java.util.concurrent.TimeUnit;

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

public class ConditionalWaitTest_hrmLogin {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
	}

	

	@Test
	public void Login_LogoutTest() throws Exception {

		
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		
		
		
		driver.findElement(By.cssSelector("a#welcome")).click();
		
		driver.findElement(By.linkText("Logout")).click();
		
		
		
		
//		WebDriverWait wait = new WebDriverWait(driver, 120);
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#text3")));
//		
//		
//		WebElement text_3 = driver.findElement(By.cssSelector("#text3"));
//		text_3.sendKeys("enter value into text box");
		
		

	}

}
