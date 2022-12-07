package testNGExample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_PriorityExample {
	

	//Amazon
	//Execution workflow
	
	//Priority - by default --- 0
	//Priority - highest negative number --- highest priority
	//If priority same - default execution as alphabetic order
	
	
	
	
	@BeforeTest
	public void launchApp() {
		System.out.println("launching app");
		
	}
	
	@AfterTest
	public void closeApp() {
		System.out.println("closing app");
		
	}

	@Test(priority = -1)
	public void login() {
		System.out.println("login test case");
		
	}
	
	@Test(priority = 2)
	public void addItemsToCart() {
		
		System.out.println("addItemsToCart test case");
	}
	
	@Test(priority = 3)
	public void payment() {
		
		System.out.println("payment test case");
	}
	
	
	@Test(priority = 3)
	public void cancelOrder() {
		
		System.out.println("cancelOrder test case");
	}
	
	@Test(priority = 4)
	public void logout() {
		
		System.out.println("logout test case");
	}
	
}
