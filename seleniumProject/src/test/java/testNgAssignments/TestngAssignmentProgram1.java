package testNgAssignments;

import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestngAssignmentProgram1 {
	WebDriver driver;
  @Test(priority =2 )
  public void verifyingTheDetailsOfTigerNixonAndPrintingDeails() {
	  WebElement tableTab=driver.findElement(By.xpath("( //a[@class='nav-link'])[4]"));
	  tableTab.click();
	  WebElement tigerNixon=driver.findElement(By.xpath("//table[@id='dtBasicExample']//tr[@class='odd']"));
	  System.out.println(tigerNixon.getText());
	  Boolean actual=tigerNixon.isDisplayed();
	  Assert.assertTrue(actual);
  }
  @Test(priority = 1)
  public void vertifyingTheNameDaiRiosIsVisibleOrNot() throws InterruptedException {
	  WebElement tableTab=driver.findElement(By.xpath("( //a[@class='nav-link'])[4]"));
	  tableTab.click();
	  WebElement tabaleSortAndSearchButton=driver.findElement(By.xpath("//a[text()='Table Sort And Search']"));
	  tabaleSortAndSearchButton.click();
	  WebElement searchButton=driver.findElement(By.xpath("//input[@type='search']"));
	  searchButton.sendKeys("Dai Rios");
	  WebElement daiRiosName=driver.findElement(By.xpath("//table[@id='dtBasicExample']//tr[1]//td[1]"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='dtBasicExample']//tr[1]//td[1]")));
	  Boolean actual=daiRiosName.isDisplayed();
	  Assert.assertTrue(actual);

  }
  @Test(priority = 3)
  public void verifyingHommeTabIsVisibleOrNot() {
	  WebElement homeTab=driver.findElement(By.xpath("(//a[@class='nav-link'])[1]"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='nav-link'])[1]")));
	  Boolean actual=homeTab.isDisplayed();
	  Assert.assertTrue(actual);

	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get(" https://selenium.obsqurazone.com/index.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
