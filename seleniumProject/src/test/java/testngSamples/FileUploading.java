package testngSamples;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class FileUploading {
	WebDriver driver;
  @Test
  public void fileUploadUsingSendKeys() {
	  WebElement chooseFile=driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
	  chooseFile.sendKeys("E:\\Automation testing\\JAVA Assignments.doc");
	  WebElement acceptingTerms=driver.findElement(By.xpath("//input[@id='terms']"));
	  acceptingTerms.click();
	  WebElement submitbuton=driver.findElement(By.xpath("//button[@id='submitbutton']"));
	  submitbuton.click();
	  WebElement message=driver.findElement(By.xpath("//h3[@id='res']//center"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@id='res']//center")));
	  Boolean actual=message.isDisplayed();
	  SoftAssert soft=new SoftAssert();
	  soft.assertTrue(actual);
	  soft.assertAll();
 }
  @Test
  public void fileUploadUsingRobotClass() throws AWTException, InterruptedException {
	  driver.navigate().to("https://resume.naukri.com/resume-quality-score");
	  driver.navigate().refresh();
	  WebElement browsebutton= driver.findElement(By.xpath("//span[text()='Browse']"));
	  browsebutton.click();
	  Thread.sleep(3000);
	 
	  Robot rb=new Robot(); //instantiate robotclass
	  
	  StringSelection filePath=new StringSelection("E:\\Automation testing\\classup link.docx");//to store file path
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);//copy path
	  
	  rb.keyPress(KeyEvent.VK_CONTROL);// pressing control key
	  Thread.sleep(3000);
	  rb.keyPress(KeyEvent.VK_V);//pressing v key
	  
	  rb.keyRelease(KeyEvent.VK_CONTROL);//releasing control key
	  Thread.sleep(3000);
	  rb.keyRelease(KeyEvent.VK_V);//releasing v key
	  
	  rb.keyPress(KeyEvent.VK_ENTER);//pressing enter key
	  Thread.sleep(3000);
	  rb.keyRelease(KeyEvent.VK_ENTER);//releasing enter key
	  System.out.println("fileuploaded successfully");
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://demo.guru99.com/test/upload/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
