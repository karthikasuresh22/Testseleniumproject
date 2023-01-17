package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement inputForm=driver.findElement(By.xpath("(//a[@class='nav-link'])[2]"));
		inputForm.click();
		WebElement radioButtonDemo=driver.findElement(By.xpath("//a[text()='Radio Buttons Demo']"));
		radioButtonDemo.click();
		WebElement femaleButton=driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		femaleButton.click();
		System.out.println(femaleButton.isSelected());
		WebElement showSelectedValue=driver.findElement(By.xpath("//button[@id='button-one']"));
		showSelectedValue.click();
		WebElement femaleSelected=driver.findElement(By.xpath("//div[@id='message-one']"));
		System.out.println(femaleSelected.isDisplayed());
	    System.out.println(femaleSelected.getText());
		driver.quit();
		

	}

}
