package runnnerFiles;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/featuresFiles/outline.feature", glue="src/test/java/stepDefinitionFile",plugin = {"pretty", "html:target/cucumber"})
public class RunTest{

}
