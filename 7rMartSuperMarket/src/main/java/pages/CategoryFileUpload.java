package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import constants.Constant;
import utilities.FileUploadUtility;

public class CategoryFileUpload {
	public WebDriver driver;

	public CategoryFileUpload(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clickNew;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement enterCategoryName;
	@FindBy(xpath = "//[@id='main_img']")
	private WebElement uploadImageFile;
	@FindBy(xpath = "//input[@name='top_menu'][1]")
	private WebElement showOnTopMenu;
	@FindBy(xpath = "//input[@name='show_home'][1]")
	private WebElement showOnLeftMenu;
	@FindBy(xpath = "//button[@class='btn btn=danger']")
	private WebElement saveButton;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	private WebElement deleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteSuccess;

	public CategoryFileUpload ListNewCategory() {
		clickNew.click();
		return this;
	}

	public CategoryFileUpload EnterTheCategory(String category) {
		enterCategoryName.sendKeys(category);
		return this;
	}

	public CategoryFileUpload uploadImageFile() throws AWTException {
		FileUploadUtility file = new FileUploadUtility();
		file.robotKeysForFileUpload(uploadImageFile, Constant.IMAGEFILE);
		return this;
	}

	public CategoryFileUpload selectshowOnLeftMenu() {
		showOnLeftMenu.click();
		return this;

	}

	public CategoryFileUpload clickSave() {
		saveButton.click();
		return this;
	}

	public CategoryFileUpload selectshowOnTopMenu() {

		showOnTopMenu.click();
		return this;
	}

	public CategoryFileUpload clickOnDeleteButton() {
		
		deleteButton.click();
		return this;
	}

	public boolean isDeleteSuccessfulMessageDisplayed() {
	
		return deleteSuccess.isDisplayed();
	
}

	
	
	}


