package seleniumPractice;

import static org.testng.Assert.assertThrows;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.implementation.bytecode.Throw;

public class HandleCalender {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("swethakan");
		driver.findElement(By.name("password")).sendKeys("freecrm");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();

		String Date = "14-May-2015";
		String DateArr[] = Date.split("-");
		String day = DateArr[0];
		String mnth = DateArr[1];
		String year = DateArr[2];

		driver.switchTo().frame("mainpanel");
		try {
			Select s2 = new Select(driver.findElement(By.name("slctYear")));
			s2.selectByVisibleText(year);
		} catch (NoSuchElementException e1) {
			System.out.println("Please enter correct year");

		
		}
		
		try {
			Select s1 = new Select(driver.findElement(By.name("slctMonth")));
			s1.selectByVisibleText(mnth);
		} catch (NoSuchElementException e2) {
			System.out.println("Please enter correct month");
		}
		

		try {
			driver.findElement(By.xpath("//td[@class='calendarcell'][text()="+ day+"]")).click();

		} catch (NoSuchElementException e) {
			System.out.println("Please enter correct date");
		}
		

	}

}
