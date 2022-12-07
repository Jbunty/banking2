package controlExample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Handle_Inputbox extends BaseTest{
	
	
	@Test
	public void inputboxTest() {
		
		
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("First Name");
		
	}

}
