package driver_test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import utils.Driver;

public class DriverTest {

	@Test
	public void testDriver() {
		
		Driver.getDriver().get("https://www.google.com/");
		assertEquals(Driver.getDriver().getTitle(), "Google");
	}
	
	
}
