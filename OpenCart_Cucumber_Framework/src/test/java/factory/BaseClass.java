package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass
{
	static WebDriver driver;
	static Properties p;
	static Logger logger;
	
	
    @SuppressWarnings("deprecation")
	public static WebDriver BrowserandOs() throws IOException
    {
    	p = getProperties();
    	String executionenv = p.getProperty("execution_env");
    	String browser = p.getProperty("browser").toLowerCase();
    	String os = p.getProperty("os").toLowerCase();
    	
    	if(executionenv.equalsIgnoreCase("remote"))
    	{
    		//os
    		DesiredCapabilities capabilities = new DesiredCapabilities();
    		switch(os)
    		{
    		case "windows" : capabilities.setPlatform(Platform.WINDOWS);break;
    		case "mac " :capabilities.setPlatform(Platform.MAC);
    		case "linux" : capabilities.setPlatform(Platform.LINUX);
    		default : System.out.println("Invalid Platform.....");
    		return null;
    		}
    		
          //browser
    		switch(browser.toLowerCase())
    		{
    		case "chrome" : capabilities.setBrowserName("chrome");break;
    		case "edge" : capabilities.setBrowserName("MicrosoftEdge");break;
    		case "firefox" : capabilities.setBrowserName("firefox");break;
    		default : System.out.println("No Matching Browser");return null;
    		}
    		

    		//driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
    		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
    	}
    	
    	
    	
    	else if(executionenv.equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase())
			 {
			 case "chrome":driver = new ChromeDriver();break;
			 case "Microsoft Edge":driver = new EdgeDriver();break;
			 case "firefox":driver = new FirefoxDriver();break;
			 default : System.out.println("Invalid browser...");driver = null;
			 }
		}

    	
    	
    	//driver = new ChromeDriver();
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	 driver.manage().deleteAllCookies();
    	
    	//driver.get("appURL");
    	 
    	 return driver;
    }
    
    //create one userdefined method for reading properties from Config.properties
    public static Properties getProperties() throws IOException
    {
    	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
    	p = new Properties();
    	p.load(file);
    	return p;
    	
    	
    }
    
    //create userdefined method for generation of logs
    
    //while creating object for Pageobjectclass under Stepdefn we can invoke this getdriver as parameter from BaseClass
    public static WebDriver getDriver()
    {
    	return driver;
    }
    public static Logger getLogger()
    {
		logger=LogManager.getLogger();
		return logger;
    	
    }
  //need to create userdefined method for random string,number and alphanumeric generation
  	public static String randomString()
  	{
  		String randomname = RandomStringUtils.randomAlphabetic(5);
  		return randomname;
  		
  	}
  	
  	public static String randomNumber()
  	{
  		String randomnumber01 = RandomStringUtils.randomNumeric(10);
  		return randomnumber01;
  	}
  	
  	public static String Alphanumeric()
  	{
  		String randomname = RandomStringUtils.randomAlphabetic(5);
  		String randomnumber01 = RandomStringUtils.randomNumeric(10);
  		
  		return randomname+"90"+randomnumber01;
  		
  	}
}
