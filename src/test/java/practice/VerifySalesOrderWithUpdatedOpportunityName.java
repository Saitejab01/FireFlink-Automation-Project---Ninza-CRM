package practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
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
import org.openqa.selenium.support.ui.Select;

public class VerifySalesOrderWithUpdatedOpportunityName {
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
		Row r= sh.getRow(10);
		String Subject = r.getCell(2).toString();
		String ValidTill = r.getCell(3).toString();
		String status = r.getCell(4).toString();
		String Opportunity = r.getCell(5).toString();
		String Quote = r.getCell(6).toString();
		String Contact = r.getCell(7).toString();
		String BillingAddress = r.getCell(8).toString();
		String BillingPoBox = r.getCell(9).toString();
		String BillingCity = r.getCell(10).toString();
		String BillingState = r.getCell(11).toString();
		String BillingPostalCode = r.getCell(12).toString();
		String BillingCountry = r.getCell(13).toString();
		String ShippingAddress = r.getCell(14).toString();
		String ShippingPoBox = r.getCell(15).toString();
		String City = r.getCell(16).toString();
		String State = r.getCell(17).toString();
		String PostalCode = r.getCell(18).toString();
		String Country = r.getCell(19).toString();
		String ProductID = r.getCell(20).toString();
		String OpportunityName = r.getCell(21).toString();
		String SalesSubject = r.getCell(22).toString();
		wb.close();
		WebDriver driver;
		switch(browser) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		default : driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[.='Sign In']")).click();
		driver.findElement(By.xpath("//a[.='Sales Order']")).click();
		WebElement createOrder = driver.findElement(By.xpath("//BUTTON[.=' Create Order']"));
		createOrder.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB,Keys.TAB,Subject,Keys.TAB,ValidTill,Keys.TAB,Keys.TAB,status).perform();
		List<WebElement> pluses = driver.findElements(By.xpath("//*[@data-icon='plus']"));
		int a = 0;
		for (WebElement plus : pluses) {
				plus.click();
				Set<String> childWindows = driver.getWindowHandles();
				for (String child : childWindows) {
					if (!child.equals(mainWindow)) {
						if (a==0) {
							driver.switchTo().window(child);
							Select dd1 = new Select(driver.findElement(By.id("search-criteria")));
							dd1.selectByIndex(1);
							driver.findElement(By.id("search-input")).sendKeys(Opportunity);
							driver.findElement(By.xpath("//td[.='"+Opportunity+"']/following-sibling::td/child::button")).click();
							driver.switchTo().window(mainWindow);
						}else if(a==1) {
							driver.switchTo().window(child);
							Select dd1 = new Select(driver.findElement(By.id("search-field")));
							dd1.selectByIndex(0);
							driver.findElement(By.id("search-input")).sendKeys(Quote);
							driver.findElement(By.xpath("//td[.='"+Quote+"']/following-sibling::td/child::button")).click();
							driver.switchTo().window(mainWindow);
						}else if(a==2){
							driver.switchTo().window(child);
							Select dd1 = new Select(driver.findElement(By.id("search-criteria")));
							dd1.selectByIndex(1);
							driver.findElement(By.id("search-input")).sendKeys(Contact);
							Thread.sleep(5000);
							driver.findElement(By.xpath("//td[.='"+Contact+"']/following-sibling::td/child::button")).click();
							driver.switchTo().window(mainWindow);
							 act.sendKeys(Keys.TAB,BillingAddress,Keys.TAB,BillingPoBox,Keys.TAB,BillingCity,Keys.TAB,BillingState,Keys.TAB,BillingPostalCode,Keys.TAB,BillingCountry,Keys.TAB,ShippingAddress,Keys.TAB,ShippingPoBox,Keys.TAB,City,Keys.TAB,State,Keys.TAB,PostalCode,Keys.TAB,Country,Keys.TAB,Keys.ENTER).perform();
						}else {
							driver.switchTo().window(child);
							Select dd3 = new Select(driver.findElement(By.id("search-criteria")));
							dd3.selectByIndex(1);
							driver.findElement(By.id("search-input")).sendKeys(ProductID);
							Thread.sleep(2000);
							driver.findElement(By.xpath("//td[.='"+ProductID+"']/following-sibling::td//button[.='Select']")).click();
							driver.switchTo().window(mainWindow);
						}
						a++;
					}
				}
			}
		 driver.findElement(By.xpath("//button[.='Create Sales Order']")).click();
		 Thread.sleep(6000);
		 driver.findElement(By.xpath("//a[.='Opportunities']")).click();
		 driver.findElement(By.xpath("//input[@placeholder='Search by Opportunity Id']")).sendKeys(Opportunity);
		 driver.findElement(By.xpath("//i[@title='Edit']")).click();
		 driver.findElement(By.name("opportunityName")).clear();
		 driver.findElement(By.name("opportunityName")).sendKeys(OpportunityName);
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 Thread.sleep(6000);
		 driver.findElement(By.xpath("//a[.='Sales Order']")).click();
		 Select dd2 = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		 dd2.selectByIndex(1);
		 System.out.println(SalesSubject);
		 driver.findElement(By.xpath("//input[@placeholder='Search by Subject']")).sendKeys(SalesSubject);
		 driver.findElement(By.xpath("//i[@title='Edit']")).click();
		 String actualName=driver.findElement(By.xpath("//label[contains(text(),'Opportunity')]/following-sibling::div/child::input")).getAttribute("value");
		 if (actualName.equals(OpportunityName)) {
			System.out.println("updated");
		}else {
			System.out.println("not updated");
			
		}
		 act.moveToElement(driver.findElement(By.xpath("//div[@class='user-icon']"))).perform();
		 driver.findElement(By.xpath("//div[contains(text(),'Logout ')]")).click();
		 driver.quit();
	}
}
