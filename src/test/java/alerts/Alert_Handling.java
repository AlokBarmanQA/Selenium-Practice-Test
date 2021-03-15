package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_Handling {

	@Test
	public void alert_mesage_test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement click_Button_to_see_alert = driver.findElement(By.xpath("//*[@id='alertButton']"));
		click_Button_to_see_alert.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		alert.accept(); // click on OK button

		WebElement on_button_click_alert_will_appear_after_5_seconds = driver.findElement(By.xpath("//*[@id='timerAlertButton']"));
		on_button_click_alert_will_appear_after_5_seconds.click();
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(7000);
		alert.accept(); // click OK button

		WebElement  on_button_click_confirm_box_will_appear = driver.findElement(By.xpath("//*[@id='confirmButton']"));
		on_button_click_confirm_box_will_appear.click();
		Thread.sleep(5000);
		alert.accept();
		WebElement result = driver.findElement(By.xpath("//*[@id='confirmResult']"));
		String expected_Ok = "You selected Ok";
		String actual = result.getText();
		Assert.assertEquals(actual, expected_Ok);

		Thread.sleep(5000);
		on_button_click_confirm_box_will_appear.click();
		Thread.sleep(5000);
		alert.dismiss();
		String expected_cancel = "You selected Cancel";
		Assert.assertEquals(result.getText(), expected_cancel);
		
		Thread.sleep(5000);
		WebElement on_button_click_prompt_box_will_appear = driver.findElement(By.xpath("//*[@id='promtButton']"));
		on_button_click_prompt_box_will_appear.click();
		Thread.sleep(5000);
		alert.sendKeys("Alok Barman");
		Thread.sleep(3000);
		alert.accept();
		WebElement result2 = driver.findElement(By.xpath("//*[@id='promptResult']"));
		String expected_name = "You entered Alok Barman";
		Assert.assertEquals(result2.getText(), expected_name);
		
		Thread.sleep(3000);
		on_button_click_prompt_box_will_appear.click();
		Thread.sleep(3000);
		alert.dismiss();
		
		driver.close();
	}

}
