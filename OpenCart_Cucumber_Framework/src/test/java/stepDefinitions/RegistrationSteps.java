package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.HomePageClass;
import pageObjects.MyAccountPageClass;
import pageObjects.RegisterPageClass;

public class RegistrationSteps 
{
	WebDriver driver;
	HomePageClass hp;
	MyAccountPageClass acc;
    RegisterPageClass rp;
	
	
	@Given("the user navigates to Register Account page")
	public void the_user_navigates_to_register_account_page() 
	{
		BaseClass.getLogger().info("User is on HomePage.....");
	    hp = new HomePageClass(BaseClass.getDriver());
	    hp.clickMyAccount();
	    BaseClass.getLogger().info("User is on RegisterPage.......");
	    hp.ClickRegister();
	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(DataTable dataTable) 
	{
	   Map<String,String> dataMap = dataTable.asMap(String.class,String.class);
	   
	   rp = new RegisterPageClass(BaseClass.getDriver());
	   rp.EnterFirstName(dataMap.get("firstName"));
	   rp.EnterLastName(dataMap.get("lastName"));
	   rp.EnterEmail(BaseClass.Alphanumeric()+"@gmail.com");
	   rp.Entertelephone(dataMap.get("telephone"));
	   rp.EnterPassword(dataMap.get("password"));
	   rp.EnterConfirmPassword(dataMap.get("password"));
	   
	}

	@When("the user selects Privacy Policy")
	public void the_user_selects_privacy_policy() 
	{
	   rp.clickCheckbox();
	}

	@When("the user clicks on Continue button")
	public void the_user_clicks_on_continue_button() 
	{
	    rp.ClickButton();
	}

	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() 
	{
	    String Exp_message = rp.getConfirmationMsg();
	    Assert.assertEquals(Exp_message,"Your Account Has Been Created!");
	}


}
