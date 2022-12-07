package retryLogicExample;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRMLoginTest extends BaseTest{

	
	
	@Test
	public void login() {
		
		System.out.println("login test case");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.className("button")).click();
		
		
		String actualValue = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(actualValue, "Dashboard");
		
	}
	
	
	//@Test(retryAnalyzer = RetryLogic.class)
	@Test
	public void logout() throws Exception {
		
		System.out.println("logout test case");
		driver.findElement(By.partialLinkText("come")).click();
		Thread.sleep(4000);
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
//		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
//		
		
		
		driver.findElement(By.linkText("Logout57587")).click();
		//Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"));
		
	}
	
	@Test
	public void verifyAppLogo() {
		
		System.out.println("verifyAppLogo test case");
		//int x = 1/0;
		
	}
	
	

}
