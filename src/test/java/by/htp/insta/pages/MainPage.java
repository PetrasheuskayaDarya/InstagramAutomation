package by.htp.insta.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://mail.ru/login";
	int numbersOfLikes = 4;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	@FindBy(xpath = "//button[text()='Not Now']")
	private WebElement NotNowNotifications;

	@FindBy(xpath = "//button[text()='Log Out']")
	private WebElement logOutButton;

	@FindBy(xpath = "//*[@id=\'react-root\']/div/div[2]/a[2]")
	private WebElement LinkNotNow;

	@FindBy(className = "coreSpriteDesktopNavProfile")
	private WebElement profileUser;

	@FindBy(className = "dCJp8")
	private WebElement parameters;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchField;

	@FindBy(xpath = "//*[@id='react-root']/section/main/article/div[1]/div/div/div[1]/div[1]/a")
	private WebElement firstPost;

	@FindBy(xpath = "//button[contains(@class,'coreSpriteHeartOpen')]/span")
	private WebElement heartButton;

	@FindBy(xpath = "//div[@class='fuqBx']/a[1]")
	private WebElement firstItemFromDropDown;

	@FindBy(xpath = "//div[contains(@class,'Nnq7C')]/div")
	private List<WebElement> listOfAllPosts;

	@FindBy(xpath = "//*[@id='react-root']/section/main/article/div[2]/div/div[1]/div[1]/a/div/div[2]")
	private WebElement firstRecentPost;

	@FindBy(xpath = "//a[text() = 'Next']")
	private WebElement nextPostButton;

	public void clickOnParameters() {
		parameters.click();
	}

	public void clickNotNowNotifications() {
		NotNowNotifications.click();
	}

	public void clickOnLogOutButton() {
		logOutButton.click();
	}

	public void clickNotNowLink() {
		LinkNotNow.click();
	}

	public String getTextNotNowNotification() {
		String profile = NotNowNotifications.getText();
		return profile;
	}

	public void clickOnProfileUser() {
		profileUser.click();
	}

	public void waitElementNotNowPresent() {
		WebElement dinamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Not Now']")));
	}

	public void waitElementSearchFieldPresent() {
		WebElement dinamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']]")));
	}

	public void inputHashTag(String hashTag) {
		searchField.sendKeys(hashTag);
		firstItemFromDropDown.click();
	}

	public void clickLikeOnFirstPost() {
		firstPost.click();
		heartButton.click();
	}

	public void clickOnEmptyArea() {
		Actions action = new Actions(driver);
		action.moveToElement(heartButton, 300, 100).click().build().perform();
	}

	public void sendLikes() throws InterruptedException {
		firstRecentPost.click();
		int count = 0;
		do {
			if (LikedOrNot() == true) {
				heartButton.click();
				Thread.sleep(2000);
				nextPostButton.click();
				count++;
			} else if (LikedOrNot() == false) {
				nextPostButton.click();
			}
		} while (count < numbersOfLikes);
	}

	public boolean LikedOrNot() {
		String str1 = heartButton.getAttribute("aria-label");
		if (str1.equals("Like")) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement getFirstRecentPost() {
		return firstRecentPost;
	}

	public WebElement getNextPostButton() {
		return nextPostButton;
	}

}
