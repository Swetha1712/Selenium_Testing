package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorer_test {

	public static void main(String[] args) {

		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Dinesh\\Downloads\\Selenium\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("lst-ib")).sendKeys("test");
		driver.quit();
		
		
	}

}
