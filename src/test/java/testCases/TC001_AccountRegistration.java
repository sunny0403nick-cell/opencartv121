package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistration  extends BaseClass {
	
	
	
	
	@Test(groups= {"Sanity","Master"})
	public void verify_registration() {
		
		try {
		
		logger.info("Test case TC001_AccountRegistration started");
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked my account link");
		hp.clickRegister();
		
		logger.info("clicked Registrtation link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details");
		regpage.setfirstName("nikhi");
		regpage.setlastName("vignes");
		regpage.setemail(randomeString()+"@gmail.com");
		//regpage.setemail("mesava2763@dawhe.com");
		
		//regpage.settelephone(randomeNumber());
		regpage.settelephone(randomeNumber());
		
		String passwd=randomeAlphaNumeric()	;
		regpage.setpasd(passwd);
		regpage.padcfm(passwd);
		regpage.subscribe();
		regpage.privacy();
		regpage.clkcontinue();
		String confirmmsg=regpage.getcnfmsg();
		
	logger.info("Validating expected msg");
		if(confirmmsg.equals("Your Account Has Been Created!")) {
			logger.info(confirmmsg);
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("Finished TC001_AccountRegistration test case");
		
	}
	

	

	
	
}
