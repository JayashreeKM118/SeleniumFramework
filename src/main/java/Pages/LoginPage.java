package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.AppConstants;
import Utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}
	
	private By userName = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@class='btn btn-primary']");
	private By forgotPassword = By.linkText("Forgotten Password");
	private By footerLinks = By.xpath("//footer//a");
	private By registerLink = By.linkText("Register");
	
	
	private By loginErrormsg  = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	
	public String getLoginPageTitle() {
		
		return elementUtil.waitForTitleIsAndCapture(AppConstants.LOGINPAGE_TITLE, AppConstants.SHORT_DEFAULT_WAIT); 
	}
	
	public String getCurrentPageUrl() {
		return elementUtil.waitForURLContainsAndCapture("route=account/login", AppConstants.SHORT_DEFAULT_WAIT);
	}
	
	public boolean isForgotPasswordPresent() {
		return elementUtil.checkElementIsDisplayed(forgotPassword);
	}
	
	public List<String> getFooterLinks() {
		List<WebElement> list = elementUtil.waitForElementsVisible(footerLinks, AppConstants.MEDIUM_DEFAULT_WAIT);
		List<String> textList = new ArrayList<>();
		
		//driver.findElements(footerLinks).forEach(e->textList.add(e.getText()));
		
		for(WebElement e: list)
			textList.add(e.getText());
		return textList;
	}
	
	public AccountsPage doLogin(String usname,String pwd) {
		
		elementUtil.waitForElementPresence(userName, AppConstants.SHORT_DEFAULT_WAIT).sendKeys(usname);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		return new AccountsPage(driver);
	}
	
	public boolean IncorrectLogin(String usname,String pwd) {
		
		elementUtil.waitForElementPresence(userName, AppConstants.SHORT_DEFAULT_WAIT).sendKeys(usname);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		String msg = elementUtil.doGetElementText(loginErrormsg);
		System.out.println(msg);
	if(msg.contains(AppConstants.LOGIN_ERROR_MSG))
		return true;
	else
		return false;
	}
	
	public RegistrationPage navigateToRegisterPage() {
		  elementUtil.doClick(registerLink, AppConstants.SHORT_DEFAULT_WAIT);
		 return new RegistrationPage(driver);
	}
}
