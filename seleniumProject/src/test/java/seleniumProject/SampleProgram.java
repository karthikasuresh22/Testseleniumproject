package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleProgram {
	


public static void main(String[]args) {
	
//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Satheesh\\Desktop\\KarthikaJava\\Workspace\\seleniumProject\\src\\main\\resources\\chromedriver.exe ");
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://selenium.obsqurazone.com/index.php");
driver.manage().window().maximize();
WebElement home=driver.findElement(By.className("nav-link"));
WebElement inputform=driver.findElement(By.className("nav-link"));
WebElement inputform1=driver.findElement(By.cssSelector("a.nav-link"));
WebElement home1=driver.findElement(By.linkText("Home"));
WebElement alertAndModels=driver.findElement(By.partialLinkText("Alerts"));
driver.close();
//driver.quit();
}
}