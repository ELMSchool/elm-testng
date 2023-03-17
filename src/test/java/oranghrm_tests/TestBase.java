package oranghrm_tests;

import java.util.concurrent.TimeUnit;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.PageFactoryClass;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;
import utils.WaitUtils;

public abstract class TestBase {

	PageFactoryClass pageFactoryClass;
	protected  static ExtentReports report;
	protected  static ExtentSparkReporter sparkHtmlReporter;
	protected  static ExtentTest extentLogger;
	
	
	@BeforeSuite
	public void setUpSuite() {
		
		report = new ExtentReports();
		
		String filePath = System.getProperty("user.dir")+ "/test-output/report.html";
		
		sparkHtmlReporter = new ExtentSparkReporter(filePath);
		report.attachReporter(sparkHtmlReporter);
		
		sparkHtmlReporter.config().setReportName("OrangeHRM Automated Test Reports");
		
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("Browser", ConfigReader.getPropertyValue("browser"));
	}
	
	@AfterSuite
	public void tearDownSuite() {
		report.flush();
	}
	
	@BeforeMethod
	public void setUpMethod() {
		
		pageFactoryClass = new PageFactoryClass(Driver.getDriver());
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			extentLogger.fail(result.getName());
			String screenthotLocation = BrowserUtils.getScreenshot(result.getName());
			extentLogger.addScreenCaptureFromPath(screenthotLocation);
			extentLogger.fail(result.getThrowable());
			
		}else if (result.getStatus() == ITestResult.SKIP) {
			
			extentLogger.skip("Test case skipper: "+result.getName());
		}
		
		Driver.closeDriver();
	}
	
	
}



















