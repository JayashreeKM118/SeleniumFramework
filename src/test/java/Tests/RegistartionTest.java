package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Utils.AppConstants;
import Utils.ExcelUtil;

public class RegistartionTest extends BaseTest{

	@BeforeClass
	public void regsetUp() {
		registrationPage = loginPage.navigateToRegisterPage();
	}
	
	public String getRandomEmailID() {
		return "testautomation"+System.currentTimeMillis()+"@gmail.com";	
	}
	
//	@DataProvider
//	public Object[][] getUserRegisterData() {
//		return new Object[][] {
//			{"poori","km","7417412323","abcd@123","no"}
//		};
//	}
	
	@DataProvider(name = "regExceldata")
	public Object[][] getUserDataFromExcel() {
		Object[][] data = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return data;
	}
	
	@Test(dataProvider = "regExceldata")
	public void userRegistration(String fname, String lname, String telephoneNum, String Password, String subscribe) {
		Assert.assertEquals(registrationPage.doRegister(fname, lname, getRandomEmailID(), telephoneNum, Password, subscribe), 
				AppConstants.REGISTARTION_SUC_MSG); 
	}
}
