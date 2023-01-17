package testngSamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrowserCommandsTestng {
	WebDriver driver;
  @Test
  public void gettingTitle() {
	  System.out.println(driver.getTitle());

	  
  }
  @Test
  public void gettingUrl() {
	  System.out.println(driver.getCurrentUrl());
	  
  }
 
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
		//Thread.sleep(2000);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();

  }

}
