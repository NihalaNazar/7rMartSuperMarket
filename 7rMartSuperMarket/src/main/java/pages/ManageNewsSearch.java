package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsSearch {
public WebDriver driver;
public ManageNewsSearch(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement searchclick;
@FindBy(xpath="//input[@name='un']")private WebElement enterNews;
@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")private WebElement searchButton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
private WebElement alertMessagee;

public  ManageNewsSearch clickOnSearch()
{
	searchclick.click();
	return this;
}
public ManageNewsSearch enterNewsOnField(String message) {
	enterNews.sendKeys(message);
	return this;
}
public ManageNewsSearch clickOnSearchButton()
{
	searchButton.click();
	return this;
}
public boolean isAlertMessageDisplayed() {
	// TODO Auto-generated method stub
	return alertMessagee.isDisplayed();
}
}