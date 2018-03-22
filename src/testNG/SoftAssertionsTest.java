package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsTest {
	
	SoftAssert softassert = new SoftAssert();
	
	@Test
	public void test1() {
		System.out.println("Open browser");
		Assert.assertEquals(true, true);
		
		System.out.println("Login to the app");
		Assert.assertEquals(true, true);
		
		System.out.println("Validate title of the page");
		softassert.assertEquals(4, 5, "Actual and Expected results are not matched");
		
		System.out.println("Create Contact");
		softassert.assertEquals(true, false);
		
		
		softassert.assertAll();
		
	}

}
