package oranghrm_tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.PageFactoryClass;
import utils.ConfigReader;
import utils.Driver;
import utils.OrangeHRMConstants;
import utils.VerificationUtils;

public class DashboardTest extends TestBase {

	@Test
	public void testWeAreOnDashboard() {
		extentLogger = report.createTest("Test We are on Dashboard Page");
		pageFactoryClass.loginPage().loginToOrangeHRM(ConfigReader.getPropertyValue("username"),
				ConfigReader.getPropertyValue("password"));
		String actualDashboardHeaderLable = pageFactoryClass.dashboardPage().getPageHeader("Dashboard").getText();

		VerificationUtils.verifyEquals(actualDashboardHeaderLable, OrangeHRMConstants.DASHBOARD_PAGE_HEADER);

	}

	@Test
	public void testLeaveRequestsToApprove() {
		extentLogger = report.createTest("Test Leave Request to Approve Button");
		pageFactoryClass.loginPage().loginToOrangeHRM(ConfigReader.getPropertyValue("username"),
				ConfigReader.getPropertyValue("password"));
		pageFactoryClass.dashboardPage().selectFromActionsOnDashboard("Leave Requests to Approve");
		WebElement leavePageHeaderElement = pageFactoryClass.leavePage().getPageHeader("Leave");
		
		VerificationUtils.verifyElementIsDisplayed(leavePageHeaderElement);
	}

}
