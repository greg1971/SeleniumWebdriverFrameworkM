package com.webdriverFrameworkM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ie.InternetExplorerDriver;

/** Class that instantiates and returns a InternetExplorerDriver object to be used for testing a 
 * web application. 
* @author Gregorio Kavadias
*/
public class InternetExplorerWebdriver implements SeleniumWebdriver {

	private InternetExplorerDriver driver;
	

	/** Implemented method as part of the Factory Design pattern
	 * @return			returns an org.openqa.selenium.ie.InternetExplorerDriver object
	 */
	public InternetExplorerDriver createWebdriver() {
		
		System.setProperty("webdriver.ie.driver", "C:\\Software\\selenium\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(WebdriverUtilities.TIMOUT_WAITSEC, TimeUnit.SECONDS);
		return driver;
	}
		
}
