package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public abstract class Navigation {

	public Navigation() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	@FindBy(css=".oxd-userdropdown-name")
	WebElement userDropDown;
	
	
	@FindBy(css="oxd-dropdown-menu>li")
	List<WebElement> userDropdownOptions;
	
	public WebElement getPageHeader(String pageName) {
		
		String xpath = "//h6[.='"+ pageName +"']";
		
		return Driver.getDriver().findElement(By.xpath(xpath));
	}
	
	public WebElement getMenuSectionElement(String sectionName) {
		
		String xpath = "//span[text()='"+sectionName +"']";
		
		return Driver.getDriver().findElement(By.xpath(xpath));
	}
	
	public void selectFromMenuSection(String sectionName) {
		
		getMenuSectionElement(sectionName).click();
	}
	
	public void selectFromUserDropdown(String optionName) {
		
		for (WebElement option : userDropdownOptions) {
			
			if (option.getText().equals(optionName)) {
				option.click();
			}
		}
	} 

}
