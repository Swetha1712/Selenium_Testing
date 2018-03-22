package seleniumPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Readpropertiesfile {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\Selenium_Testing\\Selenium_test\\src\\test_naveen\\config_fb_signup.properties");
		prop.load(ip);

		System.out.println(prop.getProperty("name"));

		String url = prop.getProperty("Url");

		String Browser_name = prop.getProperty("browser");
		System.out.println(url);
		System.out.println(Browser_name);

		if (Browser_name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser_name.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Dinesh\\Downloads\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.findElement(By.name(prop.getProperty("firstname_name"))).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.name(prop.getProperty("lastname_name"))).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.name(prop.getProperty("Mobile_num_name"))).sendKeys(prop.getProperty("num"));
		driver.findElement(By.name(prop.getProperty("new_pwd_name"))).sendKeys(prop.getProperty("new_password"));

		Select s1 = new Select(driver.findElement(By.id(prop.getProperty("birth_mnth_id"))));
		s1.selectByVisibleText(prop.getProperty("birth_mnth"));

		Select s2 = new Select(driver.findElement(By.id(prop.getProperty("birth_date_id"))));
		s2.selectByVisibleText(prop.getProperty("birth_date"));

		Select s3 = new Select(driver.findElement(By.id(prop.getProperty("birth_year_id"))));
		s3.selectByVisibleText(prop.getProperty("birth_year"));

		driver.findElement(By.name(prop.getProperty("radio_btn_name"))).click();

		driver.findElement(By.name(prop.getProperty("create_btn_name"))).click();

	}

}
