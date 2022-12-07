package frameExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PayTMExample {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://paytm.com/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
	}

	
	@Test
	public void handleFrameTest() throws Exception {
		
		
		
		WebElement btn_SignIn = driver.findElement(By.xpath("//span[text()='Sign In']"));
		btn_SignIn.click();
		
		
		
		Thread.sleep(2000);
		//Inside frame
		
		//Switch To Frame
		//driver.switchTo().frame(0);			//indexing start from 0
		
		//name or id
		//driver.switchTo().frame("name or id");
		
		//WebElement
		WebElement myFrame = driver.findElement(By.xpath("//iframe[contains(@src,'paytm')]"));
		driver.switchTo().frame(myFrame);
		
		
		String actualHeading = driver.findElement(By.cssSelector("p.heading")).getText();
		Assert.assertEquals(actualHeading, "To Login into your Paytm Web account");
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Watch')]")).click();
		
	}
	
	
}
