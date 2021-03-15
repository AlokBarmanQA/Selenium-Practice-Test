package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Select_Class_Dropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://crossbrowsertesting.github.io/selenium_example_page.html");
		WebElement dropdownbox = driver.findElement(By.xpath("//*[@id='dropdown']"));
		Select select = new Select(dropdownbox);
		List <WebElement> dropdownelements = select.getOptions();
		for(WebElement element : dropdownelements) {
			select.selectByVisibleText(element.getText());
			System.out.println("Auto selection: " + dropdownbox.getText());
			Thread.sleep(5000);
		}
		select.selectByIndex(1);
		System.out.println(dropdownbox.getText());
		Thread.sleep(3000);
		select.selectByValue("option3");
		System.out.println(dropdownbox.getText());
		Thread.sleep(3000);
		select.selectByVisibleText("Option 4");
		System.out.println(dropdownbox.getText());
		System.out.println("Execution Completed");
		driver.close();
	}

}
