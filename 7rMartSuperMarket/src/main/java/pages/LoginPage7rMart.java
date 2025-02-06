package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage7rMart {
	public WebDriver driver;

	public LoginPage7rMart(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	private WebElement usernameField;
	@FindBy(name = "password")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInClick;
	@FindBy(xpath = "//li[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alert;

	public LoginPage7rMart enterUsernameOnField(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public LoginPage7rMart enterPasswordOnField(String password) {
		passwordField.sendKeys(password);
		return this;

	}

	public HomePage clickOnSignInButton() {
		signInClick.click();
		return new HomePage(driver);
	}

	public boolean isDashboardIsLoaded() {
		return dashboard.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}