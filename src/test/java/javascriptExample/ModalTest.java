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

public class ModalTest {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://www.uitestpractice.com/Students/Switchto");
		//driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
	}

	
	@Test
	public void handleModal() throws Exception {
		
		WebElement btn_launchModal = driver.findElement(By.xpath("//button[contains(text(),'Launch modal')]"));

		//btn_launchModal.click();
		
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		
		//JS.executeScript("alert('hello team, happy learning');");
		
		JS.executeScript("arguments[0].click();", btn_launchModal);
		
		
		
		
		
		Thread.sleep(2000);
//
		String heading = driver.findElement(By.cssSelector(".modal-title")).getText();
		String body = driver.findElement(By.cssSelector(".modal-body")).getText();
		
		System.out.println("Heading : " + heading);
		System.out.println("Heading : " + body);
		
		//modal validation
		Assert.assertTrue(heading.contains("Modal window demo"));
		Assert.assertTrue(body.contains("using the parent application"));
		
	}
	
	
}
