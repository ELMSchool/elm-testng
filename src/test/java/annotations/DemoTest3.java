package annotations;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class DemoTest3 {

	@BeforeGroups("special")
	public void beforeGroups() {
		
		System.out.println("before groups");
	}
	
	@AfterGroups ("special")
	public void afterGroups() {
		System.out.println("after groups");
	}
	@Test(groups = "special")
	public void testD() {
		
		System.out.println("D");
	}
	
	@Test
	public void testE() {
		
		System.out.println("E");
	}
}
