package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class DashboardPage extends Navigation{

	public DashboardPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//p[text()='My Actions']")
	public WebElement myActionsLable;
	
	
	public WebElement getActionElement(String actionName) {
		
		String xpath = "//p[text()[contains(.,'" +actionName+ "')]]";
		
		return Driver.getDriver().findElement(By.xpath(xpath));
	}
	
	
	public void selectFromActionsOnDashboard(String actionName) {
		
		getActionElement(actionName).click();
	}

}
