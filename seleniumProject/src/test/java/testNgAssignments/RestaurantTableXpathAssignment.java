package testNgAssignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class RestaurantTableXpathAssignment {
	WebDriver driver;
  @Test(priority = 2)
  public void verifyAddFunctionalityByAddingNewProductToProductTab()  {
	  WebElement userName=driver.findElement(By.xpath("//input[@type='text']"));
	  userName.sendKeys("admin");
	  WebElement passWord=driver.findElement(By.xpath("//input[@type='password']"));
	  passWord.sendKeys("password");
	  WebElement submitButton=driver.findElement(By.xpath("//input[@name='submit']"));
	  submitButton.submit();

	  WebElement productTab=driver.findElement(By.xpath("//li[@class='flat-box waves-effect waves-block']/following-sibling::li[1]"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='flat-box waves-effect waves-block']/following-sibling::li[1]")));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  //js.executeScript("arguments[0].click();", productTab);
	  productTab.click();

	  WebElement addProductButton=driver.findElement(By.xpath("(//button[@type='button'])[2]"));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
	  js.executeScript("arguments[0].scrollIntoView();", addProductButton);
	  js.executeScript("arguments[0].click();", addProductButton);

	  WebElement typeDropDown=driver.findElement(By.xpath("//select[@id='Type']"));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='Type']")));
	  Select selectType=new Select(typeDropDown);
	  selectType.selectByIndex(1);

	  WebElement productCode=driver.findElement(By.xpath("//input[@id='ProductCode']"));
	  productCode.sendKeys("789");

	  WebElement productName=driver.findElement(By.xpath("//input[@id='ProductName']"));
	  productName.sendKeys("Special falooda");

	  WebElement categoryDropDown=driver.findElement(By.xpath("//select[@id='Category']"));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='Category']")));
	  Select selectCategory=new Select(categoryDropDown);
	  selectCategory.selectByValue("fruits");

	  WebElement productPrice=driver.findElement(By.xpath("//input[@id='Price']"));
	  productPrice.sendKeys("150");


	  WebElement submtBtn=driver.findElement(By.xpath("//button[@class='btn btn-add']"));
	  submtBtn.submit();

	  driver.navigate().refresh();
	  WebElement searchBox1=driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='form-control input-sm']")));
	  searchBox1.sendKeys("Special falooda");

	  WebElement productCodeSearch=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered dataTable no-footer']//tr[1]//td[1]"));
	  String expected="789";
	  String actual=productCodeSearch.getText();
	  Assert.assertEquals(actual, expected);
  }
  @Test(priority = 1)
  public void verifyTheEditFunctionalityOfAddedProduct() {
	  WebElement userName=driver.findElement(By.xpath("//input[@type='text']"));
	  userName.sendKeys("admin");
	  WebElement passWord=driver.findElement(By.xpath("//input[@type='password']"));
	  passWord.sendKeys("password");
	  WebElement submitButton=driver.findElement(By.xpath("//input[@name='submit']"));
	  submitButton.submit();

	  WebElement productTab=driver.findElement(By.xpath("//li[@class='flat-box waves-effect waves-block']/following-sibling::li[1]"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='flat-box waves-effect waves-block']/following-sibling::li[1]")));
	  //JavascriptExecutor js=(JavascriptExecutor)driver;
	  //js.executeScript("arguments[0].click();", productTab);
	  productTab.click();

	  WebElement searchTab1=driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
	  searchTab1.sendKeys("Special falooda");

	  WebElement editbtn=driver.findElement(By.xpath("//a[@class='btn btn-default']/following-sibling::a[2]"));
	  editbtn.click();

	  WebElement taxTab=driver.findElement(By.xpath("//input[@id='Tax']"));
	  taxTab.clear();
	  taxTab.sendKeys("15%");

	  WebElement submitbtn3=driver.findElement(By.xpath("//button[@class='btn btn-green col-md-6 flat-box-btn waves-effect waves-button']"));
	  submitbtn3.submit();

	  WebElement searchTab3=driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
	  searchTab3.sendKeys("Special falooda");

	  WebElement productDetails=driver.findElement(By.xpath("//table[@id='Table']//tbody//tr[1]"));
	  System.out.println(productDetails.getText());

	  WebElement productCodeSrch=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered dataTable no-footer']//tr[1]//td[1]"));
	  Boolean actual=productCodeSrch.isDisplayed();
	  Assert.assertTrue(actual);

  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  driver.get("https://qalegend.com/restaurant/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
