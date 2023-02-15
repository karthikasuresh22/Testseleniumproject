package testngSamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DataProviderTestClassForLogin {
	WebDriver driver;
  @Test(dataProvider="successfullLogin",dataProviderClass=DataProviderForLogin.class)
  public void verificationOfSuccessfulLogin(String userName,String password)  {
	  WebElement admin=driver.findElement(By.xpath("//input[@name='username']"));
	  admin.clear();
	  admin.sendKeys(userName);

	  WebElement passwordBox=driver.findElement(By.xpath("//input[@name='password']"));
	  passwordBox.clear();
	  passwordBox.sendKeys(password);


	  WebElement signInButton=driver.findElement(By.xpath("//button[@type='submit']"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
	  signInButton.click();
	  driver.navigate().refresh();

	  WebElement adminTextName=driver.findElement(By.xpath("//li[@class='nav-item dropdown']"));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='nav-item dropdown']")));
	  Boolean actual=adminTextName.isDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @Test(dataProvider="unsuccessfullLogin",dataProviderClass=DataProviderForLogin.class)
  public void verificationOfUnSuccessfulLogin(String userName,String password) {
	  WebElement admin=driver.findElement(By.xpath("//input[@name='username']"));
	  admin.sendKeys(userName);
	  
	  WebElement passwordBox=driver.findElement(By.xpath("//input[@name='password']"));
	  passwordBox.sendKeys(password);
	  
	  WebElement signInButton=driver.findElement(By.xpath("//button[text()='Sign In']"));
	  signInButton.click();
	  
	  WebElement alertmessage =driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
	  Boolean actual=alertmessage.isDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  driver.get("http://groceryapp.uniqassosiates.com/admin/login");
	  driver.manage().window().maximize();
	 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
