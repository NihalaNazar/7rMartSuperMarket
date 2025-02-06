package testscript;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage7rMart;
import pages.SubCategoryFileUpload;

public class SubCategoryFileUploadTest extends Base {
	SubCategoryFileUpload category;
	HomePage home;

	@Test
	public void verifyNewSubCategoryCreation() throws AWTException {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		category = home.categoryclicks();
		category.ClickOnNewButton().selectCategoryDropdown().enterSubCategory("vegs").ChooseImageFile().clickOnSaveButton();
		

	}
}