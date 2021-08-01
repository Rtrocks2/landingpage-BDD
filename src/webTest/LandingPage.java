package webTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class LandingPage {
	
	WebDriver driver;
	public void DragTest() {
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://formy-project.herokuapp.com/dragdrop");
	
	
	WebElement drag = driver.findElement(By.id("image"));
	WebElement drop = driver.findElement(By.id("box"));
	
	Actions a = new Actions(driver);
	
	a.dragAndDrop(drag, drop).build().perform();
	
}
}