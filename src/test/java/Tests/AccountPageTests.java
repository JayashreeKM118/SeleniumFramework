package Tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseTest;
import Utils.AppConstants;

public class AccountPageTests extends BaseTest{
	
	@BeforeClass
	public void accountPageSetUp() {
		accountsPage = loginPage.doLogin(properties.getProperty("userName"), properties.getProperty("passWord"));
	}
	
	
	@Test
	public void AccountPageTitleTest() {
		Assert.assertEquals(accountsPage.AccountPageTitle(), AppConstants.ACCOUNTPAGE_TITLE); 
	}
	
	@Test
	public void isLogoutLinkExits() {
		Assert.assertTrue(accountsPage.isLogoutLinkExists());
	}
	
	
	@Test
	public void isMyAccountslinkExists() {
		Assert.assertTrue(accountsPage.isMyAccountLinkExists());
	}
	
	@Test
	public void getAccountHeaderscountTest() {
		List<String> actHeaders =  accountsPage.AccounHeaderList();
		Assert.assertEquals(actHeaders.size(), 4);
	}
	
	@Test
	public void validatingAccountPageHeadersTextTest() {
		List<String> actHeaders =  accountsPage.AccounHeaderList();
		Assert.assertEquals(actHeaders,AppConstants.EXPECTED_ACCOUNT_HEADERS_LIST);
	}
	
	

}
