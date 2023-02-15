package testngSamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class KeybordAndMouseHandling {
	WebDriver driver;
  @Test
  public void verifyEnteredMessage() {
	  WebElement enterMessageBox=driver.findElement(By.xpath("//input[@id='single-input-field']"));

	  Actions action=new Actions(driver);

	  action.keyDown(Keys.SHIFT).build().perform();
	  enterMessageBox.sendKeys("hii");
	  action.keyUp(Keys.SHIFT).build().perform();

	  action.keyDown(Keys.TAB).build().perform(); //tab press
	  action.keyUp(Keys.TAB).build().perform();

	  action.keyDown(Keys.ENTER).build().perform(); //enter press
	  action.keyUp(Keys.ENTER).build().perform();

	  //WebElement showMsgButn=driver.findElement(By.xpath("//button[@id='button-one']"));
	  //action.sendKeys(showMsgButn,Keys.ENTER).build().perform();  //click method using sendkeys(tab+enter effect)
	  
	  WebElement msg=driver.findElement(By.xpath("//div[@id='message-one']"));
	  Boolean actual=msg.isDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @Test
  public void mouseHandling() {
	  WebElement home=driver.findElement(By.xpath("//a[text()='Home']"));
	  Actions action=new Actions(driver);
	  action.moveToElement(home).build().perform();
	  //action.contextClick(home).build().perform();
	  action.doubleClick(home).build().perform();
			  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
