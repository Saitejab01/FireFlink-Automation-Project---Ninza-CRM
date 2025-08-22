package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.genericUtilities.WebDriverUtility;

public class CreateLeadPage extends WebDriverUtility{
	@FindBy(name = "leadStatus") private WebElement leadStatusTF;
	@FindBy(name = "name") private WebElement leadNameTF;
	@FindBy(name = "company") private WebElement companyTF;
	@FindBy(name = "leadSource") private WebElement leadSourceTF;
	@FindBy(name = "industry") private WebElement industryTF;
	@FindBy(name = "phone") private WebElement phoneTF;
	@FindBy(xpath = "//*[local-name()='svg'and contains(@class,'svg-inline--fa fa-plus')]") private WebElement plusBtn;
	@FindBy(id = "search-criteria") private WebElement searchCampaignByID;
	@FindBy(id = "search-input") private WebElement searchCampaign;
	@FindBy(xpath = "//button[.='Create Lead']") private WebElement createLeadBtn;
	@FindBy(xpath = "//button[.='Select']") private WebElement selectBtn;
	public CreateLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getLeadStatusTF() {
		return leadStatusTF;
	}
	public WebElement getLeadNameTF() {
		return leadNameTF;
	}
	public WebElement getCompanyTF() {
		return companyTF;
	}
	public WebElement getLeadSourceTF() {
		return leadSourceTF;
	}
	public WebElement getIndustryTF() {
		return industryTF;
	}
	public WebElement getPhoneTF() {
		return phoneTF;
	}
	public WebElement getPlusBtn() {
		return plusBtn;
	}
	public WebElement getSearchCampaignByID() {
		return searchCampaignByID;
	}
	public WebElement getSearchCampaign() {
		return searchCampaign;
	}
	/**
	 * This method Will create a lead with mandatory Fields
	 * @param driver
	 * @param leadStatus
	 * @param leadName
	 * @param company
	 * @param leadSource
	 * @param industry
	 * @param number
	 * @param Name_or_ID
	 * @param CampaignName_or_CampaignID
	 * @throws InterruptedException
	 */
	public void toFillDetailsInCreateLead(WebDriver driver,String leadStatus,String leadName, String company,String leadSource,String industry,String number,String Name_or_ID,String CampaignName_or_CampaignID) throws InterruptedException {
		leadStatusTF.sendKeys(leadStatus);
		leadNameTF.sendKeys(leadName);
		companyTF.sendKeys(company);
		leadSourceTF.sendKeys(leadSource);
		industryTF.sendKeys(industry);
		phoneTF.sendKeys(number);
		plusBtn.click();
		switchToWindow(driver, "Select Campaign");
		String value;
		if (Name_or_ID.equalsIgnoreCase("id")) {
			value="ID";
		}else if(Name_or_ID.equalsIgnoreCase("name")) {
			value="Name";
		}else {
			value = Name_or_ID;
		}
		System.out.println(value);
		handleDropdowns(searchCampaignByID,value);
		searchCampaign.sendKeys(CampaignName_or_CampaignID);
		Thread.sleep(2000);
		selectBtn=driver.findElement(By.xpath("//td[.='"+CampaignName_or_CampaignID+"']/following-sibling::td//button[.='Select']"));
		selectBtn.click();
		switchToWindow(driver, "Ninza CRM");
		createLeadBtn.click();
	}
	
	
}
