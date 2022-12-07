package exerciseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import configReadExample.ConfigRead;
import configReadExample.ConfigReadData;
import configReadExample.ConfigReadDataExercise;
import exercisePage.AccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.SearchCustomerPage;

public class BaseTest {
	
	WebDriver driver;
	ConfigReadDataExercise conf;
	LoginPage lp;
	AccountPage acc;
	SearchCustomerPage Search_Cust;

	@BeforeTest
	public void launchApp() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		
		//create an object
		conf = new ConfigReadDataExercise();
		lp = new LoginPage(driver);
		acc = new AccountPage(driver);
		
		Search_Cust = new SearchCustomerPage(driver);
		
		
		driver.get(conf.getAppURL());
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
	}

}
