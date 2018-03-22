package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreecrmLoginPage_test {
	
	WebDriver driver;
	
	@BeforeMethod
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");		
	}
	
	@Test(priority = 1)
	public void Login() {
		driver.findElement(By.name("username")).sendKeys("swethakan");
		driver.findElement(By.name("password")).sendKeys("freecrm");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
			
	}
	
	@Test(priority =2)
	public void GetTitle() {
		
		String Title = driver.getTitle();
		System.out.println("Title of the page is :"+Title);
	}
	
	@AfterMethod 
	public void CloseBrowser(){		
		driver.close();
	}

}
