package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/featureFiles"
		,glue={"stepDefinition"},
		tags="@tripodeal_login"  //only this functionality now run
		)
public class TestRunner {
    
	}
