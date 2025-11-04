package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends Basepage{

	public MyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement mycnfmsh;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;
	
	public boolean ismyaccountpageExists() {
		
		try {
		return (mycnfmsh.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	public void cnflogout() {
		logout.click();
	}

}
