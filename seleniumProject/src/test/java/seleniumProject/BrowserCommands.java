package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCommands {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
	    System.out.println(driver.getTitle());
	    System.out.println(driver.getCurrentUrl());
	    WebElement inputForm=driver.findElement(By.xpath("(//a[@class='nav-link'])[2]"));
		inputForm.click();
	    System.out.println(driver.getCurrentUrl());
	    System.out.println(driver.getPageSource());
	    driver.quit();

	}

}
