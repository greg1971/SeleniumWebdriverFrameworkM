package com.webdriverFrameworkM;

import org.openqa.selenium.*;

/**
 * Interface which is a part of the Factory pattern for creating a webdriver per
 * browser type, e.g. for Firefox, Internet Explorer, Google chrome etc. For
 * More details on the Factory design pattern you may refer here:
 * http://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 *  @author Gregorio Kavadias
 */
public interface SeleniumWebdriver {

	/** Method, which is overridden by the subclasses, which implement the Factory pattern
	 * <br> 
	 * There should exist a createWebdriver() method per supported browser
	 * @return			An org.openqa.selenium.WebDriver object
	 */
	public WebDriver createWebdriver();
}
