package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class LoginPageRepo {
	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();

	public LoginPageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement butLogin;

	@FindBy(xpath = "//div[contains(@class,'alert')]")
	WebElement alertDiv;

	public void enterUserName(String user) {
		userName.sendKeys(user);
	}

	public void enterPassword(String passcode) {
		password.sendKeys(passcode);
	}

	public void clickLogin() {
		butLogin.click();
	}

	public String getAlertMsg() {
		String text = alertDiv.getText();
		String message = text.split("!")[1].trim();
		return message;
	}

	public String getLoginButtonText() {

		return guObj.getElementText(butLogin);
	}
}
