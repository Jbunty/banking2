package controlExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_Modal extends BaseTest {

	

	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		
		driver.get("http://www.uitestpractice.com/Students/Switchto");
		driver.manage().window().maximize();
		
	}
	
	

	
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(5000);
		driver.close();
	}
	
		
	@Test(priority = 1)
	public void promptAlert() throws Exception {
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'modal')]")).click();
		
		Thread.sleep(5000);
		String actualValue = driver.findElement(By.cssSelector(".modal-title")).getText();
		Assert.assertTrue(actualValue.contains("window demo"));
		
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
	}
	
	
	
}
