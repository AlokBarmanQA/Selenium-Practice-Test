package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_Action_Functions {

	WebDriver driver;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void sendKeysUpperCase() throws InterruptedException {
		driver.get("http://www.google.com/");
		WebElement element = driver.findElement(By.name("q"));
		Actions action = new Actions(driver);
		action.moveToElement(element)
				.keyDown(Keys.SHIFT)
				.sendKeys("selenium webdriver")
				.keyUp(Keys.SHIFT)
				.contextClick()
				.doubleClick()
				.build().perform();
		Thread.sleep(3000);
	}
	@Test(priority=2)
	public void clickAndHoldTest() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement target = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.clickAndHold(target)
				.moveToElement(destination)
				.release()
				.build()
				.perform();
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void dragAndDropTest() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		
		WebElement target = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(target, destination)
				.release()
				.build()
				.perform();
		Thread.sleep(5000);
	}
	@Test(priority=4)
	public void dragAndMoveTest() throws InterruptedException {
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		WebElement target = driver.findElement(By.id("draggable"));
		Actions action = new Actions(driver);
					action.moveToElement(target)
					.dragAndDropBy(target, 350, 250)
					.build()
					.perform();
		Thread.sleep(7000);
	}
	@Test(priority=5)
	public void moveByOffsetTest() throws InterruptedException {
		driver.get("https://google.com");
		Actions action = new Actions(driver);
					action.moveByOffset(700, 365)
							.contextClick()
							.build().perform();
		Thread.sleep(5000);
	}
	@AfterMethod
	public void cleanup() {
		driver.close();
	}
}
