package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationPageTest extends BaseTest {

	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() {
		try {
		logger.info("***** Test case started *****");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("My account Clicked");
		hp.clickRegister();
		logger.info("Registration Clicked");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("Providing Customer details...");
		regpage.setFirstName(randomString());
		regpage.setLastName(randomString());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		String pass = randomAlphaNumberic();
		regpage.setPassword(pass);
		
		regpage.setConfirmPassword(pass);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Validating expected message");
		String confmsg = regpage.getConfirmationmsg();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test Failed"); 
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}catch(Exception e) {
			Assert.fail();
		}
	
	}
}
