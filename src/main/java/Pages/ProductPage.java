package Pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.AppConstants;
import Utils.ElementUtil;

public class ProductPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	private By header = By.xpath("//div/h1");
	private By productImages = By.xpath("//li/a/img");
	private By productDetails = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By pricingInformation = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	private By quantity = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");
	private By successAlertMsg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	private Map<String, String> productInfoMap;
	
	
	
	public String getProductHeaderName() {
		return elementUtil.doGetElementText(header);
	}
	
	public int getProductImagesCount() {
		return elementUtil.waitForElementsVisible(productImages, AppConstants.MEDIUM_DEFAULT_WAIT).size();
	}
	
	private void getProductDetails() {
		productInfoMap = new LinkedHashMap<>();
		List<WebElement> details = elementUtil.getElements(productDetails);
		for(WebElement s: details) {
			String item = s.getText();
			String[] itemInfo = item.split(":");
			productInfoMap.put(itemInfo[0].trim(), itemInfo[1].trim());
		}
	}
	
	private void getPricingDetails() {
		List<WebElement> pricingDetail = elementUtil.getElements(pricingInformation);
		String actPrice  = pricingDetail.get(0).getText();
		String extraPriceValue = pricingDetail.get(1).getText().split(":")[1].trim();
		productInfoMap.put("productPrice", actPrice);
		productInfoMap.put("productTaxPrice", extraPriceValue);
	}
	
	public Map<String, String> getProductInfoMap() {
		getProductDetails();
		getPricingDetails();
		productInfoMap.put("produuctName", getProductHeaderName());
		return productInfoMap;
	}
	
	public String addToCart() {
		elementUtil.doSendKeys(quantity, "2");
		elementUtil.doClick(addToCartBtn, AppConstants.SHORT_DEFAULT_WAIT);
		elementUtil.getElement(successAlertMsg, AppConstants.MEDIUM_DEFAULT_WAIT);
		return elementUtil.doGetElementText(successAlertMsg);
	}
}
