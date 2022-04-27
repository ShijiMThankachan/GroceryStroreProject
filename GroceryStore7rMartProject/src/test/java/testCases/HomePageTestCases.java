package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;

public class HomePageTestCases extends BaseClass {
	HomePageRepo hpObj;
	LoginPageRepo lpObj;
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void verifyLoginUserNameTC() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		lpObj.enterUserName();
		lpObj.enterPassword();
		lpObj.clickLogin();
		String actualUser = hpObj.getLoggedUser();
		String expectedUser = "Admin";
		softAssert.assertEquals(actualUser, expectedUser);
		softAssert.assertAll();

	}

	@Test
	public void verifyManagePagesMoreInfoLink() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		lpObj.enterUserName();
		lpObj.enterPassword();
		lpObj.clickLogin();
		String actualLandingPagetitle = hpObj.goToManagePages();
		String expectedTitle = "List Pages | 7rmart supermarket";
		softAssert.assertEquals(actualLandingPagetitle, expectedTitle, "More Info link is not working as expected");
		softAssert.assertAll();

	}

	@Test
	public void verifyTotalNumberOfDashboardItems() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		lpObj.enterUserName();
		lpObj.enterPassword();
		lpObj.clickLogin();
		int actualNoItems = hpObj.findTotalDashboardItems();
		int expectedNoItems = 14;
		softAssert.assertEquals(actualNoItems, expectedNoItems, "Dashboard items not as expected");
		softAssert.assertAll();

	}

}
