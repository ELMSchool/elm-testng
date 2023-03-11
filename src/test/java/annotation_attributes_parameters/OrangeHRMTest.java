package annotation_attributes_parameters;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTest {
	
	WebDriver driver;
	
	@DataProvider(name = "data")
	public Object[][] testData(){
		
		return new Object [][] {
			
			{"Admin",  "admin123"},
			{"elmtest",  "Elm1234!"}
		};
		
	}
	
	@BeforeClass(groups={"smoke", "regression"})
	public void setUp() {
		System.out.println("Setting up Browser...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups={"smoke", "regression"})
	public void tearDown() {
		System.out.println("Closing Browser...");
		driver.quit();
	}
	
	@Test(description = "Verify current url is matching with expected url on login page", priority = 0, groups={"smoke","regression"})
	public void testLandOnWebPage() {
			
		String actualCurrentUrl = driver.getCurrentUrl();
		String expectedCurrentUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		//we are verifying actual url with expected
		assertEquals(actualCurrentUrl, expectedCurrentUrl);
		
	}
	
	@Test(dataProvider = "data",description = "Verify current url is matching with expected url on dashboard page", priority = 1, groups = {"smoke", "regression"})
	public void testLoginWithValidCredentials(String username, String password) {
		
		WebElement usernameInputBox = driver.findElement(By.name("username"));
		WebElement passwordInputBox = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
		
		usernameInputBox.sendKeys(username);
		passwordInputBox.sendKeys(password);
		loginButton.click();
		
		String actualCurrentUrl = driver.getCurrentUrl();
		String expectedCurrentUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		assertEquals(actualCurrentUrl, expectedCurrentUrl);
	}
	
	@Test(description = "Verify Admin panel header matching with expected", priority = 2, enabled = true, groups = "regression")
	public void testNavigatingToAdminPanel() {
		
		WebElement menuItemAdmin = driver.findElement(By.xpath("//span[text()='Admin']"));
		menuItemAdmin.click();
		WebElement adminPanelHeader = driver.findElement(By.xpath("//h6[text()='Admin']"));
		String actualAdminHeaderText = adminPanelHeader.getText();
		String expectedAdminHeaderText = "Admin";
		
		assertEquals(actualAdminHeaderText, expectedAdminHeaderText);
		
	}
	

	

	

}
