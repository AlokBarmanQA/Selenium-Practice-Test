package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Move_Slider {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/slider/");
		WebElement slider = driver.findElement(By.id("sliderContainer"));
		Actions action = new Actions(driver);
		action.moveToElement(slider, 50, 0).perform();
		slider.click();
		System.out.println("Moved slider in horizontal directions");
		driver.close();
	}

}
