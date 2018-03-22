package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DOMPropertiestest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
		List <WebElement> list1 = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li"));
		//int i = list1.size();
		driver.navigate().refresh();
		System.out.println("Number of Objects in the dropdown links are::"+list1.size());
		for(int j=0;j<list1.size();j++)
		{
			System.out.println(list1.get(j).getText());
			list1.get(j).click();
			
		}
		
		
	}

}
