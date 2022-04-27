package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class HomePageRepo {
	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();

	public HomePageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page' and @class='small-box-footer']")
	WebElement moreInfo;

	@FindBy(xpath = "//a[contains(text(),'Admin')]")
	WebElement loggedUser;

	@FindBy(xpath = "//div[@class='inner']/p")
	List<WebElement> dashboardItems;

	public String getLoggedUser() {

		return guObj.getElementText(loggedUser);
	}

	public String goToManagePages() throws InterruptedException {

		guObj.clickTheElement(moreInfo);
		String title = guObj.getTitleOfCurrentPage(driver);
		return title;

	}

	public int findTotalDashboardItems() {
		int items = dashboardItems.size();// to util
		return items;
	}

}
