package excecuteClass;

import org.testng.annotations.Test;

import elementRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import testngSamples.DataProviderForLogin;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTestClass {
	WebDriver driver;
	LoginPage lp;
	
  @Test
  public void verifyTheLoginPageIsDisplayedWhileOpeningUrl() {
	  
	  lp=new LoginPage(driver);
	  //Boolean actual= lp.is7rmartSuperMarketDisplyaed();
	 // Assert.assertTrue(actual);
	  String actual=lp.getTextOf7rmartSuperMarket();
	  String expected="7rmart supermarket";
	  Assert.assertEquals(actual, expected);
	  
  }
  @Test
  public void verifySuccessfullLoging() {
	  lp=new LoginPage(driver);
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickOnSignInButton();
	  
	  Boolean actual=lp.isAdminNameDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @Test(dataProvider="unsuccessfullLogin",dataProviderClass=DataProviderForLogin.class)
  public void verifyUnSuccessfullLogin(String userN,String pswrd) {
	  lp=new LoginPage(driver);
	  lp.enterUserName(userN);
	  lp.enterPassword(pswrd);
	  lp.clickOnSignInButton();
	  
	  Boolean actual=lp.isAlertMsgDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test
  public void verifyRememberMeCheckBoxIsSelectedByDefault() {
	  lp=new LoginPage(driver);
	  
	  Boolean actual=lp.isRemenberMeCheckBoxIsSelectedByDefault();
	  Assert.assertFalse(actual);
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
