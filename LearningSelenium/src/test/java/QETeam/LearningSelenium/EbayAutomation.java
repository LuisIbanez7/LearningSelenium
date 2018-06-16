package QETeam.LearningSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EbayAutomation {
	WebDriver driver;

	@BeforeTest
	public static void setters() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PSPLATFORM-STUDENT18\\Documents\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
	}

	@BeforeMethod
	public void givenRequirements() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");// navigate to the site
		// driver.navigate().to(""); navigate to the site
	}

	@Test
	public void ebayLinks() throws InterruptedException {

		List<WebElement> elList = driver.findElements(By.tagName("a"));
		System.out.println(elList.size());
		WebElement footer = driver.findElement(By.xpath("//footer[@id='glbfooter']"));
		List<WebElement> linkInF = footer.findElements(By.tagName("a"));
		System.out.println(linkInF.size());
		for (WebElement a : linkInF) {
			if (a.isDisplayed()) {
				System.out.println(a.getText());
			}
		}
		
		int count = driver.findElements(By.tagName("ffffff")).size();
		System.out.println(count);
		// end of test
		Thread.sleep(3000);
		driver.close();
	}
}
