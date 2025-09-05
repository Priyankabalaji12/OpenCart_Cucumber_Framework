package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageClass extends BasePageClass
{

	public RegisterPageClass(WebDriver driver)
	{
		super(driver);
		
	}
	
	//locators
	@FindBy(name="firstname")
	WebElement Firstname;
	
	@FindBy(id="input-lastname")
	WebElement lastname;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	
	@FindBy(name="telephone")
	WebElement telephone;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirm")
	WebElement confirm_password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement button;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement privacy_loc;
	
	@FindBy(xpath="//div//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement Confirmation_Message;
	
	//Action
	public void EnterFirstName(String name)
	{
		Firstname.sendKeys(name);
	}

	public void EnterLastName(String Lastname)
	{
		lastname.sendKeys(Lastname);
	}
	
	public void EnterEmail(String Email)
	{
		email.sendKeys(Email);
	}
	
	public void Entertelephone(String number)
	{
		telephone.sendKeys(number);
	}
	
	public void EnterPassword(String Password)
	{
		password.sendKeys(Password);
	}
	
	public void EnterConfirmPassword(String C_PWD)
	{
		confirm_password.sendKeys(C_PWD);
	}
	
	public void ClickButton()
	{
		button.click();
	}
	public void clickCheckbox()
	{
		privacy_loc.click();
	}
	public String getConfirmationMsg()
	{
		try
		{
			return(Confirmation_Message.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
		
	}
	
}
	
	
