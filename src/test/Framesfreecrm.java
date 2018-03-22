package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Framesfreecrm {

	WebDriver driver;

	public void invokebrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");

		// action = new Actions(driver);
		loginfreecrm();
	}

	public void loginfreecrm() {

		driver.findElement(By.name("username")).sendKeys("Swethakan");
		driver.findElement(By.name("password")).sendKeys("freecrm");
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		driver.switchTo().frame("mainpanel");
		// Mousemovements
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("DEALS"))).build().perform();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//input[@value='New Product']")).click();
		driver.findElement(By.id("name")).sendKeys("Groceries1");
		driver.findElement(By.id("cost")).sendKeys("23");
		driver.findElement(By.xpath("//input[@value='Save']")).click();

	}

	public static void main(String[] args) {

		Framesfreecrm myobj = new Framesfreecrm();
		myobj.invokebrowser();

	}

}
