package Prep___;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepository.CreateLeadPage;
import ninzaCRM.ObjectRepository.DashBoardPage;
import ninzaCRM.ObjectRepository.LeadsPage;
import ninzaCRM.genericUtilities.BaseClass;
@Listeners(ninzaCRM.genericUtilities.ListenersImplementation.class)
public class SmokeTestPractice extends BaseClass{
	@Test
	public void createLead () throws Throwable {
		DashBoardPage db = new DashBoardPage(driver);
		db.getLeadsL().click();
		LeadsPage lead = new LeadsPage(driver);
		lead.getCreateLeadBtn().click();
		CreateLeadPage page = new CreateLeadPage(driver);
		page.toFillDetailsInCreateLead(driver, "alive", "saiteja", "TestYantra", "FireFlink", "Jspiders","6320457822", "ID", "CAM00578");
	}
	@Test
	public void createLead2 () throws Throwable {
		DashBoardPage db = new DashBoardPage(driver);
		db.getLeadsL().click();
		LeadsPage lead = new LeadsPage(driver);
		lead.getCreateLeadBtn().click();
		CreateLeadPage page = new CreateLeadPage(driver);
		page.toFillDetailsInCreateLead(driver, "alive", "saiteja", "TestYantra", "FireFlink", "Jspiders","6320457822", "ID", "CAM00578");
		Assert.fail();
	}
}
