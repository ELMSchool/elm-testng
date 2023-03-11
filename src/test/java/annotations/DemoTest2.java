package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest2 {
	
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
	@Test(groups = "special")
	public void testC() {
		
		System.out.println("C");
	}

}
