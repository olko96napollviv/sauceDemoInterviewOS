package sauceDemo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"sauceDemo/stepdefinitions"},
        dryRun = false, // when set as true, will run over the feature steps and reveal unimplemented steps in console
        tags = "@demo",
        monochrome = true,
        plugin = {"pretty", // will print executed steps inside console
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-default-reports.html", // generates default html report
        }
)
public class TestRunner {

}
