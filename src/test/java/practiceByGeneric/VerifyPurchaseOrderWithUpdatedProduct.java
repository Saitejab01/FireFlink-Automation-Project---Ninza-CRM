package practiceByGeneric;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ninzaCRM.ObjectRepository.CampaignsPage;
import ninzaCRM.ObjectRepository.DashBoardPage;
import ninzaCRM.ObjectRepository.LoginPage;

import ninzaCRM.genericUtilities.WebDriverUtility;

public class VerifyPurchaseOrderWithUpdatedProduct {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NinzaCRM.AutomationFrameWork\\src\\test\\resources\\commonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String url = pobj.getProperty("url");
		String browser = pobj.getProperty("browser");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		
		FileInputStream fisT = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NinzaCRM.AutomationFrameWork\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fisT);
		Sheet sh = wb.getSheet("Sheet1");
		Row r= sh.getRow(4);
		String Subject = r.getCell(2).toString();
		String DueDate = r.getCell(3).toString();
		String Contact = r.getCell(4).toString();
		String BillingAddress = r.getCell(5).toString();
		String BillingPoBox = r.getCell(6).toString();
		String BillingCity = r.getCell(7).toString();
		String BillingState = r.getCell(8).toString();
		String BillingPostalCode = r.getCell(9).toString();
		String BillingCountry = r.getCell(10).toString();
		String ShippingAddress = r.getCell(11).toString();
		String ShippingPoBox = r.getCell(12).toString();
		String City = r.getCell(13).toString();
		String State = r.getCell(14).toString();
		String PostalCode = r.getCell(15).toString();
		String Country = r.getCell(16).toString();
		String AddProducts = r.getCell(17).toString();
		String productname = r.getCell(18).toString();
		String ProductPrice =r.getCell(19).toString();
		wb.close();
		WebDriver driver;
		switch(browser) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		default : driver=new EdgeDriver();
		}
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.maximizeWindow(driver);
		wutil.provideImplicitlyWait(driver);
		driver.get(url);
		String mainWindow = driver.getWindowHandle();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		DashBoardPage Db = new DashBoardPage(driver);
		Db.getCampaignsL().click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB,Keys.TAB,Subject,Keys.TAB,DueDate).perform();
		driver.findElement(By.xpath("//div[contains(@class,'form-container')]/div/div/div/button")).click();
		 Set<String> windows = driver.getWindowHandles();
		 for(String window:windows) {
				if (!window.equals(mainWindow)) {
					driver.switchTo().window(window);
					driver.findElement(By.xpath("//td[.='"+Contact+"']/following-sibling::td//button[.='Select']")).click();
					driver.switchTo().window(mainWindow);
				}
			}
		 act.sendKeys(Keys.TAB,BillingAddress,Keys.TAB,BillingPoBox,Keys.TAB,BillingCity,Keys.TAB,BillingState,Keys.TAB,BillingPostalCode,Keys.TAB,BillingCountry,Keys.TAB,ShippingAddress,Keys.TAB,ShippingPoBox,Keys.TAB,City,Keys.TAB,State,Keys.TAB,PostalCode,Keys.TAB,Country,Keys.TAB,Keys.ENTER).perform();
		 windows = driver.getWindowHandles();
		 for(String window:windows) {
				if (!window.equals(mainWindow)) {
					driver.switchTo().window(window);
					Select dd3 = new Select(driver.findElement(By.id("search-criteria")));
					dd3.selectByIndex(1);
					driver.findElement(By.id("search-input")).sendKeys(AddProducts);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//td[.='"+AddProducts+"']/following-sibling::td//button[.='Select']")).click();
					driver.switchTo().window(mainWindow);
				}
			}
		 driver.findElement(By.xpath("//button[.='Create Purchase Order']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[.='Products']")).click();
		 Select dd4 =new Select(driver.findElement(By.className("form-control")));
		 dd4.selectByIndex(1);
		 driver.findElement(By.xpath("//input[@placeholder='Search by product Name']")).sendKeys(productname);
		 driver.findElement(By.xpath("//i[@title='Edit']")).click();
		 String actualPrice = driver.findElement(By.xpath("//input[@name='price']")).getAttribute("value");
		 System.out.println(actualPrice);
		 driver.findElement(By.xpath("//input[@name='price']")).clear();
		 act.sendKeys(driver.findElement(By.xpath("//input[@name='price']")),ProductPrice).perform();
		 act.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER).perform();
		 if (!actualPrice.equals(ProductPrice)) {
			System.out.println("its same");
		}else {
			System.out.println("its not same");
		}
		 Thread.sleep(6000);
		 act.moveToElement(driver.findElement(By.xpath("//div[@class='user-icon']"))).perform();
		 driver.findElement(By.xpath("//div[contains(text(),'Logout ')]")).click();
		 driver.quit();
		 
		 
	}
}
