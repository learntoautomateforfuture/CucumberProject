package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",
				monochrome =true,
				dryRun=false,
				glue="StepDefinition",
				tags={"~@SmokeTest,~@RegressionTest,@NegativeTest"},
				plugin= {"html:target/cucumber-report/",
						 "json:target/cucumber.json",
						 "pretty:target/cucumber-pretty.txt",
						 "junit:target/cucumber-results.xml",})
public class TestRunner {

}
