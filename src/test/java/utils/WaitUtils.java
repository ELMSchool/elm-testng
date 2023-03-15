package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	

	/**
	 * Performs a pause
	 * @param seconds
	 */
	public static void pauseFor(int seconds) {
		
		try {
			
			Thread.sleep(seconds * 1000);
		}catch(InterruptedException e) {
			
			e.printStackTrace();
		}
		
	} 
	
	/**
	 * Waits for element to become visible
	 * @param element
	 * @param timeout
	 */
	public static void waitForElementVisibility(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);		
		wait.until(ExpectedConditions.visibilityOf(element));	
	}

	/**
	 * Waits for element to become invisible
	 * @param element
	 * @param timeout
	 */
	public static void waitForElementInvisibility(WebElement element, int timeout) {	
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);		
		wait.until(ExpectedConditions.invisibilityOf(element));		
	}
	
	
	/**
	 * Waits for element to become clickable
	 * @param element
	 * @param timeout
	 */
	public static void waitForElementBecomeClickable(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);		
		wait.until(ExpectedConditions.elementToBeClickable(element));		
	}

}
