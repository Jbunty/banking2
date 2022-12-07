package controlExample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Handle_CheckboxRadioButton extends BaseTest{
	
	
	@Test
	public void checkboxTest() {
		
		
		driver.findElement(By.xpath("//input[@value='Boat']")).click();
		
	}

	
	@Test
	public void radioButtonTest() {
		
		
		driver.findElement(By.xpath("//input[@value='female']")).click();
		
	}
	
	
}
