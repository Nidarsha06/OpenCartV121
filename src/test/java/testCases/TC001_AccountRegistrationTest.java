package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression", "Master"})
	public void verify_account_registration() {

		try {
			logger.info("**** Starting TC001_AccountRegistrationTest ****");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");
			hp.clickRegister();
			logger.info("Clicked on Register link");

			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);

			logger.info("Providing customer details");
			regPage.setFirstName(randomString().toUpperCase());
			regPage.setLastName(randomString().toUpperCase());
			regPage.setEmail(randomString() + "ik@gmail.com");
			regPage.setTelephone(randomNumber());

			String password = randomAlphaNumeric();

			regPage.setPassword(password);
			regPage.confirmPassword(password);
			regPage.checkprivacyPolicy();
			regPage.clickContinueButton();

			logger.info("Validating expected message...");
			String confMsg = regPage.getConfirmationMsg();

			if (confMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}

//        Assert.assertEquals(confMsg, "Your Account Has Been Created!!!"); // Hard Assert, if failed next statements will not be executed
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail();
		}

		logger.info("**** Finished TC001_AccountRegistrationTest ****");
	}

}
