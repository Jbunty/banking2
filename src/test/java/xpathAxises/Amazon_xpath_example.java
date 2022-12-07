package xpathAxises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_xpath_example {
	
	
	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
	}
	
	@Test
	public void verifySeeMoreTest() throws Exception {
		
		
		driver.findElement(By.xpath("//h2[contains(text(),'Cookware & dining')]//parent::div//following-sibling::div[contains(@class,'footer')]//child::a[text()='See more']")).click();
		
		Thread.sleep(4000);
		
		System.out.println(driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().contains("Microwave"));
		
		
		
	}

}
