# SeleniumWebdriverFramework
Framework for start writing Junit Test Cases making use of the Java Webdriver API

The Framework consists of the following:
* A Factory pattern for instantiating Webdriver objects, for creating Webdriver objects without exposing the creation logic to the client and refer to newly created object using a common interface. For more info you may refer to http://www.tutorialspoint.com/design_pattern/factory_pattern.htm
* A Utility class providing:
<ul>
<li> enum for the supported browsers
<li> Constants such as the timeout period in seconds
<li> Reading the Base URL from the config.properties file
<li> Retrieving the Base URL
<li> Checking whether an element exists on a page or not
<li> A mechanism for flushing a message to a file 
</ul>
* A Junit Test Suite, which should include any new Test Cases
* A Test case, which demonstrates how the framework should be used: it instantiates a webdriver, accesses an initial URL and from that moment on, the logic of the test case can be further developed.



##Installation Instructions
1. Create a folder: C:/software/selenium
2. Copy there the "IEDriverServer.exe" that can be found in "resources" folder
3. Set in the "config.properties" file, the URL to be tested
