package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firefox_facebook {

	public static void main(String[] args) {

		// System.setProperty("webdriver.firefox.driver",
		// "C:\\Users\\Dinesh\\Downloads\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		// WebDriver driver = new FirefoxDriver();
		// driver.get("https://google.com");

		WebDriver driver;

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://facebook.com");
		

	}

}
