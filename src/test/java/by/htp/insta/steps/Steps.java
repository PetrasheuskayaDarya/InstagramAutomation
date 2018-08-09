package by.htp.insta.steps;

import org.openqa.selenium.WebDriver;

import by.htp.insta.driver.DriverSingleton;
import by.htp.insta.pages.LoginPage;
import by.htp.insta.pages.MainPage;
import by.htp.insta.utils.MyInstaPropertyManager;

public class Steps {
	private WebDriver driver;
	MyInstaPropertyManager conf = new MyInstaPropertyManager();
	LoginPage loginPage = new LoginPage(driver);
	MainPage mainPage = new MainPage(driver);
	public static String hashTag = "#dotNET";
	public static String hashTag1 = "#reactjs";
	public static String hashTag2 = "#php";
	public static String hashTag3 = "#angular";

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void LogIn() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		loginPage.openPage();
		loginPage.login(conf.getLogin(), conf.getPass());
		mainPage.clickNotNowLink();
		mainPage.clickNotNowNotifications();
	}

	public void LikesForMarketing() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.inputHashTag(hashTag);
		mainPage.sendLikes();
	}

}