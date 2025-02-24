package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//div[@id='content']//h1") // //h1[text()='Your Account Has Been Created!']
	WebElement msgConfirmation;

	public void setFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}

	public void setLastName(String lName) {
		txtLastName.sendKeys(lName);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void confirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}

	public void checkprivacyPolicy() {
		chkPolicy.click();
	}

	public void clickContinueButton() {
		btnContinue.click();
	}

	// JavascriptExecutor click
//	public void javaScriptExecutorClickContinueButton() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click()", btnContinue);
//	}

	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		} catch (Exception e) {
			return e.getMessage(); // gets the message if any exception
		}
	}

}
