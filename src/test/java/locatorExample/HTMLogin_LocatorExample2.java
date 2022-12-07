package locatorExample;

import org.openqa.selenium.By;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLogin_LocatorExample2 {

	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
	}
	
	
		
	@Test
	public void verifyLogin() {
	
		//Locators 
//		ID
//		NAME
//		CLASSNAME
//		TAGNAME
//
//		LINKTEXT
//		PARTIALLINKTEXT
//
//		XPATH
//		CSS SELECTOR
		
		
		
		//ID locator
		//UserName textbox
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		
		//Name
		//Password textbox
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		
		//Classname
		//Login button
		driver.findElement(By.className("button")).click();
		
		
		//TagName
		//Dashboard
		String actualValue = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Text: " + actualValue);
		
		//validation Step
		Assert.assertEquals(actualValue, "Dashboard");
				
		
		
	}
	
	
	@Test
	public void verifyLogout() throws Exception {
		
		//PARTIALLINKTEXT
		//Weclome
		driver.findElement(By.partialLinkText("come")).click();
		
		
		//Delay
		Thread.sleep(4000);
		
		//LinkText
		//logout
		driver.findElement(By.linkText("Logout")).click();


		//validation Step
		System.out.println("Application URL after logout: "  + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"));
		
		
		Thread.sleep(3000);
		//Click on Forgot password
		//using partialLinkText
		driver.findElement(By.partialLinkText("your pass")).click();		
		
		Thread.sleep(3000);
		
		//XPATH
		//click on Cancel button
		
		driver.findElement(By.xpath("//input[@type=\"button\"]")).click();
		
		
		Thread.sleep(3000);
		//Click on Forgot password
		//using partialLinkText
		driver.findElement(By.partialLinkText("your pass")).click();		
		
		Thread.sleep(3000);
		
		//CSS Selector
		//click on Cancel button
		driver.findElement(By.cssSelector("input[type='button']")).click();
		
		
		
		
	}
	
	
	
	
	
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(5000);
		driver.close();
	}
	
	
	
	
	
	

}
