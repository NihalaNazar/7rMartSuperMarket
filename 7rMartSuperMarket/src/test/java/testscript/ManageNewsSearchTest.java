package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage7rMart;
import pages.ManageNewsSearch;
import utilities.ExcelUtility;

public class ManageNewsSearchTest extends Base {
	ManageNewsSearch  news;
	HomePage home;
	
  @Test(retryAnalyzer=retry.Retry.class)
  public void verifyUserIsAbleToSearchNews() throws IOException {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		news=home.manageNewssearch();
		news.clickOnSearch().enterNewsOnField("GOOD NEWSS").clickOnSearchButton();
		
  }
}
