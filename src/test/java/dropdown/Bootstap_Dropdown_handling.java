package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstap_Dropdown_handling {

	public static void main(String[] args) throws InterruptedException {
		// //ul[@class='multiselect-container dropdown-menu']/li/a/label
		// //tbody/tr[2]/td[3]/div[1]/span[1]/div[1]/ul[1]/li
		// https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		WebElement dropdownbutton = driver.findElement(By.xpath("//button[@data-toggle='dropdown']"));
		dropdownbutton.click();
		List <WebElement> elements = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']/li/a/label"));
		for (WebElement element : elements) {
//			System.out.println(element.getAttribute("innerHTML"));
			System.out.println(element.getText());
		}
		for (WebElement element : elements) {
			element.click();
			Thread.sleep(3000);
		}
		System.out.println("Execution completed");
	}

}
