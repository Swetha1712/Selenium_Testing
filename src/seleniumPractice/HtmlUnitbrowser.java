package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HtmlUnitbrowser {

		
	public static void main(String[] args) {		
		
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
			
			//WebDriver driver = new HtmlUnitDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://www.freecrm.com");
			
			System.out.println("Before login Title is : "+driver.getTitle());
			
			driver.findElement(By.name("username")).sendKeys("Swethakan");
			driver.findElement(By.name("password")).sendKeys("freecrm");
			driver.findElement(By.xpath("//input[@type='submit']")).submit();
			
			System.out.println("After login Title is : "+driver.getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
	}

}
