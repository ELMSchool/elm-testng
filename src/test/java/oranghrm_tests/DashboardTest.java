package oranghrm_tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.PageFactoryClass;
import utils.ConfigReader;
import utils.Driver;
import utils.VerificationUtils;

public class DashboardTest extends TestBase {

	@Test
	public void testWeAreOnDashboard() {

		pageFactoryClass.loginPage().loginToOrangeHRM(ConfigReader.getPropertyValue("username"),
				ConfigReader.getPropertyValue("password"));
		String actualDashboardHeaderLable = pageFactoryClass.dashboardPage().getPageHeader("Dashboard").getText();

		VerificationUtils.verifyEquals(actualDashboardHeaderLable, "Dashboar");

	}

	@Test
	public void testLeaveRequestsToApprove() {
		pageFactoryClass.loginPage().loginToOrangeHRM(ConfigReader.getPropertyValue("username"),
				ConfigReader.getPropertyValue("password"));
		pageFactoryClass.dashboardPage().selectFromActionsOnDashboard("Leave Requests to Approve");
		WebElement leavePageHeaderElement = pageFactoryClass.leavePage().getPageHeader("Leave");
		
		VerificationUtils.verifyElementIsDisplayed(leavePageHeaderElement);
	}

}
