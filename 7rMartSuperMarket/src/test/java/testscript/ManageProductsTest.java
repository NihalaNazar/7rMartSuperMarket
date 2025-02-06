package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage7rMart;
import pages.ManageProductsPage;

@Test
public class ManageProductsTest extends Base {
	HomePage home;
	ManageProductsPage manage;

	@Test
	public void verifyValidProductSearch() {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		manage = home.manageProductClick();
		manage.searchClick().enterTitleOnTitleField("Boost Health & Energy Drink Pouch - 1kg ")
				.enterProductCodeOnField("P555").selectCategoryDropdown().selectSubcategoryDropDown()
				.clickOnSearchButton();
		boolean imageIsDisplayed = manage.isImageDisplayed();
		Assert.assertTrue(imageIsDisplayed, "search not found");
	}

}
