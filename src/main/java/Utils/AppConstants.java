package Utils;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	public static final String LOGINPAGE_TITLE ="Account Login";
	public static final String LOGINPAGE_URL_FRACTION="naveenautomationlabs";
	public static final String ACCOUNTPAGE_TITLE="My Account";
	
	public static final int SHORT_DEFAULT_WAIT=5;
	public static final int MEDIUM_DEFAULT_WAIT=10;
	public static final int LONG_DEFAULT_WAIT=30;
	
	public static final List<String> EXPECTED_ACCOUNT_HEADERS_LIST =  Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
	
	public static final String REGISTARTION_SUC_MSG = "Your Account Has Been Created!";
	
	public static final String LOGIN_ERROR_MSG="Warning: No match for E-Mail Address and/or Password.";
	public static final String REGISTER_SHEET_NAME = "register";
}
