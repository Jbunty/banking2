package controlExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Handle_Alert extends BaseTest {

	
	//@Test
	public void simpleAlert() throws Exception {
		
		//click on Show me alert button
		driver.findElement(By.xpath("//input[contains(@value,'Me Alert')]")).click();
		
		
		//Concept
		//Alert/Window/Frame
		
		
		Thread.sleep(4000);
		
		//Alert
		Alert simpleAlert = driver.switchTo().alert();				//Accept - click on Ok button on Alert
		
		
		String atualAlertText = simpleAlert.getText();
		System.out.println("Text on Alert: " + atualAlertText);
		Assert.assertEquals(atualAlertText, "Hi.. This is alert message!");
		Assert.assertTrue(atualAlertText.contains("alert message"));
		
		//Alert
		//Methods - accept/dismiss/sendKeys/getText
		
		
		//simpleAlert.accept();
		simpleAlert.dismiss();
		
		
	}
	
	
	
	//@Test
	public void confirmAlert() throws Exception {
		
		//click on Show me confirmation button
		driver.findElement(By.xpath("//button[contains(text(),'Conf')]")).click();
		
		Thread.sleep(4000);
		
		//Alert
		Alert confirmAlert = driver.switchTo().alert();				//Accept - click on Ok button on Alert
		
		
		String atualAlertText = confirmAlert.getText();
		System.out.println("Text on Alert: " + atualAlertText);
		Assert.assertEquals(atualAlertText, "Press 'OK' or 'Cancel' button!");
		Assert.assertTrue(atualAlertText.contains("'OK' or 'Cancel'"));
		
		//Alert
		//Methods - accept/dismiss/sendKeys/getText
		
		
		//confirmAlert.accept();
		confirmAlert.dismiss();
		
		
		String actualValue = driver.findElement(By.cssSelector("#demo")).getText();
		//Assert.assertTrue(actualValue.contains("OK"));
		Assert.assertTrue(actualValue.contains("Cancel"));
		
		
		
	}
	
	@Test(priority = 1)
	public void promptAlert() throws Exception {
		
		//click on Show me confirmation button
		driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
		
		Thread.sleep(4000);
		
		//Alert
		Alert promptAlert = driver.switchTo().alert();				//Accept - click on Ok button on Alert
		
		
		String atualAlertText = promptAlert.getText();
		System.out.println("Text on Alert: " + atualAlertText);
		Assert.assertEquals(atualAlertText, "Your Name Please");
		Assert.assertTrue(atualAlertText.contains("Name Please"));
		
		//Alert
		//Methods - accept/dismiss/sendKeys/getText
		
		promptAlert.sendKeys("Vikas !!");
		
		
		
		promptAlert.accept();
		//confirmAlert.dismiss();
		
		
		
		
	}
	
	
	
}
