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

public class Handle_Alert2 extends BaseTest {

	

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
	
	//@Test
	public void simpleAlert() throws Exception {
		
		//click on Show me alert button
		driver.findElement(By.cssSelector("button#alert")).click();
		
		
		//Concept
		//Alert/Window/Frame
		
		
		Thread.sleep(4000);
		
		//Alert
		Alert simpleAlert = driver.switchTo().alert();				//Accept - click on Ok button on Alert
		
		
		String atualAlertText = simpleAlert.getText();
		System.out.println("Text on Alert: " + atualAlertText);
		Assert.assertEquals(atualAlertText, "Hello Alert");
		Assert.assertTrue(atualAlertText.contains("Alert"));
		
		//Alert
		//Methods - accept/dismiss/sendKeys/getText
		
		
		//simpleAlert.accept();
		simpleAlert.dismiss();
		
		
	}
	
	
	
	//@Test
	public void confirmAlert() throws Exception {
		
		//click on Show me confirmation button
		driver.findElement(By.cssSelector("button#confirm")).click();
		
		Thread.sleep(4000);
		
		//Alert
		Alert confirmAlert = driver.switchTo().alert();				//Accept - click on Ok button on Alert
		
		
		String atualAlertText = confirmAlert.getText();
		System.out.println("Text on Alert: " + atualAlertText);
		Assert.assertEquals(atualAlertText, "Hello Alert");
		Assert.assertTrue(atualAlertText.contains("'Hello Alert"));
		
		//Alert
		//Methods - accept/dismiss/sendKeys/getText
		
		
		//confirmAlert.accept();
		confirmAlert.dismiss();
		
		
		String actualValue = driver.findElement(By.cssSelector("div#demo")).getText();
		//Assert.assertTrue(actualValue.contains("OK"));
		Assert.assertTrue(actualValue.contains("Cancel"));
		
		
		
	}
	
	@Test(priority = 1)
	public void promptAlert() throws Exception {
		
		Thread.sleep(4000);
		//click on Show me confirmation button
		driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
		
		Thread.sleep(4000);
		
		//Alert
		Alert promptAlert = driver.switchTo().alert();				//Accept - click on Ok button on Alert
		
		
		String atualAlertText = promptAlert.getText();
		System.out.println("Text on Alert: " + atualAlertText);
		Assert.assertEquals(atualAlertText, "Enter your name");
		Assert.assertTrue(atualAlertText.contains("your name"));
		
		//Alert
		//Methods - accept/dismiss/sendKeys/getText
		String enterName = "Chahat";
		promptAlert.sendKeys(enterName);
		
		
		
		promptAlert.accept();
		//confirmAlert.dismiss();
		Thread.sleep(4000);
		String actualValue = driver.findElement(By.cssSelector("div#demo")).getText();
		Assert.assertTrue(actualValue.contains(enterName));
		
		
	}
	
	
	
}
