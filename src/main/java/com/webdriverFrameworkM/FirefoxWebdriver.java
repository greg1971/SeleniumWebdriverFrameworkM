package com.webdriverFrameworkM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
/** Class that instantiates and returns a FirefoxDriver object to be used for testing a 
 * web application. 
* @author Gregorio Kavadias
*/
public class FirefoxWebdriver implements SeleniumWebdriver{
	
	private FirefoxDriver driver;
	
	
	/** Implemented method as part of the Factory Design pattern
	 * @return			returns a org.openqa.selenium.firefox.FirefoxDriver.FirefoxDriver() object
	 */
	public FirefoxDriver createWebdriver() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.startup.homepage", "about:blank");
		profile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
		
		driver = new FirefoxDriver(profile);
		driver.manage().timeouts().implicitlyWait(WebdriverUtilities.TIMOUT_WAITSEC, TimeUnit.SECONDS);
		
		return driver;
	}
}
