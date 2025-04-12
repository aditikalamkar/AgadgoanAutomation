package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

/**
 * This CucumberOptions used to run the scenarios based on tags.
 * Use tags = "@LoginE-Cart and @UI" to run LoginE-Cart feature
 * Use tags = "@GoogleSearch and @UI" to run google search feature
 * Use tags = "@API and @UI" to run LoginE-Cart feature
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/ECart.feature",
        glue = {"utils","stepdefinitions"},
        plugin = { "pretty", "html:target/cucumber-reports/report.html"},
        monochrome = true,
        tags = "@E-Cart"
)
public class TestRunner {
    //Initialize report generator
    @AfterClass
    public static void initReport() {

        try {
            System.out.println("Generating report");
            String[] cmd = {"cmd.exe", "/c", "npm run report"};
            Runtime.getRuntime().exec(cmd);
            System.out.println("Report generated successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
