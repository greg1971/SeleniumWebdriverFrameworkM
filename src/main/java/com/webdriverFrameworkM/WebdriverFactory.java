package com.webdriverFrameworkM;

import org.openqa.selenium.WebDriver;

import com.webdriverFrameworkM.WebdriverUtilities.Browser;

/**
 * This class implements an important part of the Factory pattern, for creating
 * Webdriver objects without exposing the creation logic to the client and refer
 * to newly created object using a common interface.
 * http://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 * 
 * @author Gregorio Kavadias
 */
public class WebdriverFactory {

	/** The method creates a org.openqa.selenium.WebDriver object, which might be a 
	 * org.openqa.selenium.firefox.FirefoxDriver, or a org.openqa.selenium.ie.InternetExplorerDriver.InternetExplorerDriver() depending on the
	 * enum variable passed to the method
	 * 
	 * @param b			enum (webdriverFramework.WebdriverUtilities.Browser) which can take the values:
	 * <ul>
	 * <li>FIREFOX
	 * <li>INTERNETEXPLORER
	 * <li>etc
	 * </ul>
	 * @return			A org.openqa.selenium.WebDriver
	 */
	public static WebDriver createWebDriver(Browser b) {
		switch (b) {
		case FIREFOX:
			return new FirefoxWebdriver().createWebdriver();
			
		case INTERNETEXPLORER:
			return new InternetExplorerWebdriver().createWebdriver();

		default:
			return new FirefoxWebdriver().createWebdriver();
		}

	}
}
