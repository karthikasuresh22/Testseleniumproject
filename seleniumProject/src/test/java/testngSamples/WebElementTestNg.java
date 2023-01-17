package testngSamples;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WebElementTestNg {
	WebDriver driver;
	  WebElement inputForm;
  @Test
  public void inputForm() {
	  inputForm=driver.findElement(By.xpath("(//a[@class='nav-link'])[2]"));
	  inputForm.click();
	  WebElement messageTextBox=driver.findElement(By.xpath("//input[@id='single-input-field']"));
	  messageTextBox.sendKeys("hii");
	  WebElement showButtonMessage=driver.findElement(By.xpath("//button[@id='button-one']"));
	  showButtonMessage.click();
	  WebElement yourMessageText=driver.findElement(By.xpath("//div[@id='message-one']"));
	 // System.out.println(yourMessageText.getText());
	  String expectedMsg="Your Message : hii";
	  String actualMsg=yourMessageText.getText();
	  Assert.assertEquals(actualMsg,expectedMsg );
	 /* SoftAssert softAssert=new SoftAssert();
	  softAssert.assertEquals(actualMsg,expectedMsg );
	  softAssert.assertAll();*/
	  
	 
	  
			
  }
  
  @Test
  public void checkBoxISSelectedOrNot() {
	  inputForm=driver.findElement(By.xpath("(//a[@class='nav-link'])[2]"));
	  inputForm.click();
	  WebElement checkBoxDemo=driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
	  checkBoxDemo.click();
	  WebElement checkBox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
	  checkBox.click();
	  System.out.println(checkBox.isSelected());

		
  }
 /* @Test
  public void showButtonMessage() {
	  WebElement showButtonMessage=driver.findElement(By.xpath("//button[@id='button-one']"));
		showButtonMessage.click();
  }
  @Test
  public void gettingText() {
		WebElement yourMessageText=driver.findElement(By.xpath("//div[@id='message-one']"));
		System.out.println(yourMessageText.getText());
  }
  @Test
  public void checkBoxDemo() {
		WebElement checkBoxDemo=driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
		checkBoxDemo.click();
  }
  @Test
  public void checkBox() {
	  WebElement checkBox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
		checkBox.click();
		System.out.println(checkBox.isSelected());
  }*/
  @BeforeMethod
  public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  

}
