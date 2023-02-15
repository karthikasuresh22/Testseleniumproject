package testngSamples;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class IframeHandling {
	WebDriver driver;
  @Test
  public void verifyTheCorrectWebPgeIsLoadingByClickingAnIframe() {
	  String parentWindow=driver.getWindowHandle();
	  
	  WebElement iframeAdd=driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView();", iframeAdd);
	  
	  //switching to iframe
	  driver.switchTo().frame(iframeAdd);
	  WebElement image=driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
	  image.click();
	  
	  
	  String expected="https://demo.guru99.com/test/guru99home/";
	  String actual=driver.getCurrentUrl();
	  Assert.assertEquals(actual, expected);
	  
	  //switch back to parent window
	  driver.switchTo().parentFrame();
	  //driver.switchTo().defaultContent();
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  driver.get("http://demo.guru99.com/test/guru99home/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
