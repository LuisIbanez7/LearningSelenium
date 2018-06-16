package QETeam.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperMethods {
	public static void DOBTestHelper(
			WebDriver driver, String byValue, 
			By by) {
		WebElement el = driver.findElement(by);
		Select DOB = new Select(el);
		DOB.selectByValue(byValue);
	}
}
