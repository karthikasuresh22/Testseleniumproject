package testngSamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TableXpath {
	WebDriver driver;
  @Test(priority = 0)
  public void verifySearchFunctionalityByUsingClientName() {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys("carol");
	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
	  login.click();
	  WebElement clientButton=driver.findElement(By.xpath("//a[text()='Clients']"));
	  clientButton.click();
	  WebElement clientNameSearch=driver.findElement(By.cssSelector("input#clientsearch-client_name"));
	  clientNameSearch.sendKeys("sam");
	  WebElement search=driver.findElement(By.xpath("//button[text()='Search']"));
	  search.click();
	  WebElement sam=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[1]//td[2]"));
	  Boolean actual=sam.isDisplayed();
	  Assert.assertTrue(actual);
	  	 
  }
  @Test(priority = 1)
  public void verifySearchFunctionality() {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys("carol");
	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
	  login.click();
	  WebElement clientButton=driver.findElement(By.xpath("//a[text()='Clients']"));
	 // clientButton.click();
	  driver.navigate().to("https://qabible.in/payrollapp/client/index");
	  WebElement clientNameSearch=driver.findElement(By.cssSelector("input#clientsearch-client_name"));
	  clientNameSearch.sendKeys("Heather View");
	  WebElement search=driver.findElement(By.xpath("//button[text()='Search']"));
	  search.click();
	  WebElement heatherView =driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[1]//td[2]"));
	  Boolean  actual=heatherView.isDisplayed();
	  Assert.assertTrue(actual);
	
  }
  @Test
  public void clientDetailsOfTom() {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys("carol");
	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
	  login.click();
	  WebElement clientButton=driver.findElement(By.xpath("//a[text()='Clients']"));
	  // clientButton.click();
	  driver.navigate().to("https://qabible.in/payrollapp/client/index");
	  WebElement clientNameSearch=driver.findElement(By.cssSelector("input#clientsearch-client_name"));
	 // clientNameSearch.click();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].click();", clientNameSearch);
	  WebElement tom=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[12]"));
	  //JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", tom);
	  // System.out.println(tom.getText());
	  Boolean actual=tom.isDisplayed();
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
