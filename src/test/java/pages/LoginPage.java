package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver coforgeDriver) {

		this.driver = coforgeDriver;

	}

	// Identification

	By lnk_SignIn = By.cssSelector("a#LoginLink>font");
	By txt_email = By.cssSelector("input#uid");
	By txt_pass = By.name("passw");
	By chk_rememberMe = By.cssSelector("#RememberMe");
	By chk_grid = By.cssSelector("#RememberMe");
	By btn_Login = By.name("btnSubmit");
	//By btn_Login = By.xpath("//button[@type='submit']");

	
	
	// ==============================================================================
	// Actions/Methods

	public void clickSignIn() {

		driver.findElement(lnk_SignIn).click();

	}
	
	public void enterUserName(String email) {

		driver.findElement(txt_email).clear();
		driver.findElement(txt_email).sendKeys(email);

	}

	public void enterPassword(String pwd) {

		driver.findElement(txt_pass).clear();
		driver.findElement(txt_pass).sendKeys(pwd);

	}

	public void setCheckbox() {

		driver.findElement(chk_rememberMe).click();

	}

	public void clickLoginButton() {

		driver.findElement(btn_Login).click();

	}
	
	
	public void verifyAppLicationTitle(String expectedTitle) {
		
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		
	}
	

}
