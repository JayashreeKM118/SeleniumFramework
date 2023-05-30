package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.AppConstants;
import Utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}
	
	By MyAccountLink = By.linkText("My Account");
	By LogOutLink = By.linkText("Logout");
	By headers = By.xpath("//h2");
	By searchField = By.xpath("//input[@name='search']");
	By searchIcon = By.className("fa-search");
	
	public String AccountPageTitle() {
		return elementUtil.waitForFullTitleAndCapture(AppConstants.ACCOUNTPAGE_TITLE, AppConstants.SHORT_DEFAULT_WAIT);
	}
	
	public Boolean isMyAccountLinkExists() {
		return elementUtil.checkElementIsDisplayed(MyAccountLink);
	}
	
	public Boolean isLogoutLinkExists() {
		return elementUtil.checkElementIsDisplayed(LogOutLink);
	}
	
	public List<String> AccounHeaderList() {
		List<WebElement> list = elementUtil.waitForElementsVisible(headers, AppConstants.MEDIUM_DEFAULT_WAIT);
		List<String> textList = new ArrayList<>();
		for(WebElement e: list) {
			textList.add(e.getText());
		}
		return textList;
	}
	
	public SearchPage doSearch(String searchText) {
		elementUtil.doSendKeys(searchField, searchText);
		elementUtil.doClick(searchIcon);
		return new SearchPage(driver);
	}
}
