package robots;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Robot_Class_Test {
	@Test
	public void robot_class_methods_test() throws AWTException, InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stqatools.com/");
		Robot robot = new Robot();
		Thread.sleep(5000);
		// This will press Escape key on keyboard
		robot.keyPress(KeyEvent.VK_ESCAPE);
		// This will release the CAPS_LOCK key.
		robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		// This will press Left mouse button.
		robot.mousePress(InputEvent.BUTTON1_MASK);
		// This will release Left mouse button.
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
		Point coordinates = driver.findElement(By.id("img_location")).getLocation();
		robot.mouseMove(coordinates.getX(), coordinates.getY());
		Thread.sleep(5000);
		
		// Press Left button
		robot.mousePress(KeyEvent.BUTTON1_MASK);
		// Release Left button
		robot.mouseRelease(KeyEvent.BUTTON1_MASK);
		// Press Middle button
		robot.mousePress(KeyEvent.BUTTON2_MASK);
		// Release Middle button
		robot.mouseRelease(KeyEvent.BUTTON2_MASK);
		// Press Right button
		robot.mousePress(KeyEvent.BUTTON3_MASK);
		// Release Right button
		robot.mouseRelease(KeyEvent.BUTTON3_MASK);
		
		// Scroll MouseWheel
		robot.mouseWheel(5);
		
		// Get Screen Size
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(size);
		// Capture ScreenShot
		BufferedImage image = robot.createScreenCapture(new Rectangle(size));
		// Store image into file
		File file = new File("D://profile.jpg");
		// Write image path
		ImageIO.write(image, "JPG", file);
		
	}
}
