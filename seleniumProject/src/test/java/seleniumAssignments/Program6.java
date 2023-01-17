package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program6 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		WebElement multiSelectionBox=driver.findElement(By.xpath("//select[@id='multiselect1']"));
		Select select=new Select(multiSelectionBox);
		select.selectByIndex(1);
		select.selectByValue("swiftx");
		select.selectByVisibleText("Audi");
		select.deselectAll();
		driver.quit();
	}

}
