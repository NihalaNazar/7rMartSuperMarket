package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.Wait;

public class SubCategoryFileUpload {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public SubCategoryFileUpload(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Wait wait = new Wait();
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newSubCategoryClick;
	@FindBy(xpath = "//select[@name='cat_id']")
	private WebElement categorydropDown;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement enterCategory;
	@FindBy(xpath = "//input[@name='main_img']")
	private WebElement choosefiles;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement subcategorySearchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement enterSubCategory;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchclick;
	@FindBy(xpath = "//span[@class='badge bg-success']")
	private WebElement activeStatus;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement createsuccess;

	public SubCategoryFileUpload newClick() {
		newSubCategoryClick.click();
		return this;

	}

	public SubCategoryFileUpload subcategoryDropdown() {
	
		pageutility.subCategorySelect(categorydropDown, "554");
		return this;
	}

	public SubCategoryFileUpload enterSubCategory(String name) {
		enterCategory.sendKeys(name);
		return this;
	}

	public SubCategoryFileUpload ChooseImageFile() throws AWTException {

		FileUploadUtility file = new FileUploadUtility();
		file.sendkeysForFileUpload(choosefiles, Constant.IMAGESFILES);
		return this;
	}

	public SubCategoryFileUpload clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public SubCategoryFileUpload clickOnsearchButton() {
		searchButton.click();
		return this;
	}

	public SubCategoryFileUpload searchsubcategoryDropdown() {
		pageutility.subCategorySearch(subcategorySearchButton, "554");
		return this;
	}

	public SubCategoryFileUpload enterSubcategoryOnField(String subcategory) {
		enterSubCategory.sendKeys(subcategory);
		return this;
	}

	public SubCategoryFileUpload clickOnSearchButton() {
		searchclick.click();
		return this;
	}

	public boolean isCreateSuccessMessageDisplayed() {
		return createsuccess.isDisplayed();
	}

	public boolean isactivestatusdisplayed() {
		return activeStatus.isDisplayed();
	}
}