package testngSamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class MultipleWindowHandles {
	WebDriver driver;
  @Test
  public void multipleWindowHandling() throws InterruptedException {
	 String parentWindow= driver.getWindowHandle();
	 System.out.println("parent handle  "+parentWindow);
	 WebElement openNewWindowButton=driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
	 openNewWindowButton.click();
	 
	 Set<String>childWindowHandle=driver.getWindowHandles();
	 System.out.println("childwindowhandle" +childWindowHandle);
	 
	 Iterator<String> iterator=childWindowHandle.iterator();
	 while(iterator.hasNext()){
		 String child=iterator.next();
		 if(!parentWindow.equalsIgnoreCase(child)){
			 driver.switchTo().window(child);
			 driver.manage().window().maximize(); 
			 
			 
			 WebElement firstNameFiled=driver.findElement(By.xpath("//input[@id='firstName']"));
			 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='firstName']")));
			 firstNameFiled.sendKeys("karthika");
			 Thread.sleep(5000);
			 driver.close();
		}
		 
		 
	 }
	 driver.switchTo().window(parentWindow);	  
	  
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
