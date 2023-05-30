package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import POJO.Product;

public class SearchTests_Data extends BaseTest{
	
	@BeforeClass
	public void searchSetUp() {
		accountsPage = loginPage.doLogin(properties.getProperty("userName"), properties.getProperty("passWord"));
	}
	
	@DataProvider(name = "productData")
	public Object[][] getProductData() {
		return new Object[][] {
			{new Product("Macbook","MacBook Pro",4)},
			{new Product("Samsung","Samsung SyncMaster 941BW",1)}
		};
	}
	
	@Test(dataProvider = "productData")
	public void searchProductTest(Product product) {
		searchPage = accountsPage.doSearch(product.getSearchKey());
		Assert.assertTrue(searchPage.getResultCount()>=1);
	}
	
	@Test
	public void getSearchPageTitle() {
		searchPage = accountsPage.doSearch("macbook");
		Assert.assertEquals(searchPage.getSearchPageTitle("macbook"), "Search - macbook");;
	}
	
	
	
	@Test(dataProvider = "productData")
	public void selectProductFromSearch(Product product) throws InterruptedException {
		searchPage = accountsPage.doSearch(product.getSearchKey());
		productPage = searchPage.selectProduct(product.getProductName());
		Assert.assertEquals(productPage.getProductHeaderName(), product.getProductName()); 	
	}
	
	@Test(dataProvider = "productData")
	public void productImagesTest(Product product) {
		searchPage = accountsPage.doSearch(product.getSearchKey());
		productPage = searchPage.selectProduct(product.getProductName());
		Assert.assertTrue(productPage.getProductImagesCount()==product.getProductImages()); ;
	}
}
