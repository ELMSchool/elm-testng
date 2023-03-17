package pages;

import org.openqa.selenium.WebDriver;

import oranghrm_tests.LeavePage;

public class PageFactoryClass {
	
	private WebDriver driver;
	
	public PageFactoryClass (WebDriver driver) {
		
		this.driver = driver;
	}

	
	public LoginPage loginPage() {
		
		return new LoginPage();
	}
	
	public DashboardPage dashboardPage () {
		
		return new DashboardPage();
	}
	
	public LeavePage leavePage () {
		
		return new LeavePage();
	}
}
