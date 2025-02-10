package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class ManageProductsPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();

	public ManageProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchClick;
	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement title;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement productCode;
	@FindBy(name = "cat_id")
	private WebElement categoryDropDown;
	@FindBy(xpath = "(//select[@class='form-control selectpicker'])[2]")
	private WebElement subcategory;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchClickButton;
	@FindBy(xpath = "//th[text()='Image']")
	private WebElement imageDisplay;

	public ManageProductsPage searchClick() {
		searchClick.click();
		return this;

	}

	public ManageProductsPage enterTitleOnTitleField(String titlename) {
		title.sendKeys(titlename);
		return this;
	}

	public ManageProductsPage enterProductCodeOnField(String code) {
		productCode.sendKeys(code);
		return this;

	}

	public ManageProductsPage selectCategoryDropdown() {

		//Select select = new Select(categoryDropDown);
		//select.selectByIndex(2);
		pageutility.SelectByDrop(categoryDropDown, "2");
		return this;
	}

	public ManageProductsPage selectSubcategoryDropDown() {
		//Select select1 = new Select(subcategory);
		//select1.selectByIndex(2);
		pageutility.subCategorySelect(categoryDropDown, "2");
		return this;
	}

	public ManageProductsPage clickOnSearchButton() {
		searchClickButton.click();
		return this;

	}

	public boolean isImageDisplayed() {
		return imageDisplay.isDisplayed();
	}

}
