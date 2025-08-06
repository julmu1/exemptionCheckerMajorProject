package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

// This runner uses Serenity with Cucumber, referencing features and step definitions by package.
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks"}, // Add more packages as needed for modularisation
        plugin = {"pretty"},
        tags = "not @ignore" // Example: skip scenarios tagged with @ignore
)
public class RunCucumberTest {
    // No code needed here; configuration is via annotations and properties.
}