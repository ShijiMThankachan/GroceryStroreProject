package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.LoginPageRepo;

public class LoginPageTestCases extends BaseClass {
	LoginPageRepo lpObj;

	@Test
	public void verifyLoginButtonText() {
		lpObj = new LoginPageRepo(driver);
		String expectedResult = "Sign In";
		String actualResult = lpObj.getLoginButtonText();
		Assert.assertEquals(actualResult, expectedResult, "Login Text is not as expected");
	}

	@Test
	public void verifyInvalidUser() {
		lpObj = new LoginPageRepo(driver);
		lpObj.enterUserName("shiji");
		lpObj.enterPassword("shiji");
		lpObj.clickLogin();
		String actualAlertMsg = lpObj.getAlertMsg();
		String expectedAlertMsg = "Invalid Username/Password";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualAlertMsg, expectedAlertMsg, "Invalid user is permitted");
		softAssert.assertAll();

	}
}
