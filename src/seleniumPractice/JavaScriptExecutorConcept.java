package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("Swethakan");
		driver.findElement(By.name("password")).sendKeys("freecrm");
		// Flash login button to highlight it
		WebElement loginbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		flash(loginbtn, driver);

		// Drawing a border for login button
		drawBorder(loginbtn, driver);

		// Generate alert message for login button
		// generateAlert(driver, "The username or password is incorrect");

		// Clicking on Login button by using Java Script Executor
		// clickElementbyJS(loginbtn, driver);

		// Refreshing the page by using java Script Executor
		refreshBrowserbyJS(driver);

		// Printing the title of the page by using Java Script Executor
		System.out.println("Title of the page is : " + getTitlebyJS(driver));

		// Getting the page innertext by Java Script Executor
		System.out.println("Page Inner Text is :" + getpageInnerText(driver));

		// Scrolling the page to the end of it
		scrollPageDown(driver);
		// Scrolling the page to view the "Task & Event Tracking" element
		WebElement track_element = driver.findElement(By.xpath("//h3[contains(text(),'Task & Event Tracking')]"));
		scrollIntoView(track_element, driver);
		drawBorder(track_element, driver);

	}

	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}

	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}

	public static void clickElementbyJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	public static void refreshBrowserbyJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public static String getTitlebyJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static String getpageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
