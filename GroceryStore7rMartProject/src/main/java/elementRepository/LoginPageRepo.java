package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelRead;
import Utilities.GeneralUtilities;

public class LoginPageRepo {
	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	ExcelRead erObj = new ExcelRead();
	String user;
	String passcode;

	public LoginPageRepo(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		getUsername();

	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement butLogin;

	@FindBy(xpath = "//div[contains(@class,'alert')]")
	WebElement alertDiv;

	public void getUsername() throws Exception {
		String[] loginDatas = erObj.readLoginCredentialsFromExcel();
		user = loginDatas[0];
		passcode = loginDatas[1];
	}

	/*
	 * public void getInvalidUsername() throws Exception { String[] loginDatas =
	 * erObj.readInvalidLoginCredentialsFrExcel(); user = loginDatas[0]; passcode =
	 * loginDatas[1]; }
	 */
	public void enterUserName() {
		userName.sendKeys(user);
	}

	public void enterPassword() {
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
