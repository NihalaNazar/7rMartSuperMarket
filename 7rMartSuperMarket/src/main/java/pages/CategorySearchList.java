package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategorySearchList {
	public WebDriver driver;

	public CategorySearchList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchClick;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement enterCategory;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchButton;

	public CategorySearchList clickOnsearch() {
		searchClick.click();
		return this;
	}

	public CategorySearchList enterCategoryList(String category) {
		enterCategory.sendKeys(category);
		return this;
	}

	public CategorySearchList clickOnSearchButton() {
		searchButton.click();
		return this;
	}

}
