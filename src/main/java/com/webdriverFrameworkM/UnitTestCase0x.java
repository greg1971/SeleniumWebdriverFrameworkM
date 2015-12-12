package com.webdriverFrameworkM;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** From this point on, the junit test starts its execution. 
* <br> 
* In case you need to create a new test, just start filling in the code, which exists under Test annotation, after choosing the browser you need to test with.
* <br>
* Finally, do not forget to add this test case to the test suite existing in the current package <b>(UnitTestSuite.java)</b>
*
* @author Gregorio Kavadias
* 
*/
public class UnitTestCase0x {
	/** StringBuffer field for aggregating the verification errors found throughout
	 * the unit test.*/
	private StringBuffer verificationErrors = new StringBuffer();
	/** org.openqa.selenium.WebDriver field, that is created through the Factory pattern, 
	 * hence it might be an InternetExplorer driver, Firefox driver etc.  */
	private WebDriver mydriver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
		
		/**
		 * Any potential errors are logged into a file
		 */
		String verificationErrorString = verificationErrors.toString();
		WebdriverUtilities.writeMsgToFile(verificationErrorString,
				"C:\\temp\\"+this.getClass().getName());
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void test() throws InterruptedException {
		try {
			/* an enum value is passed to WebdriverUtilities, corresponding to the supported
			 * browsers 
			 */
			
			mydriver = WebdriverFactory
					.createWebDriver(WebdriverUtilities.Browser.FIREFOX);
			try 
			{
			WebdriverUtilities.setBASEURL();
			mydriver.get(WebdriverUtilities.getBASEURL());
			Thread.sleep(3000);
			}
			catch (FileNotFoundException fe)
			{
			verificationErrors.append(fe.toString());
			}			
			
			mydriver.quit();
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	@Test
	/* Displays how you can locate an item by ID*/
	public void testFindElementByID() throws InterruptedException {
		
		try {
			/* an enum value is passed to WebdriverUtilities, corresponding to the supported
			 * browsers 
			 */
			
			mydriver = WebdriverFactory
					.createWebDriver(WebdriverUtilities.Browser.FIREFOX);
			try 
			{
			WebdriverUtilities.setBASEURL();
			mydriver.get(WebdriverUtilities.getBASEURL());
			mydriver.findElement(By.id("lst-ib")).sendKeys("Boca Juniors");
			mydriver.findElement(By.id("lst-ib")).click();
			Thread.sleep(3000);
			}
			catch (FileNotFoundException fe)
			{
			verificationErrors.append(fe.toString());
			}			
			
			mydriver.quit();
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
	
	}
}


