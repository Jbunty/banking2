package exerciseTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest{

	
	@Test
	public void verifyLogin() throws Exception {
		
		lp.clickSignIn();
		
		Thread.sleep(2000);
		lp.enterUserName(conf.getuserName());
		lp.enterPassword(conf.getPassword());
		lp.clickLoginButton();
		
		//validation step
		//Dashboard / nopCommerce administration
		
		
		//Select the account
		//click on Go button
		
		acc.clickGoButton();
		
		
	}
	
	
	
	
}
