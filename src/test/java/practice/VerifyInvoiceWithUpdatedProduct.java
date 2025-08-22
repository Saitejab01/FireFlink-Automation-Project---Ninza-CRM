package practice;

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

public class VerifyInvoiceWithUpdatedProduct {

	public static void main(String[] args) throws Throwable{

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
		Row r= sh.getRow(19);
		String subject = r.getCell(1).toString();
		String validTill= r.getCell(2).toString();
		String contactName = r.getCell(3).toString();
		String salesOrder = r.getCell(4).toString();
		String DueDate = r.getCell(5).toString();
		String BillingAddress = r.getCell(6).toString();
		String BillingPoBox = r.getCell(7).toString();
		String BillingCity = r.getCell(8).toString();
		String BillingState = r.getCell(9).toString();
		String BillingPostelCode = r.getCell(10).toString();
		String BillingCountry = r.getCell(11).toString();
		String ShippingAddress = r.getCell(12).toString();
		String ShippingPoBox = r.getCell(13).toString();
		String city = r.getCell(14).toString();
		String state = r.getCell(15).toString();
		String postelCode = r.getCell(16).toString();
		String Country = r.getCell(17).toString();
		String AddProducts = r.getCell(18).toString();
		String SearchProductId = r.getCell(19).toString();
		String updatePrice= r.getCell(20).toString();
		WebDriver driver;
		switch(browser) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		default : driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions act = new Actions(driver);

		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(4000);




		driver.findElement(By.xpath("//a[text()='Invoice']")).click();
		driver.findElement(By.xpath("//span[text()='Create Invoice']")).click();


		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@name='subject']")).click();

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

		Set<String> windows1=driver.getWindowHandles();

		for(String win:windows1) {
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


		Set<String> windows3=driver.getWindowHandles();

		for(String win:windows3) {
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
