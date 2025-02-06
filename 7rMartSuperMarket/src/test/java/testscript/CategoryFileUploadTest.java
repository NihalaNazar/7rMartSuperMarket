package testscript;

import org.testng.annotations.Test;

import pages.CategoryFileUpload;
import pages.HomePage;
import pages.LoginPage7rMart;

public class CategoryFileUploadTest extends Base {
	CategoryFileUpload category;
	HomePage home;

	@Test
	public void verifyNewCategoryCreation() {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		category = home.categoryclick();
		category.ListNewCategory().EnterTheCategory("Biscuitss");
		category.selectshowOnTopMenu().selectshowOnLeftMenu().clickSave();
	}
}