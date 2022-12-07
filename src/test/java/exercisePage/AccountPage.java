package exercisePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountPage {

	WebDriver driver;

	public AccountPage(WebDriver coforgeDriver) {

		this.driver = coforgeDriver;

	}

	// Identification

	By txt_email = By.cssSelector("input#Email");
	By txt_pass = By.name("Password");
	By chk_rememberMe = By.cssSelector("#RememberMe");
	By chk_grid = By.cssSelector("#RememberMe");
	By btn_GO = By.xpath("//button[text()='Log in']");
	//By btn_Login = By.xpath("//button[@type='submit']");

	
	
	// ==============================================================================
	// Actions/Methods

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

	public void clickGoButton() {

		driver.findElement(btn_GO).click();

	}
	
	
	public void verifyAppLicationTitle(String expectedTitle) {
		
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		
	}
	

}
