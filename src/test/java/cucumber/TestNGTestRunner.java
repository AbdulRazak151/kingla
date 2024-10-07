package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//@CucumberOptions(feature file path, glue=step definaton path, mono chrome=true, plugin)
@CucumberOptions(features="src/test/java/cucumber", glue="abdul01.SeleniumFrameworkDesign.stepdefinations",monochrome=true,tags= "@ErrorValidations",plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
