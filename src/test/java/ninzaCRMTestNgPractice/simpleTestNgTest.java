package ninzaCRMTestNgPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepository.CampaignsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.DashBoardPage;
import ninzaCRM.genericUtilities.BaseClass;

public class simpleTestNgTest extends BaseClass{
	@Test
	public void createCampagin() throws EncryptedDocumentException, IOException, InterruptedException {
		String CAMPAIGNNAME = futil.ReadDataFromExcelFile("Sheet1", 22, 2);
		String TARGETSIZE = futil.ReadDataFromExcelFile("Sheet1", 22, 3);
		DashBoardPage dbp = new DashBoardPage(driver);
		dbp.getCampaignsL().click();
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaign().click();
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.toFillDetailsCreateInCampanign(CAMPAIGNNAME, TARGETSIZE);
		
	}
}
