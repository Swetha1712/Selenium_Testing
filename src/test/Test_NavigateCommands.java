package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_NavigateCommands {

	WebDriver driver;

	public void invokebrowser() {

		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			navigatecommands();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void navigatecommands() {
		try {
			driver.navigate().to("http://disneyland.com");
			driver.findElement(By.linkText("Sign In or Create Account")).click();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			driver.navigate().forward();
			Thread.sleep(2000);
			driver.navigate().refresh();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Test_NavigateCommands obj = new Test_NavigateCommands();
		obj.invokebrowser();

	}

}
