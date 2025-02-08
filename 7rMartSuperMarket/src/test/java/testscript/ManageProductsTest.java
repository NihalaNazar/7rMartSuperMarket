package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage7rMart;
import pages.ManageProductsPage;
import utilities.ExcelUtility;

@Test
public class ManageProductsTest extends Base {
	HomePage home;
	ManageProductsPage manage;

	@Test
	public void verifyValidProductSearch() throws IOException {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		String username=ExcelUtility.readStringData(3, 0, "LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "password");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		manage = home.manageProductClick();
		String title=ExcelUtility.readStringData(5, 0, "LoginPage");
		String productCode=ExcelUtility.readStringData(5, 1, "LoginPage");
		manage.searchClick().enterTitleOnTitleField(title)
				.enterProductCodeOnField(productCode).selectCategoryDropdown().selectSubcategoryDropDown()
				.clickOnSearchButton();
		boolean imageIsDisplayed = manage.isImageDisplayed();
		Assert.assertTrue(imageIsDisplayed, Constant.ERRORMESSAGEFORINVALIDPRODUCTSEARCH);
	}

}
