package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends Basepage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-firstname")
	WebElement txtFirstName;
	
	@FindBy(xpath="//*[@name='lastname']")
	WebElement txtLastName;
	
	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(xpath="//*[@name='telephone']")
	WebElement txtTelephone;
	
	@FindBy(id="input-password")
	WebElement txtPasswd;
	
	@FindBy(xpath="//*[@name='confirm']")
	WebElement passwdcfm;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement btnSubscribe;
	
	@FindBy(xpath="//*[@name='agree']")
	WebElement btnChecked;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setfirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setlastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void setemail(String inemail) {
		txtEmail.sendKeys(inemail);
	}
	public void settelephone(String tele) {
		txtTelephone.sendKeys(tele);
	}
	public void setpasd(String passwd) {
		txtPasswd.sendKeys(passwd);
	}
	public void padcfm(String cnfpasswd) {
		passwdcfm.sendKeys(cnfpasswd);
	}
	public void subscribe() {
		btnSubscribe.click();
	}
	
	public void privacy() {
		btnChecked.click();
	}
	public void clkcontinue() {
		btnContinue.click();
	}
	
	public String getcnfmsg() {
		try {
			return(msgConfirmation.getText());
		}
	catch(Exception e) {
		return(e.getMessage());
	}
	}
	
	
}
