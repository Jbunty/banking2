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

public class ContextClick_DoubleClick {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
	}

	@Test
	public void RightClickTest() throws Exception {

		WebElement btn_Right = driver.findElement(By.xpath("//span[contains(text(),'right')]"));

		Actions act = new Actions(driver);
		act.contextClick(btn_Right).perform();

		Thread.sleep(4000);

		WebElement btn_Delete = driver.findElement(By.xpath("//span[contains(text(),'Delete')]"));
		btn_Delete.click();

		// handle alert
		Alert ele_Alert = driver.switchTo().alert();

		System.out.println(ele_Alert.getText());
		Assert.assertTrue(ele_Alert.getText().contains("clicked: delete"));
		ele_Alert.accept();
	}

	@Test
	public void DoubleClickTest() throws Exception {

		Thread.sleep(4000);
		
		WebElement btn_Double = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));

		Actions act = new Actions(driver);
		act.doubleClick(btn_Double).perform();

		// handle alert
		Alert ele_Alert = driver.switchTo().alert();

		System.out.println(ele_Alert.getText());
		Assert.assertTrue(ele_Alert.getText().contains("double clicked me."));
		
		Thread.sleep(4000);
		ele_Alert.accept();
		
		//Assert.assertTrue(false);
		

	}

}
