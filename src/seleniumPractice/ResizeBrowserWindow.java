package seleniumPractice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResizeBrowserWindow {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
		
		Dimension d = new Dimension(620,620);
		driver.manage().window().setSize(d);
		//driver.manage().window().fullscreen();
	System.out.println(driver.manage().window().getSize());
	
	System.out.println(driver.manage().window().getPosition());
		
	}

}
