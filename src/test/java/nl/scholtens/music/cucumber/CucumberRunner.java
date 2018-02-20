package nl.scholtens.music.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = "html:target/MyMuiscResultPage",
    features = "src/test/resources/features",
        glue = "nl.scholtens.music.cucumber.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class CucumberRunner {

}
