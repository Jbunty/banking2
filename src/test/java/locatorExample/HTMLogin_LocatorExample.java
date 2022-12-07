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

public class HTMLogin_LocatorExample {

	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
	}
	
	
		
	@Test
	public void verifyApplicationURL() {
	
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
		
		WebElement txt_userName = driver.findElement(By.id("txtUsername"));
		txt_userName.sendKeys("Admin");
		txt_userName.clear();
		
		System.out.println("Tagname: " + txt_userName.getTagName());
		System.out.println("Type: " + txt_userName.getAttribute("type"));
		System.out.println("name: " + txt_userName.getAttribute("name"));
		System.out.println("text: " + txt_userName.getText());
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(5000);
		driver.close();
	}
	
	
	
	
	
	

}
