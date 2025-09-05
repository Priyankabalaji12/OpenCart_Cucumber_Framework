package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageClass extends BasePageClass
{

	public HomePageClass(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement login_loc;
	
	//Action
	public void clickMyAccount()
	{
		MyAccount.click();
	}
	
	public void ClickRegister()
	{
		Register.click();
	}
	
	public void ClickLogin()
	{
		login_loc.click();
		
	}
   
}
