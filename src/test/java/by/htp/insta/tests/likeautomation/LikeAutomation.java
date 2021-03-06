package by.htp.insta.tests.likeautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.insta.steps.Steps;

public class LikeAutomation {
	private Steps steps;

	@BeforeMethod(description = "Init browser", groups = { "likeAutomation" })
	public void setUp() throws InterruptedException {
		steps = new Steps();
		steps.initBrowser();
		steps.LogIn();
		Thread.sleep(3000);
	}

	@Test(groups = { "likeAutomation" })
	public void LikesAutomation() throws InterruptedException {
		steps.LikesForMarketing();
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
