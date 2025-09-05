package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageClass extends BasePageClass
{

	public MyAccountPageClass(WebDriver driver) 
	{
		super(driver);
		
	}

	//locators
	//find the text of my account
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement MyAccount_loc;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement Logout_loc;
	
	//Action
	public boolean isMyAccountPageExists()
	{
	try
	{
		return (MyAccount_loc.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
	}
		
	}
	
	public void  ClickLogout()
	{
		Logout_loc.click();
	}
	
}
