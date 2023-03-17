package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	private Driver() {}
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		
		if (driver.get() == null) {
			
			String browser = ConfigReader.getPropertyValue("browser");
			
			switch(browser) {
			
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver.set(new ChromeDriver());
				driver.get().manage().window().maximize();
				break;
				
			case "chromeHeadless":
				WebDriverManager.chromedriver().setup();
				driver.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));  ;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver.set(new FirefoxDriver());
				break;	
				
			case "firefoxHeadless":
				WebDriverManager.firefoxdriver().setup();
				driver.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
				break;	
				
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver.set(new EdgeDriver());
				break;		
			}
			
		}
		
		return driver.get();
	}

	public static void closeDriver() {
		
		if (driver.get() != null) {
			driver.get().quit();
			driver.set(null);;
		}
	}
}
