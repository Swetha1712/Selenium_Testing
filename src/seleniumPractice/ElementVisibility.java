package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibility {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/register/");
		

		// is displayed method to check firstname

		boolean b1 = driver.findElement(By.name("first_name")).isDisplayed();
		System.out.println("First name is displayed:" + b1);

		// verify the presence of Submit button
		boolean b2 = driver.findElement(By.id("submitButton")).isDisplayed();
		System.out.println("Submit button is displayed but not enabled: " + b2);

		// verify the enability of Submit button
		boolean b3 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println("Submit button is not enabled now: " + b3);// return false now

		// verify the enability of I agree Check box
		boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println("I agree check box is not checked: " + b4);// return false now

		// check the check box and add first name
		driver.findElement(By.name("first_name")).sendKeys("test12");
		driver.findElement(By.name("agreeTerms")).click();

		// verify that the I agree check box is checked
		boolean b5 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println("I agree check box is checked now: " + b5);

		// verify the enability of Submit button
		boolean b6 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println("Submit button is enabled now: " + b6);

	}

}
