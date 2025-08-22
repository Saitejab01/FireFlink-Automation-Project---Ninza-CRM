package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	@FindBy(name = "campaignName") private WebElement campaignNameTF;
	@FindBy(name = "targetSize") private WebElement targetSizeTF;
	@FindBy(xpath = "//button[.='Create Campaign']") private WebElement createCampaignBtn;
	public  CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getCampaignName() {
		return campaignNameTF;
	}
	public WebElement getTargetSize() {
		return targetSizeTF;
	}
	public WebElement getCreateCampaign() {
		return createCampaignBtn;
	}
	public void toFillDetailsCreateInCampanign(String campaignName , String targetSize) throws InterruptedException {
		campaignNameTF.sendKeys(campaignName);
		targetSizeTF.sendKeys(targetSize);
		createCampaignBtn.click();
	}
	
}
