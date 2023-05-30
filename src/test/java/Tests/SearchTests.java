package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseTest;
import DataProviders.ProductDataProvider;

public class SearchTests extends BaseTest{
	
	@BeforeClass
	public void doLogin() {
		accountsPage = loginPage.doLogin(properties.getProperty("userName"), properties.getProperty("passWord"));
	}
	
	
	
	@Test(dataProvider = "getProductSearchKeyData", dataProviderClass = ProductDataProvider.class)
	public void searchProductTest(String searchKey) {
		searchPage = accountsPage.doSearch(searchKey);
		Assert.assertTrue(searchPage.getResultCount()>=1);
	}
	
	@Test
	public void getSearchPageTitle() {
		searchPage = accountsPage.doSearch("macbook");
		Assert.assertEquals(searchPage.getSearchPageTitle("macbook"), "Search - macbook");;
	}
	
	
	
	@Test(dataProvider = "getProductdata", dataProviderClass = ProductDataProvider.class)
	public void selectProductFromSearch(String searchKey, String productName) throws InterruptedException {
		searchPage = accountsPage.doSearch(searchKey);
		productPage = searchPage.selectProduct(productName);
		Assert.assertEquals(productPage.getProductHeaderName(), productName); 
		
	}
	
	
	
	@Test(dataProvider = "getProductImagesTestdata", dataProviderClass = ProductDataProvider.class)
	public void productImagesTest(String searchKey, String productName,int expImagesCount) {
		searchPage = accountsPage.doSearch(searchKey);
		productPage = searchPage.selectProduct(productName);
		Assert.assertTrue(productPage.getProductImagesCount()==expImagesCount); ;
	}
}
