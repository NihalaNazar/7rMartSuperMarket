package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage7rMart;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	HomePage home;
	AdminUsersPage admin;
	FakerUtility faker = new FakerUtility();

	@Test
	public void newAdminUserCreation() {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		admin = home.adminsUserClick();
		String usernamefield = faker.getFakeFirstName();
		String passwordfield = faker.getPassword();
		admin.newClick().enterUsernameOnField(usernamefield).enterPasswordOnField(passwordfield).userTypeDropdown()
				.clickOnSaveButton();
		boolean alertMessage = admin.isAlertDisplayed();
		Assert.assertTrue(alertMessage, "new user creation is unsuccessful");
	}

	@Test
	public void searchUser() {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		admin = home.adminsUserClick();
		admin.clickOnSearchButton().enterNameOnSearchNameField("Nihala").selectUsertypeDropDown()
				.clickOnUserSearchButton();

	}
}