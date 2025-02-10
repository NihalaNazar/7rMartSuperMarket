package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.CategorySearchList;
import pages.HomePage;
import pages.LoginPage7rMart;
import utilities.ExcelUtility;

public class CategorySearchListTest extends Base {
	CategorySearchList category;
	HomePage home;
	
  @Test
  public void verifyTheUserAbleToSearchTheCategoryList() throws IOException
  {
	  LoginPage7rMart login = new LoginPage7rMart(driver);
	  String username=ExcelUtility.readStringData(3, 0, "LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		category=home.clickOnCategorysearch();
		category.clickOnsearch().enterCategoryList("Honey").clickOnsearch();
		boolean searchUNsuccessfulMessage=category.isSearchunSuccessfulMessageDisplayed();
		Assert.assertTrue(searchUNsuccessfulMessage, Constant.ERRORMESSAGEFORCATEGORYSEARCHUNSUCCESSFUL);
  }
}
