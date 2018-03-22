package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

public class Handlefileuploadpopup {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://files.fm/");

		driver.findElement(By.xpath("//div[@id='file_select_container']//input[2]"))
				.sendKeys("C:\\Users\\Dinesh\\Desktop\\sample.jpg");
		driver.findElement(By.xpath("//div[@id='file_select_container']//input[3]"))
				.sendKeys("C:\\Users\\Dinesh\\Desktop\\sample1.jpg");
		//Trying to do drag and drop a file from local computer to web page
	//	Actions action = new Actions(driver);
	//	action.clickAndHold(driver.findElement(By.id("ddd")))
		//		.moveToElement(driver.findElement(By.xpath("//div[@id='file_select_dragndrop_text']"))).release()
			//	.build().perform();
		
	

		System.out.println(driver.getTitle());

	}

}
