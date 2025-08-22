package practiceByGeneric;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepository.CreateLeadPage;
import ninzaCRM.ObjectRepository.DashBoardPage;
import ninzaCRM.ObjectRepository.LeadsPage;
import ninzaCRM.ObjectRepository.LoginPage;
import ninzaCRM.genericUtilities.FileUtility;
import ninzaCRM.genericUtilities.WebDriverUtility;

public class ClassRoomPractice2 {
	@Test
	public void main() throws Throwable {
		//create Objects For all generic class
		FileUtility futil = new FileUtility();
		String URL = futil.ReadDataFromPropertyFile("url");
		String USERNAME = futil.ReadDataFromPropertyFile("username");
		String PASSWORD = futil.ReadDataFromPropertyFile("password");
		String BROWSER = futil.ReadDataFromPropertyFile("browser");
		WebDriver driver;
		switch(BROWSER) {
		case "chrome" : driver = new ChromeDriver();break;
		case "firefox" : driver = new FirefoxDriver();break;
		case "edge" : driver = new EdgeDriver();break;
		default : driver= new EdgeDriver();
		}
		driver.get(URL);
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.maximizeWindow(driver);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Thread.sleep(2000);
		DashBoardPage DB = new DashBoardPage(driver);
		DB.getLeadsL().click();
		LeadsPage l = new LeadsPage(driver);
		l.getCreateLeadBtn().click();
		CreateLeadPage clp = new CreateLeadPage(driver);
		clp.toFillDetailsInCreateLead(driver, "alive", "saiteja", "TestYantra", "FireFlink", "Jspiders","6320457822", "ID", "CAM00578");
		
	}
}
