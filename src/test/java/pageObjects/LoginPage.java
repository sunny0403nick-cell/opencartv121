package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//*[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//*[@type='password']")
	WebElement passwd;
	
	@FindBy(xpath="//*[@value='Login']")
	WebElement submit;
	
	@FindBy(xpath="//div[normalize-space()='Warning: No match for E-Mail Address and/or Password.']")
	public
	WebElement error;
	
	public void email(String loginemail) {
		
		email.sendKeys(loginemail);
		
	}
	public void paswd(String pad) {
		
		passwd.sendKeys(pad);
	}
	
	public void submit1() {
		submit.click();
	}
	

}
