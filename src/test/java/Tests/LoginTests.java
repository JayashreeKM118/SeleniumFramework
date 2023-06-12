package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Utils.AppConstants;

public class LoginTests extends BaseTest{
	
	@Test
	public void loginPageTitleTet() {
		Assert.assertEquals(loginPage.getLoginPageTitle(), AppConstants.LOGINPAGE_TITLE); 
	}
	
	@Test
	public void forgotPasswordlinkExistsTest() {
		Assert.assertTrue(loginPage.isForgotPasswordPresent());
	}
	
	@Test
	public void loginPageUrltest() {
		Assert.assertTrue(loginPage.getCurrentPageUrl().contains(AppConstants.LOGINPAGE_URL_FRACTION));
	}
	
	@Test(enabled=false)
	public void loginTest() {
		accountsPage = loginPage.doLogin(properties.getProperty("userName"), properties.getProperty("passWord"));
		Assert.assertTrue(accountsPage.isLogoutLinkExists());
	}
	
	
	
}
