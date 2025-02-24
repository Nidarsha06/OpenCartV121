package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
Data is valid - login success - test pass - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail - logout
Data is invalid -- login failed - test pass
*/

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "DataDriven") // getting provider from different class
	public void verify_loginDDT(String email, String pwd, String exp) throws Exception {

		try {
			logger.info("**** Starting TC003_LoginDDT ****");

			// HomePage
			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickLogin();

			// LoginPage
			// setting data (properties file)
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(email);
			loginPage.setPassword(pwd);
			loginPage.clickLogin();

			// MyAccountPage
			// Assertion
			MyAccountPage myAccPage = new MyAccountPage(driver);

			boolean targetPage = myAccPage.isMyAccountPageExists();

			// 1) Valid credentials
			// 1.1) Data is valid - login success - test pass - logout
			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					Assert.assertTrue(targetPage);
					myAccPage.clickLogout();
					myAccPage.clickContinue();
				}
				// 1.2) Data is valid -- login failed - test fail
				else {
					Assert.fail("Login failed");
					Assert.assertTrue(false);
				}
			}

			// 2) Invalid credentials
			// 2.1) Data is invalid - login success - test fail - logout
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					myAccPage.clickLogout();
					myAccPage.clickContinue();
					Assert.fail("Logged in with invalid credentials");
				}
				// 2.2) Data is invalid -- login failed - test pass
				else {
//				Assert.assertFalse(false, "Invalid credentials");
					Assert.assertTrue(true, "Invalid credentials");
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail();
		}

		logger.info("**** Finished TC003_LoginDDT ****");
	}

}
