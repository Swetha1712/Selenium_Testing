package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTesting {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("Swethakan");
		driver.findElement(By.name("password")).sendKeys("freecrm");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
		driver.switchTo().frame("mainpanel");
	}
	
	
	
	@Test
	@Parameters({"comp","status","desc"})
	public void createContacts(String comp, String status, String desc) throws InterruptedException {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[contains(text(), 'Companies')][@title = 'Companies']"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(), 'New Company')][@title = 'New Company']")).click();
		driver.findElement(By.id("company_name")).sendKeys(comp);
		Select status1 = new Select(driver.findElement(By.name("status")));
		status1.selectByVisibleText(status);
		driver.findElement(By.id("service")).sendKeys(desc);
		driver.findElement(By.id("service")).sendKeys(Keys.SEMICOLON);
		
		
		driver.findElement(By.id("service")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		driver.findElement(By.id("service")).sendKeys(Keys.F5);


		driver.findElement(By.id("service")).sendKeys(desc);

		
		//driver.findElement(By.xpath("//form[@id='companyForm']//tr[1]//input[@value='Save'][@type='submit']")).click();
		
	}
	
	
	
	@AfterMethod
	public void teardown() {
		
		//driver.quit();
	}
	
	
	

}
