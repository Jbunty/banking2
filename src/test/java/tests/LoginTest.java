package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest{

	
	@Test
	public void verifyLogin() throws Exception {
		
		
		lp.enterUserName(conf.getuserName());
		lp.enterPassword(conf.getPassword());
		lp.clickLoginButton();
		
		//validation step
		//Dashboard / nopCommerce administration
		Thread.sleep(4000);
		lp.verifyAppLicationTitle("Dashboard / nopCommerce administration");
		
		
	}
	
	
	@Test
	public void verifySearchCustomer() throws Exception {
		
		
//		lp.enterUserName(conf.getuserName());
//		lp.enterPassword(conf.getPassword());
//		lp.clickLoginButton();
//		
//		//validation step
//		//Dashboard / nopCommerce administration
//		Thread.sleep(4000);
//		lp.verifyAppLicationTitle("Dashboard / nopCommerce administration");
		
		Search_Cust.enterEmail("shamsi@gmail.com");
		Search_Cust.clickSearchButton();
		
		
	}
	
}
