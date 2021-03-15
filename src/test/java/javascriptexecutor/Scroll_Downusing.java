package javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll_Downusing {
	
	@Test
	public void scroll_down_usin_javascript_executor() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://moneyboats.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Vertical scroll down by 600  pixels
		js.executeScript("window.scrollBy(0, 600)");
	}
}
