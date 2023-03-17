package oranghrm_tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PageFactoryClass;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;
import utils.OrangeHRMConstants;
import utils.VerificationUtils;
import utils.WaitUtils;

public class LoginTest extends TestBase{
	
	

	@Test
	public void testLoginWithValidCredentials() {
		extentLogger = report.createTest("Test Login With Valid Credentials");
		pageFactoryClass.loginPage().loginToOrangeHRM(
				ConfigReader.getPropertyValue("username"),
				ConfigReader.getPropertyValue("password")
				);
		String currentUrl = Driver.getDriver().getCurrentUrl();
		
		VerificationUtils.verifyEquals(currentUrl, OrangeHRMConstants.DASHBOARD_PAGE_URL);
	}
	
	@Test
	public void testLoginWithInvalidCredentials() {
		extentLogger = report.createTest("Test Login With Invalid Credentials");
		pageFactoryClass.loginPage().loginToOrangeHRM(
				ConfigReader.getPropertyValue("invalidUsername"),
				ConfigReader.getPropertyValue("invalidPassword")
				);
		
		assertTrue(pageFactoryClass.loginPage().invalidCredetentialsErrorMessage.isDisplayed());
	}
	

}
