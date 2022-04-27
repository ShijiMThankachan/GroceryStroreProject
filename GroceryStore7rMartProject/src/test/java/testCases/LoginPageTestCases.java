package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPageRepo;

public class LoginPageTestCases extends BaseClass {
	LoginPageRepo lpObj;

	@Test
	public void verifyLoginButtonText() throws Exception {
		lpObj = new LoginPageRepo(driver);
		String expectedResult = "Sign In";
		String actualResult = lpObj.getLoginButtonText();
		Assert.assertEquals(actualResult, expectedResult, "Login Text is not as expected");
	}

	/*
	 * @Test public void verifyInvalidUser() throws Exception { lpObj = new
	 * LoginPageRepo(driver); lpObj.enterUserName(); lpObj.enterPassword();
	 * lpObj.clickLogin(); String actualAlertMsg = lpObj.getAlertMsg(); String
	 * expectedAlertMsg = "Invalid Username/Password"; SoftAssert softAssert = new
	 * SoftAssert(); softAssert.assertEquals(actualAlertMsg, expectedAlertMsg,
	 * "Invalid user is permitted"); softAssert.assertAll();
	 * 
	 * }
	 */

}
