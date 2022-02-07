package runner;

import io.cucumber.junit.CucumberOptions;

import java.io.File;

import org.junit.After;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/features"},
		glue = {"StepDefinitions"},
				plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
				dryRun = false,
				monochrome = true
        )
public class RunCustomer {
	@After
	public void AfterScenario(Scenario scenario) {
	     Reporter.loadXMLConfig(new File("config/report.xml"));
	}
}