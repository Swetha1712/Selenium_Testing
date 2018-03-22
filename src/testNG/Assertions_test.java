package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions_test {
		
WebDriver driver;
	
	@BeforeSuite
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
	
	@BeforeClass
	public void Login() {
		driver.findElement(By.name("username")).sendKeys("swethakan");
		driver.findElement(By.name("password")).sendKeys("freecrm");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
			
	}
	
	@Test
	public void GetTitle() {
		
		String Title = driver.getTitle();
		System.out.println("Title of the page is :"+Title);
		Assert.assertEquals(Title, "CRMPRO","Title is not matched");
	}
	
	@Test
	public void Contacts_click() {
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();
		
	}
	@Test
	public void Email_display() {
		driver.switchTo().frame("mainpanel");
		boolean b = driver.findElement(By.xpath("//a[@title='Email']")).isDisplayed();
		Assert.assertTrue(b, "Email is not displayed");

		
	}
	
	
	@AfterSuite
	public void CloseBrowser(){		
		driver.close();
	}
	
	

}
