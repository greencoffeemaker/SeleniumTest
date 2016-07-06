package jp.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest02 extends SeleniumTestBase {

	private final long SLEEP_TIME = 5000;

	@Test
	public void test01() throws InterruptedException {

		/*
		 * Seleniumで検索
		 */

		// Google検索（Selenium）
		WebElement element = driver.findElement(By.name("q"));	//Goolgleの検索窓
		element.sendKeys("Selenium");
		Thread.sleep(SLEEP_TIME);
		element.submit();

		//ページタイトル表示（1回目）
		System.out.println("1:Page title is: " + driver.getTitle());

		//タイトルがSeleniumから始まるかチェックする（最大30秒待機。チェックOKの場合、即時終了）
		(new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith("Selenium");
            }
        });

		//ページタイトル表示（2回目）
        System.out.println("2:Page title is: " + driver.getTitle());
		Thread.sleep(SLEEP_TIME);


        /*
         * Micmariで検索
         */
        element.clear();
        element.sendKeys("Micmari");
        WebElement searchButton = driver.findElement(By.name("btnG"));	//Googleの検索ボタン
		Thread.sleep(SLEEP_TIME);
        searchButton.click();

		//タイトルがMicmariから始まるかチェックする（最大30秒待機。チェックOKの場合、即時終了）
		(new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith("Micmari");
            }
        });

		//ページタイトル表示（3回目）
        System.out.println("3:Page title is: " + driver.getTitle());
		Thread.sleep(SLEEP_TIME);


	}
}
