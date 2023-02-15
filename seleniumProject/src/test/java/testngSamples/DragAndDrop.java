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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DragAndDrop {
	WebDriver driver;
  @Test
  public void dragAndDrop() {
	  WebElement sourceAmount=driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
	  WebElement targetDebit=driver.findElement(By.xpath("//ol[@id='amt7']"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView();", targetDebit);
	  Actions action=new Actions(driver);
	  action.dragAndDrop(sourceAmount, targetDebit).build().perform();

	  WebElement verifyText=driver.findElement(By.xpath("//table[@align='center']//tbody//tr//td[2]"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

	  js.executeScript("arguments[0].scrollIntoView();", verifyText);
	  String expected="5000";
	  String actual=verifyText.getText();
	  Assert.assertEquals(actual, expected);
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://demo.guru99.com/test/drag_drop.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
