package testNgAssignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DataProviderClassForPayroll {
	WebDriver driver;
  @Test(dataProvider="sucessfull",dataProviderClass=DataProviderForPayroll.class)
  public void verificationOfSuccessfullLogin(String userN,String pW) {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys(userN);

	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys(pW);

	  WebElement loginButon=driver.findElement(By.xpath("//button[@class='btn btn-default']"));
	  loginButon.click();

	  WebElement welcomeMsg=driver.findElement(By.xpath("//p[text()='Welcome to Payroll Application']"));
	  Boolean actual=welcomeMsg.isDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test(dataProvider="unsucessfull",dataProviderClass=DataProviderForPayroll.class)
  public void verificationOfUnSuccessfullLogin(String uName,String passW) {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys(uName);

	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys(passW);

	  WebElement loginButon=driver.findElement(By.xpath("//button[@class='btn btn-default']"));
	  loginButon.click();

	  WebElement alertMsg=driver.findElement(By.xpath("//p[starts-with(text(),'Incorrect')]"));
	  Boolean actual=alertMsg.isDisplayed();
	  Assert.assertTrue(actual);
	  
	  
  }

  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  driver.get("https://qabible.in/payrollapp/site/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
