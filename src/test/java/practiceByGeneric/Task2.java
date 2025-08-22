package practiceByGeneric;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
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

import ninzaCRM.genericUtilities.FileUtility;
import ninzaCRM.genericUtilities.WebDriverUtility;

public class Task2 {

	public static void main(String[] args) throws Throwable{
		FileUtility fu = new FileUtility();
		String url = fu.ReadDataFromPropertyFile("url");
		String browser = fu.ReadDataFromPropertyFile("browser");
		String username = fu.ReadDataFromPropertyFile("username");
		String password = fu.ReadDataFromPropertyFile("password");
		
		FileInputStream fisT = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NinzaCRM.AutomationFrameWork\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fisT);
		Sheet sh = wb.getSheet("Sheet1");
		Row r= sh.getRow(19);
		
		String subject =fu.ReadDataFromExcelFile("Sheet1", 19, 2);
		String validTill= fu.ReadDataFromExcelFile("Sheet1", 19, 3);
		String contactName = fu.ReadDataFromExcelFile("Sheet1", 19, 4);
		String salesOrder = fu.ReadDataFromExcelFile("Sheet1", 19, 5);
		String DueDate = fu.ReadDataFromExcelFile("Sheet1", 19, 6);
		String BillingAddress = fu.ReadDataFromExcelFile("Sheet1", 19, 7);
		String BillingPoBox = fu.ReadDataFromExcelFile("Sheet1", 19, 8);
		String BillingCity = fu.ReadDataFromExcelFile("Sheet1", 19, 9);
		String BillingState = fu.ReadDataFromExcelFile("Sheet1", 19, 10);
		String BillingPostelCode = fu.ReadDataFromExcelFile("Sheet1", 19, 11);
		String BillingCountry = fu.ReadDataFromExcelFile("Sheet1", 19, 12);
		String ShippingAddress = fu.ReadDataFromExcelFile("Sheet1", 19, 13);
		String ShippingPoBox = fu.ReadDataFromExcelFile("Sheet1", 19, 14);
		String city = fu.ReadDataFromExcelFile("Sheet1", 19, 15);
		String state = fu.ReadDataFromExcelFile("Sheet1", 19, 16);
		String postelCode = fu.ReadDataFromExcelFile("Sheet1", 19, 17);
		String Country = fu.ReadDataFromExcelFile("Sheet1", 19, 18);
		String AddProducts = fu.ReadDataFromExcelFile("Sheet1", 19, 19);
		String SearchProductId = fu.ReadDataFromExcelFile("Sheet1", 19, 20);
		String updatePrice= fu.ReadDataFromExcelFile("Sheet1", 19, 21);
		WebDriver driver;
		switch(browser) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		default : driver=new EdgeDriver();
		}
		WebDriverUtility wbu = new WebDriverUtility();
		wbu.maximizeWindow(driver);
		wbu.provideImplicitlyWait(driver);
		Actions act = new Actions(driver);
		driver.get(url);
		wbu.toPerformSendKeysOperation(driver.findElement(By.id("username")), username);
		wbu.toPerformSendKeysOperation(driver.findElement(By.id("inputPassword")), password);
		wbu.toPerformClickOperation(driver.findElement(By.xpath("//button[text()='Sign In']")));
		wbu.provideExplicitlyWaitForElementToBeClickable(driver, driver.findElement(By.xpath("//a[text()='Invoice']")));
		wbu.toPerformClickOperation(driver.findElement(By.xpath("//span[text()='Create Invoice']")));
		wbu.toPerformClickOperation(driver.findElement(By.xpath("//input[@name='subject']")));
		act.sendKeys(subject,Keys.TAB,Keys.TAB,validTill).perform();

		driver.findElement(By.xpath("(//button[@class='action-button'])[1]")).click();

		String window=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();

		for(String win:windows) {
			if(!win.equals(window)) {

				driver.switchTo().window(win);
				driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(contactName);
				driver.findElement(By.xpath("//button[@class='select-btn']")).click();
			}
		}

		driver.switchTo().window(window);

		driver.findElement(By.xpath("(//button[@class='action-button'])[2]")).click();	

		windows=driver.getWindowHandles();

		for(String win:windows) {
			if(!win.equals(window)) {

				driver.switchTo().window(win);
				driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(salesOrder);
				driver.findElement(By.xpath("//button[@class='select-btn']")).click();
			}
		}

		driver.switchTo().window(window);
		driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys(DueDate);
		Thread.sleep(2000);
		act.sendKeys(Keys.TAB,Keys.TAB, BillingAddress,Keys.TAB, BillingPoBox,Keys.TAB, BillingCity,Keys.TAB, BillingState,Keys.TAB,BillingPostelCode,Keys.TAB,BillingCountry,Keys.TAB,ShippingAddress,Keys.TAB,ShippingPoBox,Keys.TAB,city,Keys.TAB,state,Keys.TAB,postelCode,Keys.TAB,Country).perform();

		driver.findElement(By.xpath("//button[text()='Add Product']")).click();


		windows=driver.getWindowHandles();

		for(String win:windows) {
			if(!win.equals(window)) {

				driver.switchTo().window(win);
				driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(AddProducts);
				driver.findElement(By.xpath("//button[@class='select-btn']")).click();
			}
		}

		driver.switchTo().window(window);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Create Invoice']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search by product Id']")).sendKeys(SearchProductId);
		driver.findElement(By.xpath("//i[@title='Edit']")).click();
		WebElement ele= driver.findElement(By.xpath("//input[@name='price']"));
		Thread.sleep(2000);
		ele.sendKeys(Keys.CONTROL+"a");
		act.sendKeys(Keys.DELETE,updatePrice).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Update']")).click();

		String expectedResult = updatePrice;

		driver.findElement(By.xpath("//i[@title='Edit']")).click();
		WebElement ele1= driver.findElement(By.xpath("//input[@name='price']"));
		String result=  ele1.getAttribute("value");


		if(result.equals(expectedResult)) {
			System.out.println("TestCase is passed");

		}
		else {
			System.out.println("TestCase is not passed");
		}	      

		 act.moveToElement(driver.findElement(By.xpath("//div[@class='user-icon']"))).perform();
		 driver.findElement(By.xpath("//div[contains(text(),'Logout ')]")).click();
		 driver.quit();
	}

}

