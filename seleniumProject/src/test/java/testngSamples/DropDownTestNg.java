package testngSamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DropDownTestNg {
	WebDriver driver;
  @Test
  public void selectRedColourFromTheColourDropDown() {
		WebElement selectColourDropDown=driver.findElement(By.xpath("//select[@id='single-input-field']"));
		selectColourDropDown.click();
		Select select=new Select(selectColourDropDown);
		select.selectByValue("Red");
		WebElement msg=driver.findElement(By.id("message-one"));
		//System.out.println(msg.getText());
		//String expectedText="Selected Color : Red";
		//String actualText=msg.getText();
		//Assert.assertEquals(actualText,expectedText);
		Boolean  actualText=msg.isDisplayed();
		Assert.assertTrue(actualText);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  	driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/select-input.php");
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();

  }

}
