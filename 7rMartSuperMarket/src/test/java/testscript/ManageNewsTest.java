package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage7rMart;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

@Test
public class ManageNewsTest extends Base {
	ManageNewsPage news;
	HomePage home;

	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyUserIsAbleToCreateNews() throws IOException {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		String username=ExcelUtility.readStringData(3, 0, "LoginPage");
		String password=ExcelUtility.readStringData(3, 1,"LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		news = home.clickOnManageNews();
		String newsValue=ExcelUtility.readStringData(4, 0, "LoginPage");
		news.ClickOnNewButton().enterNewsOnField(newsValue).clickOnSaveButton();
		boolean alertmessage = news.isAlertMessageDisplayed();
		Assert.assertTrue(alertmessage, Constant.ERRORMESSAGEFORUNSUCCESSFULNEWS);
	}

}
