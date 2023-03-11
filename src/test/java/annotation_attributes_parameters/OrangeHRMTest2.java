package annotation_attributes_parameters;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTest2 {

	@DataProvider
	public Object[][] testData() {

		return new Object[][] {

				{ "Admin", "admin123" }, 
				{ "elmtest", "Elm1234!" }, 
				{ "gfjmd", "sdaf!" } ,
				{ "qwet", "sadf!" } 
				};
	}

	@Test(dataProvider = "testData")
	public void loginTest(String username, String password) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		
		WebElement usernameInputBox = driver.findElement(By.name("username"));
		WebElement passwordInputBox = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
		
		usernameInputBox.sendKeys(username);
		passwordInputBox.sendKeys(password);
		loginButton.click();
		
		String actualCurrentUrl = driver.getCurrentUrl();
		String expectedCurrentUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		assertEquals(actualCurrentUrl, expectedCurrentUrl);
		driver.close();
	}

}
