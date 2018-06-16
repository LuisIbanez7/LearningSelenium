package outline;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/outline/outline.feature", 
glue="src/test/java/outline",
plugin = {"pretty", "html:target/cucumber"})
public class RunnerOutline {

}
