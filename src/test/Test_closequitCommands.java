package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_closequitCommands {
	
	WebDriver driver;
	
	public void invokebrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		closecommands();	
		
	}
	public void closecommands() {
		try {
			driver.navigate().to("http://www.google.com");
			driver.get("http://www.youtube.com");
			Thread.sleep(2000);
			driver.close();
			Thread.sleep(2000);
			//.get("http://www.amazon.com");
			//Thread.sleep(2000);
		//	driver.quit();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
	
		Test_closequitCommands mvar = new Test_closequitCommands();
		mvar.invokebrowser();

	}

}
