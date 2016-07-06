package jp.selenium;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jp.seleniumtest.SeleniumResource;
import junit.framework.TestCase;

public class SeleniumTestBase extends TestCase {

	WebDriver driver;
	ResourceBundle resource;

	protected void setUp() throws Exception {
		super.setUp();

		String projectDir = System.getProperty("user.dir");
		resource = SeleniumResource.getInsetance();

		System.setProperty(resource.getString("selenium.webdriver"), projectDir + resource.getString("selenium.webdriver.path"));
		driver = new ChromeDriver();
		driver.get(resource.getString("selenium.testsite.url"));
	}

	protected void tearDown() throws Exception {
		driver.quit();
		super.tearDown();
	}

}
