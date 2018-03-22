package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_first {

	public static void main(String[] args){

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new 	ChromeDriver();
		
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.name("email")).sendKeys("swethakandati@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Sanjay-2012");
		
		driver.close();
		
		
		
	}

}
