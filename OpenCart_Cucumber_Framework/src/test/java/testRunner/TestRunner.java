package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(//features= {".//Features/Login.feature"},
		         features= {".//Features/Registration.feature"},
		           //features = {".//Features/LoginDDTExcel.feature"},
		         //  features={"@target/rerun.txt"},
		          // features= {".//Features/Login.feature",".//Features/Registration.feature"},

                 glue={"stepDefinitions","hooks"},
                 plugin= {"pretty", "html:reports/myreport.html", 
						  "rerun:target/rerun.txt",
						  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						},
                 dryRun=false,
                 monochrome=true,
                 publish=true
                // tags = "@sanity"
                 )
public class TestRunner 
{

}
