package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageClass extends BasePageClass
{

	public LoginPageClass(WebDriver driver) 
	{
		super(driver);
		
		// TODO Auto-generated constructor stub
	}

	//locators
	@FindBy(id="input-email")
	WebElement email_loc;
	
	@FindBy(id="input-password")
	WebElement password_loc;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement button_loc;
	
	//Action
	
	public void Enteremail_id(String email)
	{
		email_loc.sendKeys(email);
	}
	
	public void Enter_Login_Password(String pass)
	{
		password_loc.sendKeys(pass);
	}
	
	public void Click_Login_Button()
	{
		button_loc.click();
	}
}

