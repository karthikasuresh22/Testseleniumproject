package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	 
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signInButton;
	
	@FindBy(xpath="//b[text()='7rmart supermarket']")
	WebElement title7rmartSuperMarket;
	
	@FindBy(xpath="//li[@class='nav-item dropdown']")
	WebElement adminName;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMsg;
	
	@FindBy(xpath="//label[@for='remember']")
	WebElement rememberMeCheckBox;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterUserName(String usrName) {
		userName.sendKeys(usrName);
		
	}
	
	public void enterPassword(String pswd) {
		password.sendKeys(pswd);
	}
	
	public void clickOnSignInButton() {
		signInButton.click();
	}
	
	public Boolean is7rmartSuperMarketDisplyaed() {
		return title7rmartSuperMarket.isDisplayed();
	}
	
	public String getTextOf7rmartSuperMarket() {
		return title7rmartSuperMarket.getText();
	}
	
	public Boolean isAdminNameDisplayed() {
		return adminName.isDisplayed();
	}
	 
	public Boolean isAlertMsgDisplayed() {
		return alertMsg.isDisplayed();
	}
	 
	public Boolean isRemenberMeCheckBoxIsSelectedByDefault() {
		return rememberMeCheckBox.isSelected();
	}
	
	

}
