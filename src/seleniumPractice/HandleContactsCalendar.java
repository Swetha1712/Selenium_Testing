package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleContactsCalendar {

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
		driver.switchTo().frame("mainpanel");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@title ='Contacts']"))).build().perform();
		driver.findElement(By.xpath("//a[@title ='New Contact']")).click();
		driver.findElement(By.id("image_file")).sendKeys("C:\\Users\\Dinesh\\Desktop\\sample.jpg");
		driver.findElement(By.xpath("//img[@title ='Date selector']")).click();
		
		String date = "17/Dec/2017";
		String dateArr[] = date.split("/");
		String day = dateArr[0];
		String mnth = dateArr[1];
		String year = dateArr[2];
		
		String currentyr ="2018";
		
		if(year.equals(currentyr)) {	
			int  j =1;
		while (j==1) {
		driver.findElement(By.xpath("//td[@class='button nav']//div[contains(text(),'«')]")).click();
		String yrheader = driver.findElement(By.xpath("//td[@class='title']")).getText();
		if(currentyr == yrheader)
				j=2;
		}
		
		}
		//td[@class='title'][contains(text(),'December, 2016')]
		//driver.findElement(By.xpath("//td[@class='title'][contains(text(),"+year+")]")).click();
		
	}

}
