package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        plugin = {"pretty","html:target/cucumber/cucumber.html"},
        snippets = CAMELCASE,
//        dryRun = true,
        features = {"src/test/resources/Features"},
        glue = {"stepdef","hooks"},
        tags = "@Test"
)
public class RunnerTest extends AbstractTestNGCucumberTests {

}