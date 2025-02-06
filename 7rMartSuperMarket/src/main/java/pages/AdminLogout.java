package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLogout {
	public WebDriver driver;

	public AdminLogout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	private WebElement logoutclick;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement clickonlogoutbutton;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")
	private WebElement adminUserClick;

	public AdminUsersPage adminsUserClick() {
		adminUserClick.click();
		return new AdminUsersPage(driver);

	}

	public AdminLogout logout() {
		logoutclick.click();
		clickonlogoutbutton.click();
		return this;

	}

}
