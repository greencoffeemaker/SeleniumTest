package jp.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

public class SeleniumTest01 extends TestCase {

	WebDriver driver;

	protected void setUp() throws Exception {
		super.setUp();

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\m44g\\Documents\\eclipse_workspaces\\selenium\\SeleniumTest\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");

	}

	protected void tearDown() throws Exception {

		driver.quit();

        super.tearDown();
	}

	@Test
	public void test01() {

		/*
		 * Seleniumで検索
		 */

		// Google検索（Selenium）
		WebElement element = driver.findElement(By.name("q"));	//Goolgleの検索窓
		element.sendKeys("Selenium");
		element.submit();

		//ページタイトル表示（1回目）
		System.out.println("Page title is: " + driver.getTitle());

		//タイトルがSeleniumから始まるかチェックする（最大30秒待機。チェックOKの場合、即時終了）
		(new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith("Selenium");
            }
        });

		//ページタイトル表示（2回目）
        System.out.println("Page title is: " + driver.getTitle());


        /*
         * Micmariで検索
         */
        element.clear();
        element.sendKeys("Micmari");
        WebElement searchButton = driver.findElement(By.name("btnG"));	//Googleの検索ボタン
        searchButton.click();


		//タイトルがMicmariから始まるかチェックする（最大30秒待機。チェックOKの場合、即時終了）
		(new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith("Micmari");
            }
        });

		//ページタイトル表示（3回目）
        System.out.println("Page title is: " + driver.getTitle());


	}
}
