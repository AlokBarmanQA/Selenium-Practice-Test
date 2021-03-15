package links;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Broken_Links {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/links");

		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links: " + links.size());
		for(WebElement link : links) {
			String linkUrl = link.getAttribute("href");
			try {
				URL url = new URL(linkUrl);
				HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				connection.setConnectTimeout(5000);
				connection.connect();
				if(connection.getResponseCode() >=400) {
					System.out.println(linkUrl + " >> " + connection.getResponseMessage() + "  <<< is broken URL");
				}
				else {
					System.out.println(linkUrl+" - "+connection.getResponseMessage());
				}
			} 
			catch (Exception e) {
//				e.printStackTrace();
			}
		}
		System.out.println("Execution completed");
		driver.close();
	}

}
