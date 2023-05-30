package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.ElementUtil;

public class SearchPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By results = By.xpath("//div[@class='product-thumb']");
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	
	public String getSearchPageTitle(String searchTerm) {
		return elementUtil.waitForTitleIsAndCapture(searchTerm, 5);
	}
	
	public int getResultCount() {
		List<WebElement> items = elementUtil.waitForElementsPresence(results, 5);
		int count = items.size();
		return count;
	}
	
	public ProductPage selectProduct(String productName) {
		By prodcut = By.linkText(productName);
		elementUtil.clickElementWhenReady(prodcut, 5);
		return new ProductPage(driver);
	}
}
