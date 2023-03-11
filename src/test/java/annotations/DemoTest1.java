package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest1 {

	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("before suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}
	
	@AfterClass
	public void afterClass() {
		
		System.out.println("after class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
		
	}
	
	@Test(groups="special")
	public void testA() {
		System.out.println("A");
	}
	
	
	@Test
	public void testB() {	
		System.out.println("B");
	}
	
}
