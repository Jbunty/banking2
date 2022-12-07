package hrmLoginExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import configReadExample.ConfigReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLogin {

	
	@Test
	public void login() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		ConfigReadData conf = new ConfigReadData();
		
		
		
		driver.get(conf.getAppURL());
		
		
	}
	
	

}
