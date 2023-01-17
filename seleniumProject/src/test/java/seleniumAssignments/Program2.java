package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement inputForm=driver.findElement(By.xpath("(//a[@class='nav-link'])[2]"));
		inputForm.click();
		WebElement checkBoxDemo=driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
		checkBoxDemo.click();
		WebElement checkBoxOne=driver.findElement(By.xpath("//input[@id='check-box-one']"));
		checkBoxOne.click();
		WebElement checkBoxThree=driver.findElement(By.xpath("//input[@id='check-box-three']"));
		checkBoxThree.click();
		System.out.println(checkBoxOne.isSelected());
		System.out.println(checkBoxThree.isSelected());
		driver.quit();
		
	}

}
