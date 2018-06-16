package QETeam.LearningSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonAutomation {
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	@BeforeTest
	public static void setters() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PSPLATFORM-STUDENT18\\Documents\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
	}

	@BeforeMethod
	public void givenRequirements() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		act = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		// driver.navigate().to(""); navigate to the site
		
	}
	@Test
	public void amazonActions() throws InterruptedException {
//		WebElement menu = wait.until(
//				ExpectedConditions.elementToBeClickable(
//						By.xpath("//*[@id='nav-link-shopall']")));
//		act.moveToElement(menu).build().perform();
		WebElement field = driver.findElement(
				By.cssSelector("input[id='twotabsearchtextbox']"));
		act.moveToElement(field).click()
		.sendKeys("i").sendKeys(Keys.SHIFT).sendKeys("phone")
		.sendKeys(" x").sendKeys(Keys.SHIFT).sendKeys(Keys.ENTER)
		.build().perform();
		
		WebElement IphoneLink = wait.until(
		ExpectedConditions.elementToBeClickable(
		By.xpath("//h2[contains(@class, 'a-size-medium')][1]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,250)", "");
		 IphoneLink.click();
		 WebElement button = wait.until(
				 ExpectedConditions.elementToBeClickable(
						 By.id("add-to-cart-button")));
		button.click();
		
		//assert
		
		//end of test
		Thread.sleep(3000);
		driver.close();
	}
}
