package by.htp.insta.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	int numbersOfLikes = 3;

	public static List<String> hashTags = new ArrayList<String>();
	public String tag1 = "#dotNET";
	public String tag2 = "#reactjs";
	public String tag3 = "#php";
	public String tag4 = "#angular";
	public String tag5 = "#rubyonrails";

	int a = 1;
	int b = 3;
	int random_number = a + (int) (Math.random() * b);

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

	@FindBy(xpath = "//*[@id='react-root']/div/div[2]/a[2]")
	private WebElement LinkNotNow;

	@FindBy(className = "coreSpriteDesktopNavProfile")
	private WebElement profileUser;

	@FindBy(className = "dCJp8")
	private WebElement parameters;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchField;

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

	@FindBy(xpath = "//button[@class='ckWGn']")
	private WebElement closePostButton;

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

	public WebElement waitForFirstItemInDropDownPresent() {
		WebElement dinamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='fuqBx']/a[1]")));
		return dinamicElement;
	}
	
	public void waitForPageLoads() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	public void clickOnFirstItemInDropDown() {
		waitForFirstItemInDropDownPresent().click();
	}

	public void clickOnEmptyArea() {
		Actions action = new Actions(driver);
		action.moveToElement(heartButton, 400, 0).click().build().perform();
	}

	public void clickOnClosePostButton() {
		closePostButton.click();
	}

	public void clickLikeIn90PercentOfCases() throws InterruptedException {
		double d = Math.random() * 100;
		if ((d -= 90) < 0) {
			Thread.sleep((long) (Math.random() * 2000));
			heartButton.click();
		} else {
			Thread.sleep((long) (Math.random() * 2000));
			nextPostButton.click();
		}
	}

	public void iteraction() throws InterruptedException {
		firstRecentPost.click();
		int count = 0;
		do {
			if (LikedOrNot() == true) {
				clickLikeIn90PercentOfCases();
				count++;
			} else if (LikedOrNot() == false) {
				nextPostButton.click();
			}
		} while (count < random_number);
	}

	public void sendLikes() throws InterruptedException {
		List<String> hashTags = new ArrayList<String>(6);

		hashTags.add(new String(tag1));
		hashTags.add(new String(tag2));
		hashTags.add(new String(tag3));
		hashTags.add(new String(tag4));
		hashTags.add(new String(tag5));

		int count = 0;
		do {
			searchField.sendKeys(hashTags.get(0));
			clickOnFirstItemInDropDown();
			waitForPageLoads();
			hashTags.remove(0);
			System.out.println(hashTags);
			iteraction();
			clickOnClosePostButton();
			count++;
		} while (count < 5);

	}

	public boolean LikedOrNot() throws InterruptedException {
		Thread.sleep(2000);
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
