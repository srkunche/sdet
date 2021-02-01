package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"StepDefinitions"},
    tags = "@CRM or @HRM or @Jobs",
    strict = true,
    plugin = {"pretty", "html:Test_Reports/Cucumber_Project_Report.html","json:Test_Reports/Cucumber_Project_Report.json"},
    monochrome = true
)

public class ActivityRunner {

}
