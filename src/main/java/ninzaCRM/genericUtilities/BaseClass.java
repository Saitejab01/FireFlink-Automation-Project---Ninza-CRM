package ninzaCRM.genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ninzaCRM.ObjectRepository.DashBoardPage;
import ninzaCRM.ObjectRepository.LoginPage;

public class BaseClass {
	public FileUtility futil = new FileUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("===============connection done====================");
	}
	//@Parameters("browser")
//	@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException {
		String URL = futil.ReadDataFromPropertyFile("url");
		String BROWSER = futil.ReadDataFromPropertyFile("browser");
		switch(BROWSER) {
		case "chrome" : driver = new ChromeDriver();break;
		case "firefox" : driver = new FirefoxDriver();break;
		case "edge" : driver = new EdgeDriver();break;
		default : driver= new EdgeDriver();
		}
		
		wutil.maximizeWindow(driver);
		wutil.provideImplicitlyWait(driver);
		driver.get(URL);
		System.out.println("==========="+BROWSER+" browser is opened ====================");
		sdriver=driver;
	}
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		String USERNAME = futil.ReadDataFromPropertyFile("username");
		String PASSWORD = futil.ReadDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException {
		DashBoardPage db = new DashBoardPage(driver);
		
		db.logoutFromApplication(driver);
	}
//	@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.close();
		System.out.println("=========== browser is closed ====================");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("===============connection closed====================");
	}
}
