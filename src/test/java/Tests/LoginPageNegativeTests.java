package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;

public class LoginPageNegativeTests extends BaseTest{
	
	@DataProvider
	public Object[][] IncorrectLoginTestdata() {
		return new Object[][] {
			{"Amma5","amma"},
			{"Amma6","amma1"},
			{"",""}
		};
	}
	
	@Test(dataProvider = "IncorrectLoginTestdata")
	public void IncorrectLoginTest(String uname, String pwd) {
		Assert.assertTrue(loginPage.IncorrectLogin(uname,pwd));
	}

}
