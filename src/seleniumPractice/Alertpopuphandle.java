package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertpopuphandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		// Click on Go button without entering Username and password
		driver.findElement(By.name("proceed")).click();
		Alert alrt = driver.switchTo().alert();
		Thread.sleep(4000);
		String s = alrt.getText();
		System.out.println(s);
		// alrt.accept();
		alrt.dismiss();
	}

}
