package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReadDataFromExcel {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("Swethakan");
		driver.findElement(By.name("password")).sendKeys("freecrm");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
		driver.switchTo().frame("mainpanel");
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[contains(text(), 'Companies')][@title = 'Companies']"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(), 'New Company')][@title = 'New Company']")).click();
		driver.findElement(By.id("company_name")).sendKeys("company1");
		Select status = new Select(driver.findElement(By.name("status")));
		status.selectByVisibleText("Active");
		driver.findElement(By.id("service")).sendKeys("Test Description");	
		driver.findElement(By.xpath("//form[@id='companyForm']//tr[1]//input[@value='Save'][@type='submit']")).click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
