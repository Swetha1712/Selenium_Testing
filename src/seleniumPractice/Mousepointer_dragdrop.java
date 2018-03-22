package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mousepointer_dragdrop {

	WebDriver driver;
	
	Actions action;
	
	public void invokebrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	
		driver.get("http://amazon.com");
		
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-shopall']//span[@class='nav-line-2']"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//span[@class=\"nav-text\"][contains(text(),'Books & Audible')]"))).build().perform();
		
		driver.findElement(By.xpath("//span[@class='nav-text'][contains(text(),'Children's Books')]")).click();
		
		
		
		
	}
	
	
	public static void main(String[] args) {
	
	Mousepointer_dragdrop myobj = new Mousepointer_dragdrop();
	myobj.invokebrowser();
		
		

	}

}
