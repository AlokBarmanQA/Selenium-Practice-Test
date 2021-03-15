package multiple_windows;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple_Window_Handle {
	@Test
	public void openMultipleLinksSimultaneously() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		WebElement getToKnowUsPannel = driver.findElement(By.xpath("//*[@id='navFooter']/div[1]/div/div[1]/ul"));
		List <WebElement> links = getToKnowUsPannel.findElements(By.tagName("a"));
		for(WebElement link : links) {
			String keysToSend = Keys.chord(Keys.CONTROL, Keys.ENTER);
			link.sendKeys(keysToSend);
		}
		Thread.sleep(10000);
		String main_window = driver.getWindowHandle();
		Set <String> all_windows = driver.getWindowHandles();
		System.out.println("Main window: " + main_window);
		for(String window : all_windows) {
			System.out.println(window);
			if(! window.equals(main_window)) {
				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
			}
			driver.close();
		}
	}
}
