package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowsertesting {
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void setup(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			}else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Dinesh\\Downloads\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
				driver = new FirefoxDriver();				
			}else if(browser.equals("ie")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\Dinesh\\Downloads\\Selenium\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.google.com");	
		String s = driver.getTitle();
		System.out.println(s);
		
	}
	
	
		
	@AfterMethod()
	public void teardown() {
		driver.quit();

	}
	
	

		
		
	
	

}
