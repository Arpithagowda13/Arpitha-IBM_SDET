package CucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Feature1", glue = { "StepDefinition",
		"utilities" }, tags = "@smokeTest", plugin = { "pretty", "html:target/cucumber" })

public class Testrun1 {

}
