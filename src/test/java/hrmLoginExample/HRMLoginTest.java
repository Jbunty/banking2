package hrmLoginExample;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRMLoginTest extends BaseTest_CrossBrowser{

	@Test
	public void verifyLogin() {
	
		driver.findElement(By.id("txtUsername")).sendKeys(conf.adming_userName());
		driver.findElement(By.name("txtPassword")).sendKeys(conf.admin_password());
		driver.findElement(By.className("button")).click();
		
		
		String actualValue = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(actualValue, "Dashboard");
		
		
	}
	
	
	@Test
	public void verifyLogout() throws Exception {
		
		driver.findElement(By.partialLinkText("come")).click();
		//Thread.sleep(4000);
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
//		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
//		
		
		
		driver.findElement(By.linkText("Logout")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"));
		
		
		
	}
	
	

}
