package testng_extent_report;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExampleReport {
	
	
	
	private ExtentReports extent;
	private ExtentSparkReporter spark;
	private ExtentTest test;
	

	@BeforeSuite
	public void setUp() {
		
		String filePath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
		
		spark = new ExtentSparkReporter(filePath);
		extent = new ExtentReports();
		extent.attachReporter(spark);			
	}
	
	@AfterSuite
	public void tearDown() {
		
		extent.flush();
	}
	
	@Test
	public void testA() {
		
		test = extent.createTest("Test Method");
		
		test.log(Status.INFO, "Starting test method");
		
		
		test.log(Status.PASS, "Test method passed");
	}
	
	
	
}
