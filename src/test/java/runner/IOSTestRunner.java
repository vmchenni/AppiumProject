package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/UICatelog-2.json"},
        features = {"features"},
        monochrome = true,
        tags = {"@UICatalog"},
        glue = {"stepDefnition"},
        stepNotifications = true

        )
public class IOSTestRunner {
}
