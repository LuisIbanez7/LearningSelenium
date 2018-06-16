package tagging;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Tagged {
	WebDriver driver;
	@Given("^the user is on landing page$")
    public void setup() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bairo\\Desktop\\libraries eclipse\\geckodriver.exe");
	    driver = new FirefoxDriver(); 
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
    }

	@When("^she chooses to sign up$")
	public void she_chooses_to_sign_up() throws Throwable {
	   driver.findElement(By.xpath(".//button[@name='websubmit']")).click();
	   
	}
	 @When("^she provides the first name as \"([^\"]*)\"$") 
	   public void she_provides_the_first_name_as_Sukesh(String username) {
	      driver.findElement(By.id("email")).sendKeys(username);
	      
//	      driver.findElement(By.id("u_0_v")).click(); 
	   }
	
	 @Before
	    public void beforeScenario(){
	        System.out.println("this will run before the actual scenario");
	    }
    @Before("@Signup-DataDriven")
    public void signupSetup() {
        System.out.println("This should run everytime before any of the @Signup-DataDriven tagged scenario is going to run");
    }

    @After("@Signup-DataDriven")
    public void signupTeardown() {
        System.out.println("This should run everytime after any of the @Signup-DataDriven tagged scenario has run");
    }
}
