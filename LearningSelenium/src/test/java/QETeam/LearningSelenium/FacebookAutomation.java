package QETeam.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.not;
public class FacebookAutomation {
	
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
		driver.get("https://www.facebook.com/");//navigate to the site
//		driver.navigate().to(""); navigate to the site
	}
	@Test
	public void facebookLoginTest() throws InterruptedException {
		String initialTitle = driver.getTitle();
		driver.findElement(By.xpath("//input[@id='email']"))
		.sendKeys("Whatever");
		
		driver.findElement(By.xpath("//input[@id='pass']"))
		.sendKeys("pass");
		
		driver.findElement(By.xpath("//input[@id='u_0_2']"))
		.click();
		//Thread.sleep(1000);
		String errorTitle = driver.getTitle();
		assertThat(errorTitle, not(equalTo(initialTitle)));
//		import static org.hamcrest.CoreMatchers.equalTo;
//		import static org.hamcrest.CoreMatchers.not;
//		import static org.hamcrest.MatcherAssert.assertThat;
		//end of test
		Thread.sleep(3000);
		driver.close();
	}
	
}
