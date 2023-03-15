package testng_assertion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class TestMain {
	
	//assertEquals()
	@Test
	public void testAddFunction1() {
		
		Main main = new Main();
		
		int actualResult = main.addNumbers(5, 7);
		
		assertEquals(actualResult, 13, "add functionality is not working as expected");
		
		
	}
	
	//assertNotEquals
	@Test
	public void testAddFunction2() {
		
		Main main = new Main();
		
		int actualResult = main.addNumbers(5, 7); //12
		
		assertNotEquals(actualResult, 1);
			
	}
	
	//assertTrue(), assertFalse()
	@Test
	public void testAddFunction3() {
		
		Main main = new Main();
		
	//	boolean actualResult = main.addNumbers(5, 7) == 12; //12
		
		//assertTrue(main.addNumbers(10, 15) == 25);
		assertFalse(main.addNumbers(10, 15) == 29);	
	}
	
	//assertNull(), assertNotNull()
	@Test
	public void testNull() {
		
	String a = null;
		
		//assertNull(a,"Object is not null");
		assertNotNull(a, "Object is a null");
	}
	
	
	@Test
	public void testFail() {
		
		Main main = new Main();
		
		if (main.divide(10, 0)==0 ) {
		
		fail("Cannot divide by zero");
		
		}
	}
	
}
