package jp.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\m44g\\Documents\\eclipse_workspaces\\selenium\\SeleniumTest\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Micmari");

		element.submit();

		System.out.println("Page title is: " + driver.getTitle());

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith("Micmari");
            }
        });

        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
	}

}
