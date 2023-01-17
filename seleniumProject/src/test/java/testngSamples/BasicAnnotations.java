package testngSamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BasicAnnotations {
	WebDriver driver;
  @Test
  public void isLogoVisibleOrNot() {
	 WebElement logo=driver.findElement(By.xpath("(//img[@src='images/logo.png'])[1]"));
	 System.out.println(logo.isDisplayed());
  }
  @Test
  public void verifyTitle() {
	 System.out.println(driver.getTitle());
  }
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
  
 /* @BeforeClass
  public void beforeClass() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }*/
 
}
