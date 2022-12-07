package actionExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class globalsqaExample {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
	}

	
	@Test
	public void dragdropTest() throws Exception {
		
		
		Thread.sleep(4000);
		WebElement drag_drop_frame = driver.findElement(By.xpath("//iframe[contains(@data-src,'droppable/photo-manager')]"));
		driver.switchTo().frame(drag_drop_frame);
		
		WebElement img_3 = driver.findElement(By.xpath("//img[contains(@src,'high_tatras3')]"));
		WebElement img_4 = driver.findElement(By.xpath("//img[contains(@src,'high_tatras4')]"));
		WebElement trash = driver.findElement(By.cssSelector("div#trash"));
		
		Actions act = new Actions(driver);
		
		//Method1
		act.dragAndDrop(img_3, trash).perform();
		Thread.sleep(2000);
//		act.dragAndDrop(img_4, trash).perform();
		
		
		//A convenience method that performs click-and-hold at the location of the source element, 
		//moves to the location of the target element, then releases the mouse.
		
		
		//Method2
		
		act.clickAndHold(img_4).moveToElement(trash).release().perform();
		
		
		
		
	}
	
	
}
