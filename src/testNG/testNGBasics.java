package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGBasics {
	
	
	@BeforeSuite
	public void setup() {
		System.out.println("Set up Driver");
	}
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launch Browser");
		
	}
	@BeforeClass
	public void openurl() {
		System.out.println("Open Url");
	}
	
	@BeforeMethod
	public void Logintoapp() {
		System.out.println("Login to Application");
	}
	
	@Test
	public void gettitle() {
		System.out.println("Get the title of the page");
	}
	@AfterMethod
	public void Logout() {
		System.out.println("Logout of the application");
	}
	
	@AfterClass
	public void deletecookies() {
		System.out.println("Delete all the cookies");
	}
	@AfterTest
	public void closeBrowser() {
		System.out.println("CLose the browser");
	}
	
	@AfterSuite
	public void Printresults() {
		System.out.println("Results");
	}
	
}
