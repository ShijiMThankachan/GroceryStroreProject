package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void clickTheElement(WebElement element) {
		element.click();
	}

	public String getTitleOfCurrentPage(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}
}
