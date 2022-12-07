package handleWindowsExample;

import static org.testng.Assert.assertTrue;

import java.util.Set;
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

public class IRCTC_HotelBookingTest {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
		//driver.quit();
		
	}

	

	@Test
	public void DoubleClickTest() throws Exception {

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window ID: " + parentWindow);
		
		
		
		
		WebElement btn_OK = driver.findElement(By.xpath("//button[contains(text(),'K')]"));
		btn_OK.click();
		
		//click on Hotel on Main window
		driver.findElement(By.linkText("HOTELS")).click();
		
		
		//get windows details
		Set<String> allWindows = driver.getWindowHandles();
		
		
		System.out.println("windows count : "+ allWindows.size());
		System.out.println("=======================================");
		
		String mainWindow = (String) allWindows.toArray()[0];
		String hotelWindow = (String) allWindows.toArray()[1];
		System.out.println("Main Window: " + mainWindow);
		System.out.println("hotel Window: " + hotelWindow);
		
		
		Thread.sleep(4000);
		//Switch to hotel window
		driver.switchTo().window(hotelWindow);
		
		
		
		//Hotel window - click on Login button
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		Thread.sleep(4000);
		
		//===============================================================
		//Switch to mainWindow window
		driver.switchTo().window(mainWindow);
		
		Thread.sleep(5000);
		driver.findElement(By.linkText("CONTACT US")).click();
		
		Thread.sleep(5000);

		//===============================================================
		//Switch to hotel window
		driver.switchTo().window(hotelWindow);
		
		driver.findElements(By.xpath("//button[text()='Login']")).get(0).click();
		
		String errorUserNameMessage = driver.findElements(By.cssSelector("span.ERR2")).get(0).getText();
		System.out.println(errorUserNameMessage);
		Assert.assertTrue(errorUserNameMessage.contains("User Name"));
		
		
		
		//===============================================================
		//Switch to mainWindow window
		driver.switchTo().window(mainWindow);
				
		Thread.sleep(5000);
		
		String actual_careEmail = driver.findElement(By.xpath("//a[contains(@href,'mailto:care')]")).getText();
		System.out.println("Care email id: " + actual_careEmail);
		Assert.assertEquals(actual_careEmail, "care@irctc.co.in");
	}

}
