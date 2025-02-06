package testscript;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage7rMart;

public class HomePageTest extends Base {
	HomePage home;

	@Test
	@Parameters({ "username", "password" })
	public void verifyLogIn(String username, String password) {

		LoginPage7rMart login = new LoginPage7rMart(driver);
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
	}
}








