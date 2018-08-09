package by.htp.insta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

	private final String BASE_URL = "https://www.instagram.com/accounts/login";

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	@FindBy(name = "username")
	private WebElement loginField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginButton;

	@FindBy(xpath = "//*[@id='react-root']/section/main/div/article/div/div[2]/p/a")
	private WebElement singUpLink;

	@FindBy(id = "slfErrorAlert")
	private WebElement alertMessage;

	@FindBy(linkText = "Log in")
	private WebElement loginLink;

	@FindBy(xpath = "//*[@id=\'react-root\']/div/div[2]/a[2]")
	private WebElement LinkNotNow;

	public void inputLogin(String login) {
		loginField.sendKeys(login);
	}

	public void inputPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLogInButton() {
		loginButton.click();
	}

	public void login(String login, String password) {
		loginField.sendKeys(login);
		passwordField.sendKeys(password);
		loginButton.click();
	}

	public void loginValid(String login, String password) {
		login(login, password);
		WebElement dinamicElement = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\'react-root\']/div/div[2]/a[2]")));
	}

	public void loginInvalid(String login, String password) {
		login(login, password);
		WebElement dinamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("slfErrorAlert")));
	}

	public String getTextSignUpLink() {
		String SingUp = singUpLink.getText();
		return SingUp;
	}

	public String getAlertMessage() {
		String WrongPassword = alertMessage.getText();
		return WrongPassword;
	}

	public void clickLoginLink() {
		loginLink.click();
	}

	public void pushTabButton() {
		passwordField.sendKeys(Keys.TAB);
	}

	public void pushEnterButton() {
		passwordField.sendKeys(Keys.ENTER);
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}
