package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Rightclick {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		Actions a = new Actions(driver);
		a.contextClick(driver.findElement(By.xpath("//span[contains(text(),'right click me')]"))).build().perform();
		
		driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-delete']")).click();
		
	Alert alrt = driver.switchTo().alert();
	alrt.accept();
	driver.quit();
		
	}

}
