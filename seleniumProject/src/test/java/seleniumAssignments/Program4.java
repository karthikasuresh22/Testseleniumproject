package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
		WebElement home=driver.findElement(By.xpath("(//a[@class='nav-link'])[1]"));
	    System.out.println(home.getTagName());
	    System.out.println(home.getAttribute("class"));
	    System.out.println(home.getCssValue("font-size"));
	    WebElement logo=driver.findElement(By.xpath("(//img[@alt='logo'])[1]"));
		System.out.println(logo.getSize());
		driver.quit();
	}

}
