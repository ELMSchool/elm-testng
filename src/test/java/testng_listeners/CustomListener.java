package testng_listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {
	
	public void onStart(ITestContext context) {
		System.out.println("Tests started");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Starting test: "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Successed: "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Failed: "+ result.getName() + " Taking Screenshot...");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped: "+ result.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test run finished");
	}

	

}
