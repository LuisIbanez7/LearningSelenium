package tagging;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (features = "src/test/java/tagging/", tags = "@Signup-DataDriven")
public class RunFeatures {

}