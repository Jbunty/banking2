package controlExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Handle_list_dropdownExample extends BaseTest{
	
	
	@Test
	public void listTest() throws Exception {
		
		WebElement ele_mul_list = driver.findElement(By.xpath("//select[contains(@name,'FromLB')]"));
		
		
		
		//Create an object on Select Class
		
		Select list = new Select(ele_mul_list);
		
		System.out.println("Is listbox Multiple selection enabled or not : " + list.isMultiple());   //true
		
		//Select value from dropdown
		//Index, value, visibleText
		
		System.out.println("Option count : " + list.getOptions().size());
		
		
		list.selectByIndex(0);					//USA
		Thread.sleep(1000);
		
		list.selectByValue("India");			//India
		
		Thread.sleep(1000);
		list.selectByVisibleText("Germany");	//Germany
		
		
		
		Thread.sleep(4000);
		
		Thread.sleep(1000);
		list.deselectByVisibleText("USA");		//USA
		
		Thread.sleep(1000);
		list.deselectByValue("Germany");		//Germany
		
		Thread.sleep(1000);
		list.deselectByIndex(5);				//Germany
			
	}
	
	
	
	
	@Test(priority = -1)
	public void listTest2() throws Exception {
		
		WebElement ele_single_list = driver.findElement(By.tagName("select"));				//multiple match - 3
																							//by default - it perform action on first element
		
		
		
		//Create an object on Select Class
		
		Select list = new Select(ele_single_list);
		
		System.out.println("Is listbox Multiple selection enabled or not : " + list.isMultiple());   //false
		
		//Select value from dropdown
		//Index, value, visibleText
		
		System.out.println("Option count : " + list.getOptions().size());
		
		//indexing start from 0
		list.selectByIndex(3);					//Audi
		Thread.sleep(2000);
		
		list.selectByValue("USA");				//Volvo
		
		Thread.sleep(2000);
		list.selectByVisibleText("Toyota");		//Toyota
		
		
		
		
			
	}
	

}
