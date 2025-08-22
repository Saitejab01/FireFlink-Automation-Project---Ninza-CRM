package Prep___;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ninzaCRM.genericUtilities.FileUtility;

public class DataProviderTest {
	@Test (dataProvider = "getData")
	public void create(String name , double id) {
		System.out.println(name+" "+id+" - is created");
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		FileUtility fu = new FileUtility();
		return fu.readDataForDataProvider();
	}
	
}
