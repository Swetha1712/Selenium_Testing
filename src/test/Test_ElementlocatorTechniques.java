package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_ElementlocatorTechniques {

	WebDriver driver;
	
	public void invokebrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	public void elementlocators() {
		
		try {
			//driver.get("http://amazon.com");
			//invokebrowser("http://www.google.com");
			//driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("Swetha");
			
			//invokebrowser("http://www.amazon.com");
			//driver.findElement(By.xpath("//a[@id='nav-link-prime']//span[@class='nav-line-2']")).click();
			
			invokebrowser("http://www.southwest.com");
			driver.findElement(By.id("swa-header-link--plan-a-trip")).click();
			driver.findElement(By.linkText("Book a Flight")).click();
			driver.findElement(By.id("oneWay")).click();
			driver.findElement(By.id("originAirport_displayed")).sendKeys("lga");
		//	driver.findElement(By.xpath("//div[@id='departureBookingSelects']//div[@class='date-selection--container-left']//img[@class='ui-datepicker-trigger']")).click();
			
			//driver.findElement(arg0)
			Thread.sleep(5000);
			driver.findElement(By.id("outboundTimeOfDay")).click();
			
			//driver.findElement(By.xpath("//a[@id='nav-link-prime']//span[@class='nav-line-2']")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Test_ElementlocatorTechniques obj = new Test_ElementlocatorTechniques();
		obj.elementlocators();
		
	}

}
