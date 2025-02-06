package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage7rMart;
import pages.ManageNewsPage;

@Test
public class ManageNewsTest extends Base {
	ManageNewsPage news;
	HomePage home;

	@Test
	public void verifyUserIsAbleToCreateNews() {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		news = home.clickOnManageNews();
		news.ClickOnNewButton().enterNewsOnField("good news").clickOnSaveButton();
		boolean alertmessage = news.isAlertMessageDisplayed();
		Assert.assertTrue(alertmessage, "news creation is unsuccessful");
	}

}
