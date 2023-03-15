package oranghrm_tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.PageFactoryClass;
import utils.ConfigReader;
import utils.Driver;

public abstract class TestBase {

	PageFactoryClass pageFactoryClass;
	
	@BeforeMethod
	public void setUp() {
		
		pageFactoryClass = new PageFactoryClass(Driver.getDriver());
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void tearDown() {
		Driver.closeDriver();
	}
	
	
}
