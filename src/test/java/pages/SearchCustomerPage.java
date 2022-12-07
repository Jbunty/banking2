package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchCustomerPage {

	WebDriver driver;

	public SearchCustomerPage(WebDriver coforgeDriver) {

		this.driver = coforgeDriver;

	}

	// Identification

	By txt_email = By.cssSelector("input#SearchEmail");
	By txt_FirstName = By.cssSelector("input#SearchFirstName");
	By btn_Search = By.cssSelector("button#search-customers");

	
	
	// ==============================================================================
	// Actions/Methods

	public void enterEmail(String email) {

		driver.findElement(txt_email).clear();
		driver.findElement(txt_email).sendKeys(email);

	}

	public void enterFirstName(String fName) {

		driver.findElement(txt_FirstName).clear();
		driver.findElement(txt_FirstName).sendKeys(fName);

	}

	

	public void clickSearchButton() {

		driver.findElement(btn_Search).click();

	}
	
	
	public void verifyAppLicationTitle(String expectedTitle) {
		
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		
	}
	

}
