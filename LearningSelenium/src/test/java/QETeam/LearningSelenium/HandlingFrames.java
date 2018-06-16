package QETeam.LearningSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingFrames {
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
		driver.get("https://jqueryui.com/droppable/");
		// driver.navigate().to(""); navigate to the site
		
	}
	
	@Test
	public void dropIt() throws InterruptedException {
		//end of test
//		driver.navigate().back();
//		Thread.sleep(3000);
//		driver.navigate().forward();
		WebElement iframe = driver.findElement(
			By.xpath("//iframe[@src='/resources/demos/droppable/default.html']"));
		driver.switchTo().frame(iframe);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		act.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(3000);
		driver.close();
	}
}
