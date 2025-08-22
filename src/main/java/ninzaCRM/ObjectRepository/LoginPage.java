package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "username") 
	private WebElement userNameTF;
	
	@FindBy(id = "inputPassword") 
	private WebElement passwordTF;
	
	@FindBy(xpath = "//button[.='Sign In']") 
	private WebElement signInBtn;
	
	public  LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}
	
	/**
	 * This method is used perform loginOperation
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username , String password) {
		userNameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		signInBtn.click();
	}
	
}
