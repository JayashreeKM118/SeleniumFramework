package Tests;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseTest;

public class ProductTests extends BaseTest{

	@BeforeClass
	public void ProductPageSetUp() {
		accountsPage = loginPage.doLogin(properties.getProperty("userName"), properties.getProperty("passWord"));
	}
	
	@Test
	public void ProductInfoTest() {
		searchPage = accountsPage.doSearch("macbook");
		productPage = searchPage.selectProduct("MacBook");
		Map<String, String> productInfo = productPage.getProductInfoMap();
		System.out.println(productInfo);
		
		softAssert.assertEquals(productInfo.get("Brand"), "Apple");
		softAssert.assertEquals(productInfo.get("Availability"), "In Stock");
		softAssert.assertEquals(productInfo.get("Product Code"), "Product 16");
		softAssert.assertEquals(productInfo.get("Reward Points"), "600");
		softAssert.assertEquals(productInfo.get("productPrice"), "$602.00");
		softAssert.assertEquals(productInfo.get("productTaxPrice"), "$500.00");
		softAssert.assertEquals(productInfo.get("produuctName"), "MacBook");
		 
	}
	
	@Test
	public void AddToCartTest() {
		searchPage = accountsPage.doSearch("macbook");
		productPage = searchPage.selectProduct("MacBook");
		String msg = productPage.addToCart();
		softAssert.assertTrue(msg.contains("Success: You have added"));
		softAssert.assertTrue(msg.contains("MacBook"));
	}
}
