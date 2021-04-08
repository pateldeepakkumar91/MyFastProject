package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "C:\\Users\\Owner\\eclipse-workspace\\GMail\\src\\main\\java\\Features\\Login.Features"
 ,glue={"stepDefinition"}
 )



public class TestRunner {
	
	
}
