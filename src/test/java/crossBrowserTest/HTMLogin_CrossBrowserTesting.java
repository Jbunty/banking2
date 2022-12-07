package crossBrowserTest;

import org.openqa.selenium.By;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLogin_CrossBrowserTesting {

	WebDriver driver;
	
	
	
	@Parameters("coforge_browser")
	@BeforeTest
	public void launchApp(String browser) {
		
		
		//edge/chrome
		
		//String browser = "edge";
		System.out.println("executing test on browser: " + browser);
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			//chrome
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
		}

		else if(browser.equalsIgnoreCase("edge")) {
			
			//edge
			WebDriverManager.edgedriver().setup(); 
			driver = new EdgeDriver();
		}
		
		
		else {
			
			System.out.println("please choose appropriate browser.");
		}
		
		
		
		
		
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
	}
	
	
		
	@Test
	public void verifyLogin() {
	
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.className("button")).click();
		
		
		String actualValue = driver.findElement(By.tagName("h1")).getText();
		//validation Step
		Assert.assertEquals(actualValue, "Dashboard");
				
		
		
	}
	
	
	@Test
	public void verifyLogout() throws Exception {
		
		driver.findElement(By.partialLinkText("come")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Logout")).click();


		//validation Step
		System.out.println("Application URL after logout: "  + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"));
		
		
	}
	
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(5000);
		driver.close();
	}
	
	
	
	
	
	

}
