package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// 1) Constructor
	public HomePage(WebDriver driver) {
		// 'super' keyword invokes the immediate parent class constructor
		super(driver);
	}

	// 2) Locators
	@FindBy(css = "[title='My Account']")
	WebElement linkMyAccount;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement linkRegister;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginLink;

	// 3) Actions
	public void clickMyAccount() {
		linkMyAccount.click();
	}

	public void clickRegister() {
		linkRegister.click();
	}

	public void clickLogin() {
		loginLink.click();
	}

}
