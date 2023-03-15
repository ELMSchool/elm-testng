package utils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class VerificationUtils {
	
	/**
	 * Verifies if actual text is matching with expected
	 * @param actual
	 * @param expected
	 */
	public static void verifyEquals(String actual, String expected) {
		
		try {
		assertEquals(actual, expected, "\nExpected: "+expected + "\nActual: "+actual+"\n");
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Verifies whether element is displayed on this page
	 * @param element
	 */
	public static void verifyElementIsDisplayed(WebElement element) {
		
		try {
			
			assertTrue(element.isDisplayed(), "Elment is not visible");
		}catch(NoSuchElementException e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Verifies whether element is NOT displayed on this page
	 * @param element
	 */
	public static void verifyElementIsNotDisplayed(WebElement element) {
		
		try {
			
			assertFalse(element.isDisplayed(), "Elment should not be visible");
		}catch(NoSuchElementException e) {
			
			e.printStackTrace();
		}
	}
}
