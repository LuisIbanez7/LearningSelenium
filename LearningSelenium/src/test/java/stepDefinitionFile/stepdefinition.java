package stepDefinitionFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepdefinition {
	 WebDriver driver = null; 
		
	   @Given("^user navigates to Facebook$") 
	   public void goToFacebook() { 
		   System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bairo\\Desktop\\libraries eclipse\\geckodriver.exe");
	      driver = new FirefoxDriver(); 
	      driver.navigate().to("https://www.facebook.com/"); 
	   } 
		
	   @When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$") 
	   public void I_enter_Username_as_and_Password_as(String username, String password) {
	      driver.findElement(By.id("email")).sendKeys(username);
	      driver.findElement(By.id("pass")).sendKeys(password);
	      driver.findElement(By.id("u_0_v")).click(); 
	   } 
		
	   @Then("^login should be unsuccessful$") 
	   public void validateRelogin() { 
	      if(driver.getCurrentUrl().equalsIgnoreCase(
	      "https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
	         System.out.println("Test Pass"); 
	      } else { 
	         System.out.println("Test Failed"); 
	      } 
	      driver.close(); 
	   }    
}
