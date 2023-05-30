package Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import DriverFactory.DriverFactory;
import Pages.AccountsPage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.RegistrationPage;
import Pages.SearchPage;

public class BaseTest {
	
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountsPage accountsPage;
	protected SearchPage searchPage;
	protected ProductPage productPage;
	protected RegistrationPage registrationPage;
	
	protected DriverFactory driverFactory;
	protected Properties properties;
	
	protected SoftAssert softAssert;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browser) {
		
		driverFactory = new DriverFactory();
		properties = driverFactory.initProp();
		
		if(browser!=null)
			properties.setProperty("browserName", browser);
		
		driver = driverFactory.initDriver(properties);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
