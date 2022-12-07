package javascriptExample;

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

public class MyntraExample {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
	}

	
	@Test
	public void handleModal() throws Exception {
		
		WebElement retunPolicy = driver.findElement(By.xpath("//strong[contains(text(),'within 30')]"));

		//btn_launchModal.click();
		
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("arguments[0].scrollIntoView();", retunPolicy);
		
		
		
	}
	
	
}
