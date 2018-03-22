package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Locatortechniques {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://www.spicejet.com/");
		// Select One-way button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		// Select FROM city
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("//a[@href='#'][contains(text(),'Kochi
		// (COK)')]"))).build().perform();
		driver.findElement(By.xpath("//a[@href='#'][contains(text(),'Kochi (COK)')]")).click();
		// Select To city
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();

		// action.moveToElement(driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='TIR']"))).build().perform();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='TIR']"))
				.click();
		// select depart date
		// driver.findElement(By.className("ui-datepicker-trigger")).click();
		driver.findElement(By.xpath("//html//tr[1]/td[6]/a[1]")).click();

		// select Adult
		Select selec = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		selec.selectByVisibleText("6");
		// select child
		Select selec1 = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		selec1.selectByVisibleText("3");
		// select Infant
		Select selec2 = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		selec2.selectByVisibleText("1");
		// select Currency
		Select selec3 = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		selec3.selectByVisibleText("USD");
		//Click on Search button
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
