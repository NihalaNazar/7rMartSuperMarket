package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage7rMart;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	HomePage home;

	@Test(dataProvider = "credentials")

	public void verifyCorrectUsernameAndPassword(String username, String password) {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		boolean isHomepageIsLoaded = login.isDashboardIsLoaded();
		Assert.assertTrue(isHomepageIsLoaded, Constant.ERRORMESSAGEFORLOGIN);

	}

	@Test
	@Parameters({ "username", "password" })
	public void verifyInvalidUsernameAndCorrectPassword(String username, String password) {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		login.clickOnSignInButton();
		boolean isAlertLoaded = login.isAlertDisplayed();
		Assert.assertTrue(isAlertLoaded, Constant.ERRORMESSAGEFORLOGIN);

	}

	@Test(groups= {"smoke"})
	public void verifyCorrectUsernameAndInvalidPassword() throws IOException {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readIntegerData(1, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		login.clickOnSignInButton();
		boolean isAlertLoaded = login.isAlertDisplayed();
		Assert.assertTrue(isAlertLoaded, "login failed");

	}

	@Test
	public void verifyInvalidUsernameAndPassword() {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		login.enterUsernameOnField("adminss").enterPasswordOnField("123");
		login.clickOnSignInButton();
		String expected = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual, "login failed");

	}

	@DataProvider(name = "credentials")
	public Object[][] testData() {
		Object data[][] = { { "admin", "admin" } };
		return data;

	}

}