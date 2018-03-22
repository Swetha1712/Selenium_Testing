package test;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_GetCommands {

	WebDriver driver;
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			Getcommands();
		} catch (Exception e) {
		
			e.printStackTrace();
		}		
				
	}
	
	public void Getcommands() {
		
		try {
			driver.get("http://www.amazon.com");
			
			String Title = driver.getTitle();
			System.out.println("Title of the page is :"+Title);
			
			
			String Url = driver.getCurrentUrl();
			System.out.println("Current url of the page is :"+Url);		
		} catch (Exception e) {
			
			e.printStackTrace();
		}		

	}
	
	
	public static void main(String[] args) {
	
		Test_GetCommands myobj =  new Test_GetCommands();
		
		myobj.invokeBrowser();		
		
	}

}
