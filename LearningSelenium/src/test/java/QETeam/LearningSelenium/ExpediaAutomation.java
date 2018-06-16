package QETeam.LearningSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExpediaAutomation {
	WebDriver driver;

	@BeforeTest
	public static void setters() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PSPLATFORM-STUDENT18\\Documents\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
	}

	@BeforeMethod
	public void givenRequirements() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.expedia.com/");
		// driver.navigate().to(""); navigate to the site
		
	}
	@Test
	public void travelingToNY() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@id='tab-flight-tab-hp']/span[2]"))
		.click();
		WebElement field = driver.findElement(By.xpath("//input[@id='flight-origin-hp-flight']"));
		field.sendKeys("dallas");
		field.sendKeys(Keys.ARROW_DOWN);
		field.sendKeys(Keys.ARROW_DOWN);
		field.sendKeys(Keys.ENTER);
		
		field = driver.findElement(By.xpath("//input[@id='flight-destination-hp-flight']"));
		field.sendKeys("New York");
		field.sendKeys(Keys.ARROW_DOWN);
		field.sendKeys(Keys.ARROW_DOWN);
		field.sendKeys(Keys.ENTER);
		//for='flight-departing-hp-flight'
		WebElement date = driver.findElement(
				By.xpath("//*[@for='flight-departing-hp-flight']"));
		date.click();
		System.out.println(date.getAttribute("for"));
		List<WebElement> dateList = driver.findElements(
				By.xpath("//button[contains(@class,'datepicker-cal-date')]"));
		for(WebElement days : dateList) {
			if(days.getAttribute("data-month") != null &&
					days.getAttribute("data-day") != null &&
					days.getAttribute("data-month").equals("5") &&
					days.getAttribute("data-day").equals("8")) {
				days.click();
				break;
			}
		}
		
		driver.findElement(
				By.xpath("//input[@id='flight-returning-hp-flight']")).click();
		//datepicker-cal-date highlight
		dateList = driver.findElements(
				By.xpath("//button[contains(@class,'datepicker-cal-date')]"));
		for(WebElement days : dateList) {
			if(days.getAttribute("data-month") != null &&
					days.getAttribute("data-day") != null &&
					days.getAttribute("data-month").equals("5") &&
					days.getAttribute("data-day").equals("12")) {
				days.click();
				break;
			}
		}
		
		//end of test
		Thread.sleep(3000);
		driver.close();
	}
}
