package QETeam.LearningSelenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingWindows {
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
		driver.get("https://accounts.google.com/ServiceLogin/signinchooser?continue=https%3A%2F%2Fwww.google.com%2Fsearch%3Fq%3Dgoogle%26oq%3Dgoo%26aqs%3Dchrome.0.69i59j69i60l4j69i57.880j0j4%26sourceid%3Dchrome%26ie%3DUTF-8&hl=en&flowName=GlifWebSignIn&flowEntry=ServiceLogin");// navigate to the site
		// driver.navigate().to(""); navigate to the site
	}
	
	@Test
	public void multipleWindows() throws InterruptedException {
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[contains(@href, 'accounts?hl=en')]"))
		.click();
		Thread.sleep(1000);
		Set<String> windowns = driver.getWindowHandles();
		System.out.println(windowns.size());
		Iterator<String> it = windowns.iterator();
		String parent =  it.next();
		String child1 = it.next();
		driver.switchTo().window(child1);
		System.out.println(driver.getTitle());
//		Thread.sleep(1000);
		List<WebElement> WEL = driver.findElements(By.xpath("//section[@class='parent']"));
		for(WebElement box : WEL) {
			Thread.sleep(1000);
			box.click();
		}
		driver.close();
		driver.switchTo().window(parent);
		//end of test
		Thread.sleep(3000);
		driver.close();
//		driver.quit();//closes all windows
	}
}
