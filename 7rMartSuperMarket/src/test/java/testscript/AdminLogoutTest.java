package testscript;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage7rMart;

public class AdminLogoutTest extends Base {
	HomePage home;

	@Test
	public void verifyUserIsAbletoLogOut() {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		home.logoutclick();

	}
}
