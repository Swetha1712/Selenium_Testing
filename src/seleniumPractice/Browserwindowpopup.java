package seleniumPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browserwindowpopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Good PopUp #1")).click();
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it1 = handler.iterator();
		
		String parentwindowid = it1.next();
		System.out.println(parentwindowid);
		
		String childwindowid = it1.next();
		System.out.println(childwindowid);
		
		driver.switchTo().window(childwindowid);
		
		Thread.sleep(3000);
		
		String s = driver.getTitle();
		System.out.println("Child window pop up title is ::"+s );
		Thread.sleep(2000);
		
		driver.close();
		driver.switchTo().window(parentwindowid);
		
		driver.findElement(By.linkText("Good PopUp #2")).click();
		
	//	driver.quit();
			
	}

}
