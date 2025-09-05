package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hooks
{
  WebDriver driver ;
  Properties p;
  
 @Before
 public void setup() throws IOException
  {
	  driver = BaseClass.BrowserandOs();
	  p = BaseClass.getProperties();
	  driver.get(p.getProperty("appURL"));
	  driver.manage().window().maximize();
  }
  
 @After
  public void teardown()
  {
	 if(driver!=null)
	 {
	  driver.quit();
	 }
  }
 
 
 
}
