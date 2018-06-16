package QETeam.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import QETeam.helpers.HelperMethods;

public class FacebookSignUp {
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
		driver.get("https://www.facebook.com/");// navigate to the site
		// driver.navigate().to(""); navigate to the site
	}
	
	@Test
	public void SignUpTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='firstname']"))
		.sendKeys("Bairon");
		driver.findElement(By.xpath("//input[@name='lastname']"))
		.sendKeys("Vasquez");
		driver.findElement(By.xpath("//input[@name='reg_email__']"))
		.sendKeys("3478238992");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']"))
		.sendKeys("pass");
//		WebElement el = driver.findElement(By.xpath("//select[@id='month']"));
//		Select DOB = new Select(el);
//		DOB.selectByValue("11");
//		el = driver.findElement(By.xpath("//select[@id='day']"));
//		DOB = new Select(el);
//		DOB.selectByVisibleText("12");
//		el = driver.findElement(By.xpath("//select[@id='year']"));
//		DOB = new Select(el);
//		DOB.selectByIndex(5);
		
		HelperMethods.DOBTestHelper(driver, "11", By.xpath("//select[@id='month']"));
		HelperMethods.DOBTestHelper(driver, "12", By.xpath("//select[@id='day']"));
		HelperMethods.DOBTestHelper(driver, "2018", By.xpath("//select[@id='year']"));
		driver.findElement(By.xpath("//input[@value='2']")).click();//gender
		driver.findElement(By.xpath("//button[@type='submit']")).click();//sign up button
		Thread.sleep(2000);
		String expectedErrorMessage = "It looks like you entered the wrong info. Please be sure to use your real birthday.";
		WebElement errorEl = driver.findElement(By.xpath("//div[@id='reg_error_inner']"));
		assertThat(errorEl.isDisplayed(), equalTo(true));
		assertThat(errorEl.getText(), equalTo(expectedErrorMessage));
		//end of test
		Thread.sleep(5000);
		driver.close();
	}
}
