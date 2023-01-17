package testngSamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NavigationCommandsTestng {
	WebDriver driver;
  @Test
  public void navigateToGroceryApp() {
	  driver.navigate().to("http://groceryapp.uniqassosiates.com/admin/login");
  }
  @Test
  public void goingBack() {
		driver.navigate().back();
  }
  @Test
  public void goingToForward() {
	  driver.navigate().forward();
  }
  @Test
  public void refersh() {
		driver.navigate().refresh();
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

}
