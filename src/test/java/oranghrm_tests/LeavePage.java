package oranghrm_tests;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.Navigation;
import utils.Driver;

public class LeavePage extends Navigation{

	public LeavePage () {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
}
