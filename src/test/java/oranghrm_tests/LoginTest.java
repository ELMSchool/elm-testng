package oranghrm_tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PageFactoryClass;
import utils.ConfigReader;
import utils.Driver;

public class LoginTest extends TestBase{
	
	

	@Test
	public void testLoginWithValidCredentials() {
		
		pageFactoryClass.loginPage().loginToOrangeHRM(
				ConfigReader.getPropertyValue("username"),
				ConfigReader.getPropertyValue("password")
				);
		String currentUrl = Driver.getDriver().getCurrentUrl();
		assertTrue(currentUrl.contains("dashboard"));
	}
	
	@Test
	public void testLoginWithInvalidCredentials() {
		
		pageFactoryClass.loginPage().loginToOrangeHRM(
				ConfigReader.getPropertyValue("invalidUsername"),
				ConfigReader.getPropertyValue("invalidPassword")
				);
		
		assertTrue(pageFactoryClass.loginPage().invalidCredetentialsErrorMessage.isDisplayed());
	}
	

}
