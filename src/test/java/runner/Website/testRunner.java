package runner.Website;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin = {"pretty","junit:reporting/Cucumber.xml",
        "json:reporting/Cucumber.json",
        "html:reporting/Cucumber.html"},
        features = {"src/test/java/features/Website"},
        glue = {"support",
                "resources",
                "stepDefinitions","pages"},

        tags = "@Registration or @ForgotPassword",
        monochrome = false,
        dryRun = false
)
public class testRunner extends AbstractTestNGCucumberTests {
}