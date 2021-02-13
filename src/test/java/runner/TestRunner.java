package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        features = {"features"},
        monochrome = true,
        tags = {"@Sample"},
        glue = {"stepDefnition"}

        )
public class TestRunner {
}
