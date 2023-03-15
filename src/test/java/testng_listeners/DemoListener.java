package testng_listeners;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)

public class DemoListener {
	
	
	@Test
	public void testA() {
		
		assertTrue(true);	
	}
	
	@Test
	public void testB() {
		
		assertTrue(true);	
	}

	
	@Test
	public void testC() {
		
		assertTrue(false);	
	}


	@Test(enabled = false)
	public void testD() {
		
		assertTrue(false);	
	}
}
