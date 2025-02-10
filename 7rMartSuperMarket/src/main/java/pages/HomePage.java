package pages;

import java.util.Locale.Category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[contains(@data-toggle,'dropdown')]")
	private WebElement dashboard;

	public boolean isdashboarddisplayed() {
		return dashboard.isDisplayed();
	}

	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")
	private WebElement adminUserClick;

	@FindBy(xpath = "//a [@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement clickOnManageNews;

	@FindBy(xpath = "(//a[@class='small-box-footer'][8]")
	private WebElement manageProductClick;
	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	private WebElement logoutclick;

	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement clickonlogoutbutton;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]")
	private WebElement categoryclick;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[4]")
	private WebElement subCategoryClick;
	@FindBy(xpath = "//a [@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement manageNewsClick;

	@FindBy(xpath = "//a [@href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	private WebElement categoryListClick;

	public AdminUsersPage adminsUserClick() {
		adminUserClick.click();
		return new AdminUsersPage(driver);

	}

	public ManageNewsPage clickOnManageNews() {
		clickOnManageNews.click();
		return new ManageNewsPage(driver);
	}

	public ManageProductsPage manageProductClick() {
		manageProductClick.click();
		return new ManageProductsPage(driver);
	}

	
	

	public CategoryFileUpload categoryclick() {
		categoryclick.click();
		return new CategoryFileUpload(driver);
	}

	public SubCategoryFileUpload categoryclicks() {
		subCategoryClick.click();
		return new SubCategoryFileUpload(driver);
	}

	public ManageNewsSearch manageNewssearch() {
		manageNewsClick.click();
		return new ManageNewsSearch(driver);

	}

	public CategorySearchList clickOnCategorysearch() {
		categoryListClick.click();
		return new CategorySearchList(driver);
	}
	public HomePage logout() {
		logoutclick.click();
		clickonlogoutbutton.click();
		return this;
	}

	
		
	

}

