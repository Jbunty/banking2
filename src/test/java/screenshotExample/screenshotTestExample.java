package screenshotExample;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenshotTestExample {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
	}

	
	@Test
	public void amazonSearchTest() throws Exception {
		
		String searchItems = "iphone";
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(searchItems + Keys.ENTER);		
		Assert.assertTrue(driver.getTitle().contains(searchItems));


		Thread.sleep(2000);
		//take screenshot
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File target = new File(".\\sreenshot\\coforge_amazon.png");
		
		FileUtils.copyFile(source, target);
		
		
//		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File targetLocation = new File(".\\sreenshot\\coforge_amazon.png");
//		
//		
//		FileUtils.copyFile(screenshotFile, targetLocation);
		
		
	}
	
	
}
