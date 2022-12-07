package actionExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_SignInClick {

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
	public void DoubleClickTest() throws Exception {

		Thread.sleep(4000);
		
		WebElement SignIn = driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]"));

		WebElement WishList = driver.findElement(By.xpath("//span[contains(text(),'Create a Wish')]"));
		
		
		Actions act = new Actions(driver);
		act.moveToElement(SignIn).click(WishList).perform();

		

	}

}
