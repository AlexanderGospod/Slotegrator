package ui;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "ui",
        tags = "@all",
        snippets = SnippetType.UNDERSCORE
)
public class UiTestTask {
}
