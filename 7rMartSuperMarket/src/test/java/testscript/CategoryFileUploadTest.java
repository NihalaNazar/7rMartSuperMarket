package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import constants.Constant;
import pages.CategoryFileUpload;
import pages.HomePage;
import pages.LoginPage7rMart;
import utilities.ExcelUtility;

public class CategoryFileUploadTest extends Base {
	CategoryFileUpload category;
	HomePage home;
	

	@Test
	public void verifyNewCategoryCreation() throws IOException {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		String username=ExcelUtility.readStringData(3, 0, "LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		category = home.categoryclick();
		category.ListNewCategory().EnterTheCategory("Biscuitss");
		category.selectshowOnTopMenu().selectshowOnLeftMenu().clickSave();
		
	}
	@Test
	public void verifyUserIsAbleToDeleteCategory()throws IOException
	{
		LoginPage7rMart login = new LoginPage7rMart(driver);
		String username=ExcelUtility.readStringData(3, 0, "LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		category = home.categoryclick();
		category.clickOnDeleteButton();
		boolean deleteMessage=category.isDeleteSuccessfulMessageDisplayed();
		Assert.assertTrue(deleteMessage, Constant.SUBCATEGORYDELETIONUNSUCCESSFUL);
		
		
		
		
	}
}
    