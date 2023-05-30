package DriverFactory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private Properties properties;
	private ChromeOptions chromeOptions;
	private FirefoxOptions firefoxOptions;
	private EdgeOptions edgeOptions;
	
	
	public OptionsManager(Properties properties) {
		this.properties = properties;
	}
	
	public ChromeOptions getChromeOptions() {
		chromeOptions = new ChromeOptions();
		if(Boolean.parseBoolean(properties.getProperty("headless")))
			chromeOptions.addArguments("--headless");
		if(Boolean.parseBoolean(properties.getProperty("incognito")))
			chromeOptions.addArguments("--incognito");
		return chromeOptions;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		firefoxOptions = new FirefoxOptions();
		if(Boolean.parseBoolean(properties.getProperty("headless")))
			firefoxOptions.addArguments("--headless");
		if(Boolean.parseBoolean(properties.getProperty("incognito")))
			firefoxOptions.addArguments("--incognito");
		return firefoxOptions;
	}
	
	public EdgeOptions getEdgeOptions() {
		edgeOptions = new EdgeOptions();
		if(Boolean.parseBoolean(properties.getProperty("headless")))
			edgeOptions.addArguments("--headless");
		if(Boolean.parseBoolean(properties.getProperty("incognito")))
			edgeOptions.addArguments("--incognito");
		return edgeOptions;
	}
}
