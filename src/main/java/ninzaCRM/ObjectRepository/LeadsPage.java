package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.genericUtilities.WebDriverUtility;

public class LeadsPage extends WebDriverUtility{
	@FindBy(xpath = "//select[@class='form-control']") private WebElement searchLeads;
	@FindBy(xpath = "//input[@placeholder='Search by Lead Id']") private WebElement searchTextField;
	@FindBy(xpath = "//span[.='Create Lead']") private WebElement createLeadBtn;
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchLeads() {
		return searchLeads;
	}
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}
	
	public void toSearchLead(String idorname,String LeadNameOrID) {
		String value;
		if (idorname.equalsIgnoreCase("id")) {
			value="Id";
		}else if(idorname.equalsIgnoreCase("name")) {
			value="Name";
		}
		value = idorname;
		handleDropdowns(value, searchLeads);
		searchTextField.sendKeys(LeadNameOrID);
	}
}
