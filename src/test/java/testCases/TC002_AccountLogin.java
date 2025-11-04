package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.logging.log4j.core.config.Loggers;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;


public class TC002_AccountLogin extends BaseClass{
	
	
	
	
	@Test(groups= {"Regression","Master"})
	public void verify_login() throws IOException {
		
		
		try {
		logger.info("...TC002_AccountLogin started ...");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked Account");
		hp.clickLogin();
		logger.info("clicked Login");
		
		LoginPage lp=new LoginPage(driver);
		lp.email(p.getProperty("email"));
		logger.info("entered email");
		lp.paswd(p.getProperty("password"));
		logger.info("entered password");
		lp.submit1();
		logger.info("clicked on submit btn");
		
		
		MyAccount mp=new MyAccount(driver);
		boolean confirmatioin=mp.ismyaccountpageExists();
		logger.info("Page exists");
		//Assert.assertEquals(confirmatioin, true,"Failed");
		Assert.assertTrue(confirmatioin);
		
		
		
		
		
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Finished TC002_AccountLogin ");
	}
	

}
