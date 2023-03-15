package configuration_properties_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class ConfPropertiesDemo {
	
	@Test
	public void loginToOrangeHRM() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement usernameInputBox = driver.findElement(By.cssSelector("input[name='username']"));
		WebElement passwordInputBox = driver.findElement(By.cssSelector("input[name='password']"));
		WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
		
		usernameInputBox.sendKeys(ConfigReader.getPropertyValue("username"));
		passwordInputBox.sendKeys(ConfigReader.getPropertyValue("password"));
		loginButton.click();
	}
	

}
