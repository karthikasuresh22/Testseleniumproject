package testngSamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WaitsInSelenium {
	WebDriver driver;
	
  @Test
  public void verifySearchFunctionalityByUsingClientName() {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys("carol");
	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
	  login.click();
	  WebElement clientButton=driver.findElement(By.xpath("//a[text()='Clients']"));
	  //implicit wait
	  //clientButton=new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Clients']")));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(clientButton));
	  clientButton.click();
	  WebElement clientNameSearch=driver.findElement(By.cssSelector("input#clientsearch-client_name"));
	  clientNameSearch.sendKeys("sam");
	  WebElement search=driver.findElement(By.xpath("//button[text()='Search']"));
	  search.click();
	  WebElement sam=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[1]//td[2]"));
	 // explicit wait
	  //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='table table-striped table-bordered']//tr[1]//td[2]")));
	 // wait.until(ExpectedConditions.visibilityOf(sam));
	  //fluent wait
	  Wait<WebDriver> fwait=new  FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
			  .pollingEvery(Duration.ofSeconds(1))
			  .ignoring(NoSuchElementException.class);
	  fwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='table table-striped table-bordered']//tr[1]//td[2]")));
	  
	  Boolean actual=sam.isDisplayed();
	  Assert.assertTrue(actual);
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://qabible.in/payrollapp/");
	  driver.manage().window().maximize();
	 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
