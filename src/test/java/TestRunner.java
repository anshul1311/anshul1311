import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import utils.logger.Log;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefination"},
        plugin = { "pretty",
                "html:./reports/cucumber-reports/cucumber-html/index.html",
                "rerun:target/failedrerun.txt"},
        tags = ""

)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        Log.info("Start Test");
        return super.scenarios();
    }
}
