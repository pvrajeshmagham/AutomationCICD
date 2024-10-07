package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "rajeshautomationlearnings.Stepdefinition",
monochrome = true , tags = "@Subitorder", plugin = {"html:target/cucumber.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
