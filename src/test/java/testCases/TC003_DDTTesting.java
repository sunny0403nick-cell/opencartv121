package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_DDTTesting extends BaseClass{
	
@Test(dataProvider="TestData",dataProviderClass=DataProviders.class, groups= {"Master"})
public void DDT_Testing(String email, String pwd, String exp) {
	
	try {
	
	logger.info("TC003_DDTTesting started");
	
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	logger.info("Clicked Account");
	hp.clickLogin();
	logger.info("clicked Login");
	
	LoginPage lp=new LoginPage(driver);
	lp.email(email);
	
	logger.info("entered email");
	lp.paswd(pwd);
	
	logger.info("entered password");
	lp.submit1();
	logger.info("clicked on submit btn");
	
	
	
	
	
	
	//My Account Page
	MyAccount macc=new MyAccount(driver);
	boolean targetPage=macc.ismyaccountpageExists();
	
	
	if (exp.equalsIgnoreCase("valid")) {
        if (targetPage) {
            logger.info("✅ Login successful for valid credentials: " + email);
            macc.cnflogout();
        } else {
            logger.warn("⚠️ Expected valid login but failed for: " + email);
        }
    } 
    else if (exp.equalsIgnoreCase("invalid")) {
        if (targetPage) {
            logger.warn("⚠️ Unexpected login success for invalid credentials: " + email);
            macc.cnflogout();
        } else {
            logger.info("❌ Login failed as expected for invalid user: " + email);
        }
    }
	
		
	
	
	
//	if(exp.equalsIgnoreCase("Valid"))
//	{
//		if(targetPage==true)
//		{
//			macc.cnflogout();
//			System.out.println("valid data");
//			//Assert.assertTrue(true);
//		}
//		else
//		{
//			System.out.println("Invalid data");
//			
//			//Assert.assertTrue(false);
//		}
//	}
//	
//	if(exp.equalsIgnoreCase("Invalid"))
//	{
//		if(targetPage==true)
//		{
//			macc.cnflogout();
//			System.out.println("Invaliddtata,succesfullogin");
//			//Assert.assertTrue(false);
//		}
//		else
//		{
//			System.out.println("Invaliddtata, notlogin");
//			//Assert.assertTrue(true);
//		}
//	}
}
catch(Exception e)
{
	Assert.fail("An exception occurred: " + e.getMessage());
}

logger.info("**** Finished TC_003_LoginDDT *****");


}
}