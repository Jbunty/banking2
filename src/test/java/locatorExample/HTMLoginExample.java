package locatorExample;

//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLoginExample {

	WebDriver driver;
	
	
	
	@BeforeTest
	public void launchApp() {
		
		
		
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
	}
	
	
	
	
	@Test
	public void verifyApplicationURL() {
	
		String expectedURL = "https://opensource-demo.orangehrmlive.com/";				 // requirement
		String actualURL = driver.getCurrentUrl();   									// fetch from application
		
	
		//Validation step
		Assert.assertEquals(actualURL, expectedURL);
		Assert.assertTrue(actualURL.contains("orangehrmlive"));
		
		
//		String fullName = "Ankur Gupta";
//		String name = "Gupta";
//		
//		boolean value =  fullName.contains(name);
//		System.out.println(value);
		
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(5000);
		driver.close();
	}
	
	
	
	
	
	

}
