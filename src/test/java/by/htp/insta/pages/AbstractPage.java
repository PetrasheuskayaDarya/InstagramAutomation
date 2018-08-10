package by.htp.insta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

	protected WebDriver driver;

	public abstract void openPage();

	public AbstractPage(WebDriver driver) {
		this.driver = driver;

		// public void waitForElementPresent(By locator) {
		// new WebDriverWait(driver,
		// DEFAULT_TIMEOUT).until(ExpectedConditions.presenceOfElementsLocatedBy(locator));
		// }

		// protected void waitForElementPresent(By locator, int timeout) {
		// waitUntil(ExpectedConditions.presenceOfElementLocated(locator),
		// timeout);
		// }

		// private static final int DEFAULT_TIMEOUT = 10;

	}
}
