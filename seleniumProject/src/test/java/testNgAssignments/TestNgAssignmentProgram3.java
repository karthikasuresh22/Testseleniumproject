package testNgAssignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestNgAssignmentProgram3 {
	WebDriver driver;
	
  @Test(priority = 1)
  public void verifyingSuccesfullLogin() {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys("carol");
	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(login));
	  login.click();
	  WebElement carolThomasName=driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
	  String expected="CAROL THOMAS";
	  String actual=carolThomasName.getText();
	  //Boolean actual=carolThomasName.isDisplayed();
	  //Assert.assertTrue(actual);
	  Assert.assertEquals(actual,expected);
  }
  @Test(priority = 3)
  public void verificationOfUnsuccessfullLogin() {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys("karthika");
	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys("12345");
	  WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(login));
	  login.click();
	  WebElement message=driver.findElement(By.xpath("//p[text()='Incorrect username or password.']"));
	  Boolean actual=message.isDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @Test(priority = 4)
  public void verificationOfDashBoardPageAfterLogin() {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys("carol");
	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(login));
	  login.click();
	  WebElement welcomeMessage=driver.findElement(By.xpath("//p[text()='Welcome to Payroll Application']"));
	  String expected="Welcome to Payroll Application";
	  String actual=welcomeMessage.getText();
	  Assert.assertEquals(actual, expected);	  
  }
  @Test(priority = 2)
  public void verifyTheCreationOfNewClient() throws InterruptedException {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys("carol");
	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(login));
	  login.click();
	  WebElement clientsButon=driver.findElement(By.xpath("//a[text()='Clients']"));
	  // WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(clientsButon));
	  clientsButon.click();
	  WebElement createclientButton=driver.findElement(By.xpath("//a[text()='Create Client']"));
	  wait.until(ExpectedConditions.elementToBeClickable(createclientButton));
	  createclientButton.click();
	  WebElement branchTab=driver.findElement(By.xpath("//select[@id='client-branch_id']"));
	  Select selectBranchTab=new Select(branchTab);
	  selectBranchTab.selectByVisibleText("Alpha_new");
	  WebElement divisionButton=driver.findElement(By.xpath("//select[@id='client-division_id']"));
	  //System.out.println(divisionButton.getText());
	  Select selectVisibleButton=new Select(divisionButton);
	  selectVisibleButton.selectByVisibleText("NewAlpha");
	  // select.selectByIndex(1);
	  WebElement clientName=driver.findElement(By.xpath("//input[@id='client-client_name']"));
	  clientName.sendKeys("karthika");
	  WebElement clientAddress=driver.findElement(By.xpath("//textarea[@id='client-client_address']"));
	  clientAddress.sendKeys("poovathinkal house");
	  WebElement pinNumber=driver.findElement(By.id("client-postcode"));
	  pinNumber.sendKeys("685582");
	  WebElement invoiceContact=driver.findElement(By.xpath("//input[@id='client-invoice_contact']"));
	  invoiceContact.sendKeys("8861231434");
	  WebElement phoneNumber=driver.findElement(By.xpath("//input[@id='client-phone']"));
	  phoneNumber.sendKeys("9495866070");
	  WebElement emailAddress=driver.findElement(By.xpath("//input[@id='client-email']"));
	  emailAddress.sendKeys("karthikasuresh22.94@gmail.com");
	  WebElement companyReg=driver.findElement(By.xpath("//input[@id='client-company_reg']"));
	  companyReg.sendKeys("obsqura123456");
	  WebElement invoiceOrder=driver.findElement(By.xpath("//select[@id='client-invoice_order']"));
	  Select selectInvoiceOrder=new Select(invoiceOrder);
	  // select1.selectByVisibleText("Invoice per Worker");
	  selectInvoiceOrder.selectByIndex(3);
	  WebElement invoiceDeliveryMethod=driver.findElement(By.xpath("//select[@id='client-invoice_delivery_method']"));
	  Select selectInvoiceDeliveryMethod=new Select(invoiceDeliveryMethod);
	  selectInvoiceDeliveryMethod.selectByIndex(1);
	  WebElement masterDocument=driver.findElement(By.xpath("//select[@id='client-master_document']"));
	  Select selectMasterDocument=new Select(masterDocument);
	  selectMasterDocument.selectByIndex(2);
	  WebElement settlementDays=driver.findElement(By.xpath("//input[@id='client-settilement_days']"));
	  settlementDays.sendKeys("30");
	  WebElement vatRate=driver.findElement(By.xpath("//select[@id='client-vat_rate']"));
	  Select selectVatRate=new Select(vatRate);
	  selectVatRate.selectByIndex(3);
	  WebElement saveButton=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
	  wait.until(ExpectedConditions.elementToBeClickable(saveButton));
	  saveButton.click();
	  WebElement karthikaName=driver.findElement(By.xpath("//table[@id='w0']//tr[3]//td[1]"));
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  WebElement upatedByTab=driver.findElement(By.xpath("//table[@id='w0']//tr[26]//td[1]"));
	  js.executeScript("arguments[0].scrollIntoView();",upatedByTab);
	  Boolean actual=karthikaName.isDisplayed();
	  Assert.assertTrue(actual);

  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://qabible.in/payrollapp/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
