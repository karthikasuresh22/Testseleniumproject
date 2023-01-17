package testNgAssignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import javax.management.ObjectName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestNgSamplePrograms {
	 WebDriver driver;

 @Test
  public void verifyTheApplicationIsCorrectlyOpensWhileHitingTheUrl() {
  		String expectedResult="https://demo.guru99.com/test/newtours/index.php";
	 String actualResult=driver.getCurrentUrl();
	 Assert.assertEquals(actualResult, expectedResult);
  }
	 
@Test
public void verifyTheLogoIsVisibleOrNot() {
	WebElement logo=driver.findElement(By.xpath("//img[@alt='Mercury Tours']"));
	Boolean actualresult=logo.isDisplayed();
	Assert.assertTrue(actualresult);
}

@Test
public void verifyTheSuccesfullSignOn() {
	WebElement signOn=driver.findElement(By.xpath("//a[text()='SIGN-ON']"));
	driver.navigate().to("https://demo.guru99.com/test/newtours/login.php");
	WebElement userName=driver.findElement(By.xpath("//input[@name='userName']"));
	userName.sendKeys("anna");
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys("1234");
	WebElement submit=driver.findElement(By.xpath("//input[@name='submit']"));
	submit.submit();
	WebElement loginSuccessfull=driver.findElement(By.xpath("//table[@border='0' and @width='492']//tr[1]//td[1]"));
    Boolean actualResult=loginSuccessfull.isDisplayed();
	Assert.assertTrue(actualResult);
}

@Test
public void verifyTheSignInByInvalidDetails() {
	WebElement userName=driver.findElement(By.xpath("//input[@name='userName']"));
	userName.sendKeys("chinnu");
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys("1234");
	WebElement submit=driver.findElement(By.xpath("//input[@name='submit']"));
	submit.submit();
	WebElement msg=driver.findElement(By.xpath("(//table[@width='100%'])[2]//tr[3]//td[2]//span"));
	Boolean actualResult=msg.isDisplayed();
	Assert.assertTrue(actualResult);	
}

@Test
public void registerLinkIsClickleOrNot() {
	WebElement register=driver.findElement(By.xpath("//a[text()='REGISTER']"));
	register.click();
	WebElement registerHeading=driver.findElement(By.xpath("//table[@width='492' and @border='0']//tr[1]//td[1]//img"));
	//String expected="https://demo.guru99.com/test/newtours/register.php";
    Boolean actual=registerHeading.isDisplayed();
	Assert.assertTrue(actual);
}

@Test
public void onWayButtonIsSelectedByDefault() {
	WebElement flightButton=driver.findElement(By.linkText("Flights"));
	//flightButton.click();
	driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
	WebElement radioButton=driver.findElement(By.xpath("(//input[@name='tripType'])[2]"));
	Boolean actual=radioButton.isSelected();
	Assert.assertFalse(actual);
}
  
  @BeforeMethod
  public void beforeMethod() {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.get("https://demo.guru99.com/test/newtours/index.php");
	 driver.manage().window().maximize();
	 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
