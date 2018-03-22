package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Edureka_main {
	
	
	WebDriver driver;
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://google.com");
			
			//String s= driver.getCurrentUrl();
			String s= driver.getTitle();
			System.out.println(s);
			driver.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	public void searchgoogle() {
		
		//driver.findElement(By.name=)
		
	}
	


	public static void main(String[] args) {
		
		Edureka_main myobj = new Edureka_main();
		myobj.invokeBrowser();
		
	

	}


}
