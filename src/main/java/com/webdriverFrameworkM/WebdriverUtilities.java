package com.webdriverFrameworkM;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/** This utility class serves for some supporting actions when using Selenium Webdriver API
 * for testing Web Applications.
 * Some of the offer functionalities are:
 * <ul>
 * <li> enum for the supported browsers
 * <li> Constants such as the timeout period in seconds
 * <li> Reading the Base URL from the config.properties file
 * <li> Retrieving the Base URL
 * <li> Checking whether an element exists on a page or not
 * <li> Writing a message to a file 
 * </ul>
*
* @author Gregorio Kavadias
*/
public class WebdriverUtilities {

	public enum Browser {
		FIREFOX, INTERNETEXPLORER
	}
	/** BASEURL is where the browser will initially navigate to. Later on, will be accessed
	 * from the config.properties file */
	private static String BASEURL;
	/** Timeout period for the webdriver in seconds. It is used when creating the
	 * webdriver */
	public static final long TIMOUT_WAITSEC = 30;

	/** Getter ofthe BASEURL, where the browser should initially navigate to
	 * 
	 * @return			Returns the string pertaining to the BASEURL constant, where the browser should initially navigate to
	 */
	public static String getBASEURL() {
		return BASEURL;
	}
	
	/** Reads the application home_page property from the config.properties file,
	 * by using the IO API.
	 * The property found is stored to the <b>BASEURL</b> constant.
	 */
	public static void setBASEURL() {

		try {
			File file = new File("config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			BASEURL = properties.getProperty("home_page");
			System.out.println("BASEURL has been set and is:"+BASEURL);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** Overloaded method, worls like a setter, in case that the user needs to
	 * define himself the <b>BASEURL</b>, instead of having it set from the properites file.
	 */
	public static void setBASEURL(String url) {

		BASEURL=url;
	}
	
	/** Checks whether or not an element is present on a web page. 
	 * The check is done based on a given xpath expression
	 * @author Gregorio Kavadias
	 * @param driver			The webdriver, which has already been instantiated, via the Factory pattern
	 * @param xpathExpression	The xpath expression, locating the element, the existence of which is verified
	 * @return			True / False
	 */
	public static boolean IsTestElementPresent(WebDriver driver, String xpathExpression)
	{
	try
	{
	driver.findElement(By.xpath(xpathExpression));
	return true;
	}
	catch (NoSuchElementException e)
	{
		
	return false;
	}
	
	}

	/**
	 * Saves in the given filename all errors that may have been found in the
	 * unit test 
	 * @param msg		A string including all error messages (concatenated), which should be saved into a file
	 * in order to be accessed at the end of a test.
	 * @param filename	Absolute filename where the msg should be written to
	 * 
	 */
	public static void writeMsgToFile(String msg, String filename) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filename), "UTF8"));
			String outText = msg;
			out.write(outText);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
