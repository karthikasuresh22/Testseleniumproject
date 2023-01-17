package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementCommand {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
		WebElement inputForm=driver.findElement(By.xpath("(//a[@class='nav-link'])[2]"));
		inputForm.click();
		WebElement messageTextBox=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		messageTextBox.sendKeys("Hi");
		WebElement showButtonMessage=driver.findElement(By.xpath("//button[@id='button-one']"));
		showButtonMessage.click();
		//showButtonMessage.submit();
		messageTextBox.clear();
		WebElement yourMessageText=driver.findElement(By.xpath("//div[@id='message-one']"));
		System.out.println(yourMessageText.getText());
		//driver.quit();
		WebElement checkBoxDemo=driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
		checkBoxDemo.click();
		WebElement checkBox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
		checkBox.click();
		System.out.println(checkBox.isSelected());
	}
}
