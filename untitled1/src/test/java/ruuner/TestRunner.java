package ruuner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;



    @CucumberOptions(
            features = "src/test/java/features",
            glue = {"steps", "utils"},
            plugin = {
                    "pretty",
                    "html:target/cucumber-reports/cucumber.html",
                    "json:target/cucumber-reports/cucumber.json"
            },
            tags ="@${cucumber.filter.tags}" // Dynamic tag support
    )
    public class TestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return super.scenarios();
        }
}
