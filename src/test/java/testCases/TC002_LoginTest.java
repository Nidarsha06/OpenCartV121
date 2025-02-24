package testCases;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = {"Sanity", "Master"})
	public void verify_login() throws Exception {
		try {
			logger.info("**** Starting TC002_LoginTest ****");

			// HomePage
			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickLogin();

			// LoginPage
			// setting data (properties file)
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(prop.getProperty("email"));
			loginPage.setPassword(prop.getProperty("password"));
			loginPage.clickLogin();

			// MyAccountPage
			// Assertion
			MyAccountPage myAccPage = new MyAccountPage(driver);
			boolean targetPage = myAccPage.isMyAccountPageExists();
//		Assert.assertTrue(targetPage, "Login Failed"); // If failed "Login Failed" message will be displayed
			Assert.assertEquals(targetPage, true, "Login Failed"); // If failed "Login Failed" message will be displayed

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail();
		}

		logger.info("**** Finished TC002_LoginTest ****");
	}

}
