package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountHeading;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement btnContinue;

	public boolean isMyAccountPageExists() {
		try {
			return myAccountHeading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {
		lnkLogout.click();
	}

	public void clickContinue() {
		btnContinue.click();
	}

}
