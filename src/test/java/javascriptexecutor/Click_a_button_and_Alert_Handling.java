package javascriptexecutor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Click_a_button_and_Alert_Handling {
	
	@Test
	public void click_using_javascriptexecutor() throws InterruptedException {
/*
		js.executeScript("document.getElementById('enter your element id').click();");
		//or
		js.executeScript("arguments[0].click();", loginButton);
*/
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/");
		WebElement txtbox_userid = driver.findElement(By.name("uid"));
		WebElement txtbox_password = driver.findElement(By.name("password"));
		WebElement button_login = driver.findElement(By.name("btnLogin"));
		
		txtbox_userid.sendKeys("mngr34926");
		Thread.sleep(3000);
		txtbox_password.sendKeys("amUpenu");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button_login);
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String expectedAlertText = "User or Password is not valid";
		String actualAlertText = alert.getText();
		Assert.assertEquals(actualAlertText, expectedAlertText);
		alert.accept();
		String expectedTitle = "Guru99 Bank Home Page";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();
	}
}
