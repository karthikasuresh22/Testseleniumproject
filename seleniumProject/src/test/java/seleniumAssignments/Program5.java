package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program5 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		WebElement olderNewsPapperLetter=driver.findElement(By.id("drop1"));
		olderNewsPapperLetter.click();
		Select options=new Select(olderNewsPapperLetter);
		options.selectByIndex(2);
		//options.selectByValue("ghi");
		//options.selectByVisibleText("doc 2");
		driver.quit();
	}

}
