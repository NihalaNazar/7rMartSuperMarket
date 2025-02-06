package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constant;
import utilities.FileUploadUtility;

public class SubCategoryFileUpload {

	public WebDriver driver;

	public SubCategoryFileUpload(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newClick;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement categoryDropDown;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement subcategory;
	@FindBy(id = "main_img")
	private WebElement imagefile;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;

	public SubCategoryFileUpload ClickOnNewButton() {
		newClick.click();
		return this;

	}

	public SubCategoryFileUpload selectCategoryDropdown() {
		Select select = new Select(categoryDropDown);
		select.selectByIndex(2);
		return this;
	}

	public SubCategoryFileUpload enterSubCategory(String category) {
		subcategory.sendKeys(category);
		return this;
	}

	public SubCategoryFileUpload ChooseImageFile() throws AWTException {
		FileUploadUtility file = new FileUploadUtility();
		//file.robotKeysForFileUpload(imagefile, Constant.IMAGESFILES);
		file.sendkeysForFileUpload(imagefile, Constant.IMAGESFILES);
		return this;
	}

	public SubCategoryFileUpload clickOnSaveButton() {
		saveButton.click();
		return this;
	}

}
