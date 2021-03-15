package javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Capture_Scrape_Data_Navigate_different_page {
	
	@Test
	public void fetch_webpage_details_test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Fetching the Domain Name of the site. Tostring() change object to name.
		String domain = js.executeScript("return document.domain").toString();
		System.out.println("Domain name of the site = "+ domain);
		//Fetching the URL of the site. Tostring() change object to name
		String url = js.executeScript("return document.URL").toString();
		System.out.println("URL of the site = "+ url);
		  //Method document.title fetch the Title name of the site. Tostring() change object to name
		String title = js.executeScript("return document.title").toString();
		System.out.println("Title of the site = " + title);
		
		//Navigate to new Page i.e to generate access page. (launch new url)
		js.executeScript("window.location = 'http://demo.guru99.com/'");
	}
}
