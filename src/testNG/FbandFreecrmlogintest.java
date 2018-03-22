package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FbandFreecrmlogintest {
	
	WebDriver driver;
	@BeforeMethod
	public void Setup() {
				System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
		
	@Test(priority=1)
	public void Loginfreecrm() {
		driver.get("https://www.freecrm.com");		
		driver.findElement(By.name("username")).sendKeys("swethakan");
		driver.findElement(By.name("password")).sendKeys("freecrm");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
		String Title = driver.getTitle();
		System.out.println("Title of the page is :"+Title);
		
	}
	
	@Test(priority=2)
	public void Login_fb() {
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("swethakandati@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Sanjay-2012");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();	
	
	}
	
	@AfterMethod
	public void CloseBrowser(){	
		
		driver.close();
	}

	
	
	

}
