package testng_assertion;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertionTest {
	
	@Test
	public void demoTest() {
		
		int a = 5;
		int b = 10;
		
		assertEquals(a+b, 10);
		
		System.out.println("Assertion completed");
		
	}
	
	@Test
	public void orangeHRMLogin() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement usernameInputBox = driver.findElement(By.cssSelector("input[name='username']"));
		WebElement passwordInputBox = driver.findElement(By.cssSelector("input[name='password']"));
		WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
		
		
		usernameInputBox.sendKeys("ivalidUser");
		passwordInputBox.sendKeys("ivalidPassword");
		loginButton.click();
		
		SoftAssert softAssert = new SoftAssert();
		
		WebElement errorMessageElement = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
		String errorMessageText = errorMessageElement.getText();
		
//		softAssert.assertTrue(driver.getTitle().endsWith("dashboard")); //fail
//		softAssert.assertEquals(errorMessageText, "Invalid"); //fail
		softAssert.assertTrue(errorMessageText.contains("Invalid")); //pass
		
		System.out.println("trying to print after soft assert");
		softAssert.assertAll();
		
//		
//		assertEquals(errorMessageText, "Invalid");
//		
//		System.out.println("trying to print after hard assert");
		
	}
	

}
