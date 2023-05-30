package DriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Exceptions.FrameWorkException;

public class DriverFactory {
	WebDriver driver ;
	OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> threadLocalDriver= new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(Properties properties) {
		
		optionsManager = new OptionsManager(properties);
		String browsername = properties.getProperty("browserName");
		
		switch (browsername.toLowerCase()) {
		case "chrome":
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			threadLocalDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;
		case "firefox":
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			threadLocalDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;
		case "edge":
			//driver = new EdgeDriver(optionsManager.getEdgeOptions());
			threadLocalDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			break;
		case "safari":
			//driver = new SafariDriver();
			threadLocalDriver.set(new SafariDriver());
			break;	
		default: System.out.println("Please pass the correct browser name");
			throw new FrameWorkException("Invalid browser name pased.........");
			
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(properties.getProperty("url"));
		
		return getDriver();
		
	}
	
	
	public synchronized static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	public Properties initProp() {
		
		Properties prop = new Properties();
		FileInputStream fileInputStream = null;
		String envName = System.getProperty("env");
		System.out.println("Running on Environment : "+envName);
		try {
	
		if(envName==null) {
			fileInputStream = new FileInputStream("./src/main/resources/config/config.properties");
		}
		else {
			switch(envName.toLowerCase().trim())
			{
			case "qa":
				fileInputStream = new FileInputStream("./src/main/resources/config/config.properties");
				break;
			
			case "uat":
				fileInputStream = new FileInputStream("./src/main/resources/config/UAT_config.properties");
				break;
				
				default:
					throw new FrameWorkException("Inavlid Env name passed");
					
			}
			}
		}	
		
	
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static String getScreenshot() {
		
		File srcfile =  ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File desFile = new File(path);
		
		try {
			FileUtils.copyFile(srcfile, desFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
