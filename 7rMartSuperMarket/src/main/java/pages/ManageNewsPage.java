package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
		public WebDriver driver;

		public ManageNewsPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
		private WebElement newClick;
		@FindBy(xpath = "//textarea[@id='news']")
		private WebElement enterNews;
		@FindBy(xpath = "//button[@class='btn btn-danger']")
		private WebElement saveButton;
		@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
		private WebElement alertMessagee;

		public ManageNewsPage ClickOnNewButton() {
			newClick.click();
			return this;

		}

		public ManageNewsPage enterNewsOnField(String message) {
			enterNews.sendKeys(message);
			return this;
		}

		public ManageNewsPage clickOnSaveButton() {
			saveButton.click();
			return this;

		}

		public boolean isAlertMessageDisplayed() {
			return alertMessagee.isDisplayed();

		}

	}

