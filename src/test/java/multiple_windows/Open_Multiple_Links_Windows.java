package multiple_windows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_Multiple_Links_Windows {
	@Test
	public void openMultipleLinksSimultaneously() {
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
	}
}
