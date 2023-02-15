package testNgAssignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WindowHandlingAssignment {
	WebDriver driver;
  @Test(priority = 2)
  public void verifyTheCorrectWindowIsOpenedWhileClickingTheOpenNewWindowButton() {
	  String parentW=driver.getWindowHandle();

	  WebElement openNewWindowButton=driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
	  openNewWindowButton.click();
	  
	  Set<String> childw=driver.getWindowHandles();
	  
	  Iterator<String> iterator=childw.iterator();
	  
	  while(iterator.hasNext()) {
		  String child=iterator.next();
		  
		  if(!parentW.equalsIgnoreCase(child)) {
			  driver.switchTo().window(child);
			  driver.manage().window().maximize();
			  
			  WebElement titleBasicControl=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
			  Boolean actual=titleBasicControl.isDisplayed();
			  Assert.assertTrue(actual);
			  driver.close();		  
		  }		  
	  }
	  driver.switchTo().window(parentW);
 }
  @Test(priority = 5)
  public void verifyTheRegistrationIsSuccessfullOrNot() {
	  String parentw=driver.getWindowHandle();
	  
	  Set<String> childw=driver.getWindowHandles();
	  
	  Iterator<String> iterator=childw.iterator();
	  
	  while(iterator.hasNext()) {
		  String child=iterator.next();
		  
		  if(!parentw.equalsIgnoreCase(child)) {
			  driver.switchTo().window(child);
			  driver.manage().window().maximize();
			  
			  WebElement navigateToHomePageComment=driver.findElement(By.xpath("//a[@id='navigateHome']"));
			  JavascriptExecutor js=(JavascriptExecutor)driver;
			  js.executeScript("arguments[0].scrollIntoView();", navigateToHomePageComment);
			  
			  WebElement firstNameBox=driver.findElement(By.xpath("//input[@id='firstName']"));
			  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='firstName']")));
			  firstNameBox.sendKeys("karthika");
			  
			  WebElement lastNameBox=driver.findElement(By.xpath("//input[@id='lastName']"));
			  //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='lastName']")));
			  lastNameBox.sendKeys("satheesh");
			  
			  WebElement genderSelection=driver.findElement(By.xpath("//input[@id='femalerb']"));
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='femalerb']")));
			  js.executeScript("arguments[0].click();", genderSelection);
			  //genderSelection.click();
			  
			  WebElement englishLanguage=driver.findElement(By.xpath("//input[@id='englishchbx']"));
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='englishchbx']")));
			  js.executeScript("arguments[0].click();",englishLanguage);
			  
			  WebElement hindiLangauage=driver.findElement(By.xpath("//input[@id='hindichbx']"));
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='hindichbx']")));
			  js.executeScript("arguments[0].click();",hindiLangauage);
			  
			  WebElement emailAddress=driver.findElement(By.xpath("//input[@id='email']"));
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email']")));
			  emailAddress.sendKeys("karthikasuresh22.94@gmail.com");
			  
			  WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']")));
			  password.sendKeys("karthikasatheesh123");
			  
			  WebElement registerButton=driver.findElement(By.xpath("//button[@id='registerbtn']"));
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='registerbtn']")));
			  js.executeScript("arguments[0].click();",registerButton);
			  
			  WebElement registerMessage=driver.findElement(By.xpath("//label[@id='msg']"));
			  Boolean actual=registerMessage.isDisplayed();
			  Assert.assertTrue(actual);
			  driver.close();
		  }
	  }
	 driver.switchTo().window(parentw);
  }
  
  @Test(priority = 1)
  public void verifyTheCorrectWindowIsOpenedWhileClickingTheOpenNewTabButton() {
	  String parentw=driver.getWindowHandle();
	  
	  WebElement openNewTbButton=driver.findElement(By.xpath("//button[@id='newTabBtn']"));
	  openNewTbButton.click();
	  
	  Set<String> childw=driver.getWindowHandles();
	  
	  Iterator<String> iterator=childw.iterator();
	  
	  while(iterator.hasNext()) {
		  String child=iterator.next();
		  if(!parentw.equalsIgnoreCase(child)) {
			  driver.switchTo().window(child);
			  driver.manage().window().maximize();
			  
			  WebElement alertDemoTitle=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
			  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='post-title entry-title']")));
			  Boolean actual=alertDemoTitle.isDisplayed();
			  Assert.assertTrue(actual);
			  driver.close();
		  
		  }		  
	  }
      driver.switchTo().window(parentw);	  	  
  }
  @Test(priority = 4)
  public void verifySimpleAlertIsAccepttedOrNot() {
	  String parentw=driver.getWindowHandle();
	  
	  WebElement openNewTbButton=driver.findElement(By.xpath("//button[@id='newTabBtn']"));
	  openNewTbButton.click();

	  Set<String> childw=driver.getWindowHandles();

	  Iterator<String> iterator=childw.iterator();

	  while(iterator.hasNext()) {
		  String child=iterator.next();
		  if(!parentw.equalsIgnoreCase(child)) {
			  driver.switchTo().window(child);
			  driver.manage().window().maximize();
			  
			  WebElement thirdClickMeButton=driver.findElement(By.xpath("//button[@id='promptBox']"));
			  JavascriptExecutor js=(JavascriptExecutor)driver;
			  js.executeScript("arguments[0].scrollIntoView();",thirdClickMeButton);
			  
			  WebElement firstClickMeButton=driver.findElement(By.xpath("//button[@id='alertBox']"));
			  firstClickMeButton.click();
			  //js.executeScript("argumens[0].click();",firstClickMeButton);
			  driver.switchTo().alert().accept();
			  
			  WebElement simpleAlertMsg=driver.findElement(By.xpath("//div[@id='output']"));
			  Boolean actual=simpleAlertMsg.isDisplayed();
			  Assert.assertTrue(actual);
			  driver.close();
		  }
	  }
	  driver.switchTo().window(parentw);
  }
  
 @Test(priority = 3)
 public void verifyPromptAlertIsAccepttedOrNot() {
	 String parentw=driver.getWindowHandle();
	 
	  WebElement openNewTbButton=driver.findElement(By.xpath("//button[@id='newTabBtn']"));
	  openNewTbButton.click();

	  Set<String> childw=driver.getWindowHandles();

	  Iterator<String> iterator=childw.iterator();

	  while(iterator.hasNext()) {
		  String child=iterator.next();
		  if(!parentw.equalsIgnoreCase(child)) {
			  driver.switchTo().window(child);
			  driver.manage().window().maximize();
			  
			  WebElement lastClickMeButton=driver.findElement(By.xpath("//button[@id='promptBox']"));
			  JavascriptExecutor js=(JavascriptExecutor)driver;
			  js.executeScript("arguments[0].scrollIntoView();",lastClickMeButton);
			  
			  WebElement thirdClickMeButton=driver.findElement(By.xpath("//button[@id='promptBox']"));
			  thirdClickMeButton.click();
			  driver.switchTo().alert().sendKeys("karthika satheesh");
			  driver.switchTo().alert().accept();
			  
			  WebElement promptAlertMsg=driver.findElement(By.xpath("//div[@id='output']"));
			  Boolean actual=promptAlertMsg.isDisplayed();
			  Assert.assertTrue(actual);
					  			  
			  
		  }
	  }
	 
 }

  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  
  }

}
