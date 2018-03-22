package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Findelementsconcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
//Getting the total number of links in the web page
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		int nooflinks = linklist.size();
		System.out.println(nooflinks);
//Printing the text of all links available in the web page
		for (int i = 0; i < nooflinks; i++) {
			String nameofthelinktext = linklist.get(i).getText();
			System.out.println(nameofthelinktext);

		}

	}

}
