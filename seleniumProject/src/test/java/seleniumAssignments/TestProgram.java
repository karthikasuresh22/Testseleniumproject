package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProgram {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		//js.executeScript("window.scrollBy(0,2000)"); 
		//js.executeScript("window.scrollBy(0,-2000)");
		WebElement sale=driver.findElement(By.xpath("//h2[text()='Great Republic Day Sale | Brands in Focus']"));
		js.executeScript("arguments[0].scrollIntoView();", sale);
		//js.executeScript('arguments[0];, sale);
		driver.quit();
	}

}
