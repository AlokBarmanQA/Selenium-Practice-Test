package robots;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Robot_Test {
	
	@Test
	public void robot_class_test() throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		WebElement textbox_email = driver.findElement(By.id("email"));
		WebElement textbox_password = driver.findElement(By.id("pass"));
		textbox_email.sendKeys("abc@xyz.com");
		Thread.sleep(3000);
		textbox_password.sendKeys("test123");
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.close();
	}
}
