package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageClass;
import pageObjects.LoginPageClass;
import pageObjects.MyAccountPageClass;
import utilities.DataReader_From_Excel;

public class LoginSteps 
{
	WebDriver driver;
	HomePageClass hp;
	LoginPageClass lp;
	MyAccountPageClass acc;
	
	List<HashMap<String,String>> dataMap; //datadriven 
	
	
	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() 
	{
	    //logs message 
		BaseClass.getLogger().info("HomePage");
		hp = new HomePageClass(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.ClickLogin();
		BaseClass.getLogger().info("User redirected to Login Page......");
		
	
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String Username, String pwd) 
	{
	    BaseClass.getLogger().info("User is on Login Page entering email and password......");
	    lp = new LoginPageClass(BaseClass.getDriver());
	    lp.Enteremail_id(Username);
	    lp.Enter_Login_Password(pwd);
	    	    
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button()
	{
		BaseClass.getLogger().info("User clicked on Login Button.......");
		lp.Click_Login_Button();

	}

	
	@Then("the user should be redirected to the MyAccount Page")
	public void the_user_should_be_redirected_to_the_my_account_page() 
	{
	   BaseClass.getLogger().info("User redirected to My Account Page Successfully.....");
	   BaseClass.getLogger().info("checking that whether MyAccount Page is exists or not......");
	   
	   acc = new MyAccountPageClass(BaseClass.getDriver());
	   Boolean account_page_availablity =  acc.isMyAccountPageExists();
	   Assert.assertEquals(account_page_availablity,true);
	   BaseClass.getLogger().info("Execution successfully......");
	  
	}

	//Data driven testCase
	@Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
	public void the_user_should_be_redirected_to_the_my_account_page_by_passing_email_and_password_with_excel_row(String rows)
	{
	   //1.get the Location of the excel file by using dataMap
		/*
		 * if we are unable to find file then it will throw some exception to avoid that use try Catch block
		 */
		try 
		{
		//DataReader_From_Excel.data(System.getProperty("user.dir")+"\\testData\\OpenCart_LoginData","sheet1");
			dataMap = DataReader_From_Excel.data(System.getProperty("user.dir") + "\\testData\\OpenCart_LoginData", "sheet1");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		//2.from list[dataMap] get all the data's row wise and index wise 
		int index = Integer.parseInt(rows)-1;
		String email = dataMap.get(index).get("username");
		String pwd = dataMap.get(index).get("password");
		String exp_res = dataMap.get(index).get("res");
		
		//3.After i got the details i have to enter the data in Login Page 
		lp = new LoginPageClass(BaseClass.getDriver());
		lp.Enteremail_id(email);
		lp.Enter_Login_Password(pwd);
		lp.Click_Login_Button();
		
		acc = new MyAccountPageClass(BaseClass.getDriver());

		  //NOW PERFORM DATADRIVEN TESTING WRITE SOME LOGIC FOR THAT WITH VALID AND INVALID COMBINATION
		   /*
		    * IF DATA IS VALID ->LOGIN PASS->TEST CASE PASS->CLICK ON LOGOUT
		    *                  -> LOGIN FAIL-> TEST CASE FAIL
		    *                  
		    *  IF DATA IS NOT VALID -> LOGIN FAIL -> TEST CASE PASS
		    *                       -> LOGIN PASS -> TEST CASE FAIL
		    */
		   /*
		    * we are performing this from excel data so write that exp here
		    */
		
	 boolean targetpage = acc.isMyAccountPageExists();
		System.out.println("target_page = "+targetpage);
		
		if(exp_res.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				MyAccountPageClass acc = new MyAccountPageClass(BaseClass.getDriver());
				acc.ClickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp_res.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				acc.ClickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		
		
		
		
		
	   
	}
}
