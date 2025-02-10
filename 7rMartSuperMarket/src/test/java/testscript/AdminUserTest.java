package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage7rMart;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	HomePage home;
	AdminUsersPage admin;
	FakerUtility faker = new FakerUtility();

	@Test
	public void verifynewAdminUserCreation() throws IOException {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		String username=ExcelUtility.readStringData(3, 0,"LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		admin = home.adminsUserClick();
		String usernamefield = faker.getFakeFirstName();
		String passwordfield = faker.getPassword();
		admin.newClick().enterUsernameOnField(usernamefield).enterPasswordOnField(passwordfield).userTypeDropdown()
				.clickOnSaveButton();
		boolean alertMessage = admin.isAlertDisplayed();
		Assert.assertTrue(alertMessage, Constant.ERRORMESSAGEFORINVALIDUSERCREATION);
	}

	@Test
	public void verifyValidSearchUser() throws IOException {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		String username=ExcelUtility.readStringData(3, 0,"LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		admin = home.adminsUserClick();
		String UsernameCategory=ExcelUtility.readStringData(1, 0, "CategoryPage");
		admin.clickOnSearchButton().enterNameOnSearchNameField("Nihala").selectUsertypeDropDown()
				.clickOnUserSearchButton();
		boolean alertMessage=admin.isAlertDisplayed();
		Assert.assertTrue(alertMessage, Constant.ERRORMESSAGEFORINVALIDUSERSEARCH );

	}
}