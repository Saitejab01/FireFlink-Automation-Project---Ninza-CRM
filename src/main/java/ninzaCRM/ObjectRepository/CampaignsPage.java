package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.genericUtilities.WebDriverUtility;

public class CampaignsPage extends WebDriverUtility{
	@FindBy(xpath = "//select[@class='form-control']") private WebElement searchCampaigns;
	@FindBy(xpath = "//input[@placeholder='Search by Campaign Id']") private WebElement searchTextField;
	@FindBy(xpath = "//span[.='Create Campaign']") private WebElement createCampaign;
	@FindBy(xpath = "//div[contains(text(),'Successfully Added') and contains(text(),'Campaign')]") private WebElement succcessfullyAddedMsg;
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchCampaigns() {
		return searchCampaigns;
	}
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	public WebElement getCreateCampaign() {
		return createCampaign;
	}
	public CreateCampaignPage getCreateCampaignPage(WebDriver driver) {
		return new CreateCampaignPage(driver);
	}
	public WebElement getSucccessfullyAddedMsg() {
		return succcessfullyAddedMsg;
	}
	
	public void toSearchCampaign(String idorname,String CampaignNameOrID) {
		String value;
		if (idorname.equalsIgnoreCase("id")) {
			value="Id";
		}else if(idorname.equalsIgnoreCase("name")) {
			value="Name";
		}else {
			value = idorname;
		}
		handleDropdowns(value, searchCampaigns);
		searchTextField.sendKeys(CampaignNameOrID);
	}
}
