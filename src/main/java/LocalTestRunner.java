import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "",
        plugin = {"pretty", "html:target/cucumber-reports"},
        features = "src/test/features",
        glue = {"steps",
                "utils"
        }
)
public class LocalTestRunner {
}