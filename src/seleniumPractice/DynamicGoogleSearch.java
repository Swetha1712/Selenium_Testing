package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicGoogleSearch {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("swetha");

		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class ='sbqs_c']"));
		int s = list.size();
		System.out.println("The total number of suggestions are: " + s);

		for (int i = 0; i < s; i++) {
			String Text = list.get(i).getText();
			System.out.println(Text);
			if (Text.contains("swetha reddy")) {
				list.get(i).click();
				int i1 = i + 1;
				System.out.println("Position of this suggestion is ::" + i1);
				break;
			}
		}

	}

}
