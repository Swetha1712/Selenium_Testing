package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DynamicWebTableHandle {

	WebDriver driver;

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		// driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		// driver.get("https://www.freecrm.com");
		// driver.findElement(By.name("username")).sendKeys("Swethakan");
		// driver.findElement(By.name("password")).sendKeys("freecrm");
		// driver.findElement(By.xpath("//input[@type='submit']")).submit();
		//
		// driver.switchTo().frame("mainpanel");

		DynamicWebTableHandle myobj = new DynamicWebTableHandle();

		myobj.InvokeBrowser();
		myobj.Login();
		// myobj.CreateContact();
		myobj.SelectContactcheckbox();
		myobj.DeleteContact();

		// driver.findElement(By.xpath("//a[@title='Contacts']")).click();
		// driver.findElement(By.xpath("//a[contains(text(),test
		// dd)/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();

	}

	public void InvokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");
	}

	public void Login() {
		driver.findElement(By.name("username")).sendKeys("Swethakan");
		driver.findElement(By.name("password")).sendKeys("freecrm");
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		driver.switchTo().frame("mainpanel");
	}

	public void CreateContact() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@title='Contacts']"))).build().perform();
		action.click(driver.findElement(By.xpath("//a[@title='New Contact']"))).build().perform();
		driver.findElement(By.id("first_name")).sendKeys("test4");
		driver.findElement(By.id("surname")).sendKeys("gh");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
	}

	public void SelectContactcheckbox() {
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();
		driver.findElement(By.xpath(
				"//a[contains(text(),'test2 lastname')]/parent::td//preceding-sibling::td//input[@name='contact_id']"))
				.click();
	}
	
	public void DeleteContact() {
		Select s = new Select(driver.findElement(By.name("do_action")));
		s.selectByVisibleText("Delete Checked");
		driver.findElement(By.xpath("//input[@value='DO']")).click();
		
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	

}
