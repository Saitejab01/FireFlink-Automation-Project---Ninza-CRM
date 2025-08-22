package Prep___;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepository.CampaignsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.DashBoardPage;
import ninzaCRM.genericUtilities.BaseClass;
@Listeners(ninzaCRM.genericUtilities.ListenersImplementation.class)
public class CreateCampTest extends BaseClass{
	@Test(groups = "SmokeSuite1")
	public void createCamp() throws Throwable {
		DashBoardPage db = new DashBoardPage(driver);
		db.getCampaignsL().click();
		Reporter.log("clicked on camp Link",true);
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaign().click();
		Reporter.log("clicked on create camp btn",true);
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.toFillDetailsCreateInCampanign("asdfgh", "100");
		Reporter.log("Camp is done",true);
	}
}
