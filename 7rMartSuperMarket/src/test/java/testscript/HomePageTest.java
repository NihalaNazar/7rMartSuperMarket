package testscript;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage7rMart;
import utilities.ExcelUtility;

public class HomePageTest extends Base {
	HomePage home;

	@Test
	@Parameters({ "username", "password" })
	public void verifyLogIn(String username, String password) throws IOException {

		LoginPage7rMart login = new LoginPage7rMart(driver);
		String username1=ExcelUtility.readStringData(1, 0,"LoginPage");
		String password1=ExcelUtility.readStringData(1, 1, "LoginPage");
		login.enterUsernameOnField(username1).enterPasswordOnField(password1);
		home = login.clickOnSignInButton();
		home.logout();
	}
}








