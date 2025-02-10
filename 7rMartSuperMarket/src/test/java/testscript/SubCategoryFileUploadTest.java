package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersPage;
import pages.CategoryFileUpload;
import pages.HomePage;
import pages.LoginPage7rMart;
import pages.SubCategoryFileUpload;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class SubCategoryFileUploadTest extends Base {
	SubCategoryFileUpload subcategory;
	HomePage home;
	CategoryFileUpload category;
	AdminUsersPage admin;
	FakerUtility faker=new FakerUtility();

	@Test
	public void verifyNewSubCategoryCreation() throws AWTException, IOException {
		LoginPage7rMart login = new LoginPage7rMart(driver);
		String username=ExcelUtility.readStringData(3, 0,"LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		String subcategoryNameField=faker.getFakeFirstName();
		subcategory = home.categoryclicks();
		subcategory.newClick().subcategoryDropdown().enterSubCategory(subcategoryNameField).ChooseImageFile().clickOnSaveButton();
		boolean statusMessage=subcategory.isCreateSuccessMessageDisplayed();
		Assert.assertTrue(statusMessage, Constant.SUBCATEGORYCREATIONUNSUCCESSFUL);

	}
	@Test
	
	public void verifyUserIsAbleTosearchSubCategory() throws IOException
	{
		LoginPage7rMart login = new LoginPage7rMart(driver);
		String username=ExcelUtility.readStringData(3, 0,"LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		subcategory=home.categoryclicks();
		String subCategory=ExcelUtility.readStringData(5, 2,"LoginPage");
		subcategory.clickOnsearchButton().searchsubcategoryDropdown().enterSubcategoryOnField(subCategory).clickOnsearchButton();
		boolean statusMessage=subcategory.isactivestatusdisplayed();
		Assert.assertTrue(statusMessage, Constant.ERRORMESSAGEFORINVALIDSUBCATEGORYSEARCH);
		
		
	}
	public void VerifyUserIsAbleToDeleteCategory() throws IOException
	{
		LoginPage7rMart login = new LoginPage7rMart(driver);
		String username=ExcelUtility.readStringData(3, 0,"LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		category=home.categoryclick();
		category.clickOnDeleteButton();
		boolean deleteMessage=category.isDeleteSuccessfulMessageDisplayed();
		Assert.assertTrue(deleteMessage, Constant.SUBCATEGORYDELETIONUNSUCCESSFUL);
	}
	
	
	
	
}