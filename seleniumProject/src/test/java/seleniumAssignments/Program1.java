package seleniumAssignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/");
		driver.manage().window().maximize();
		driver.navigate().to("http://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.quit();
		
		
	}

}
