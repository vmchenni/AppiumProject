package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        features = {"features"},
        monochrome = true,
        tags = {"@GeneralStore"},
        glue = {"stepDefnition"},
        stepNotifications = true


        )
public class TestRunner {
}
