package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	//Campaigns
	@FindBy(xpath = "//a[.='Campaigns']") private WebElement CampaignsL;
	//Contacts
	@FindBy(xpath = "//a[.='Contacts']") private WebElement ContactsL;
	//	Leads
	@FindBy(xpath = "//a[.='Leads']") private WebElement LeadsL;
	//	Opportunities
	@FindBy(xpath = "//a[.='Opportunities']") private WebElement OpportunitiesL;
	//	Products
	@FindBy(xpath = "//a[.='Products']") private WebElement ProductsL;
	//	Quotes
	@FindBy(xpath = "//a[.='Quotes']") private WebElement QuotesL;
	//	Purchase Order
	@FindBy(xpath = "//a[.='Purchase Order']") private WebElement PurchaseOrderL;
	//	Sales Order
	@FindBy(xpath = "//a[.='Sales Order']") private WebElement SalesOrderL;
	//	Invoice
	@FindBy(xpath = "//a[.='Invoice']") private WebElement InvoiceL;
	//	Admin Console
	@FindBy(xpath = "//a[.='Admin Console']") private WebElement AdminConsoleL;
	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getCampaignsL() {
		return CampaignsL;
	}
	public CampaignsPage getCampaignsPage(WebDriver driver) {
		return new CampaignsPage(driver);
	}
	public WebElement getContactsL() {
		return ContactsL;
	}
	public WebElement getLeadsL() {
		return LeadsL;
	}
	public WebElement getOpportunitiesL() {
		return OpportunitiesL;
	}
	public WebElement getProductsL() {
		return ProductsL;
	}
	public WebElement getQuotesL() {
		return QuotesL;
	}
	public WebElement getPurchaseOrderL() {
		return PurchaseOrderL;
	}
	public WebElement getSalesOrderL() {
		return SalesOrderL;
	}
	public WebElement getInvoiceL() {
		return InvoiceL;
	}
	public WebElement getAdminConsoleL() {
		return AdminConsoleL;
	}
	public void logoutFromApplication(WebDriver driver) throws InterruptedException {
		Thread.sleep(6000);
		Actions act = new Actions(driver);
		 act.moveToElement(driver.findElement(By.xpath("//div[@class='user-icon']"))).perform();
		 driver.findElement(By.xpath("//div[contains(text(),'Logout ')]")).click();
	}
}
