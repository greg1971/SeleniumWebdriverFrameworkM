package com.webdriverFrameworkM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
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
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(WebdriverUtilities.TIMOUT_WAITSEC, TimeUnit.SECONDS);
		
		return driver;
	}
}
