package lecture18.hw;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/RabotaBy.feature"},
        plugin = {
                "json:target/cucumber.json",
                "html:target/site/cucumber-pretty"
        },
        glue = "CucumberSteps/rabotaBy")
public class RunRabotaBy extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
