package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.AppConstants;
import Utils.ElementUtil;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}
	

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By passWord = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//input[@value='0']");
	private By subscribeNo = By.xpath("//input[@value='1']");
	
	private By privacyCheckbox = By.xpath("//input[@name='agree']");
	private By continueButton = By.xpath("//input[@value='Continue']");
	
	private By UserRegSucMsg = By.xpath("//div/h1");
	
	public Object[][] getRegistrationData() {
		return new Object[][] {
			{"Pushpa","KM","push@gmail.com","9874563211","push@1234"}
		};
	}
	public String doRegister(String fname, String lName, String email, String telephone, String passWord, String subscribe) {
		
		elementUtil.waitForElementVisible(firstName, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doActionsSendKeys(this.firstName, fname);
		elementUtil.doSendKeys(this.lastName, lName);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.passWord, passWord);
		elementUtil.doSendKeys(this.confirmPassword, passWord);
		
		if(subscribe.equals("yes"))
			elementUtil.doClick(subscribeYes);
		else
			elementUtil.doClick(subscribeNo);
		
		elementUtil.doClick(privacyCheckbox, AppConstants.SHORT_DEFAULT_WAIT);
		elementUtil.doClick(continueButton, AppConstants.SHORT_DEFAULT_WAIT);
		
		return elementUtil.getElement(UserRegSucMsg, AppConstants.LONG_DEFAULT_WAIT).getText();
	}
	
}
