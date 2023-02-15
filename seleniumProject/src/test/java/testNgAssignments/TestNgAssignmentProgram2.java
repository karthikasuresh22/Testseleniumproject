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
import org.testng.annotations.AfterMethod;

public class TestNgAssignmentProgram2 {
	WebDriver driver;
  @Test
  public void alertHandlingAndPrintingMessageInConsole() {
	  WebElement alertsAndModels=driver.findElement(By.xpath("(//a[@class='nav-link'])[6]"));
	  alertsAndModels.click();
	  WebElement javascriptAlertButton=driver.findElement(By.xpath("//a[text()='Javascript Alert']"));
	  javascriptAlertButton.click();
	  WebElement clickMeButton=driver.findElement(By.xpath("//button[text()='Click me!']"));
	  clickMeButton.click();
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.alertIsPresent());
	  System.out.println(driver.switchTo().alert().getText());
	  driver.switchTo().alert().accept();
	 
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get(" https://selenium.obsqurazone.com/index.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
