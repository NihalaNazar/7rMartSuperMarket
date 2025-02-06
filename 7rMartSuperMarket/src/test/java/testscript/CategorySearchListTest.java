package testscript;

import org.testng.annotations.Test;

import pages.CategorySearchList;
import pages.HomePage;
import pages.LoginPage7rMart;

public class CategorySearchListTest extends Base {
	CategorySearchList category;
	HomePage home;
	
  @Test
  public void verifyTheUserAbleToSearchTheCategoryList()
  {
	  LoginPage7rMart login = new LoginPage7rMart(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		category=home.clickOnCategorysearch();
		category.clickOnsearch().enterCategoryList("Honey").clickOnsearch();
  }
}
