package testngSamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class AlertHandling {
	WebDriver driver;
  @Test
  public void alertAccepting() throws InterruptedException {
	  WebElement customerId=driver.findElement(By.name("cusid"));
	 // WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	 // wait.until(ExpectedConditions.presenceOfElementLocated(By.name("cusid")));
	  customerId.sendKeys("12");
	  WebElement submit=driver.findElement(By.xpath("//input[@name='submit']"));
	  submit.click();
	  //Thread.sleep(2000);
	  driver.switchTo().alert().accept();
	  System.out.println(driver.switchTo().alert().getText());
	  driver.switchTo().alert().accept();
	  
  }
  @Test
  public void alertDismiss(){
	  WebElement customerId=driver.findElement(By.name("cusid"));
	  //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  //wait.until(ExpectedConditions.presenceOfElementLocated(By.name("cusid")));
	  customerId.sendKeys("12");
	  WebElement submit=driver.findElement(By.xpath("//input[@name='submit']"));
	  submit.click();
	  driver.switchTo().alert().dismiss();
	  //System.out.println(driver.switchTo().alert().getText());
	 // driver.switchTo().alert().accept();  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("http://demo.guru99.com/test/delete_customer.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
