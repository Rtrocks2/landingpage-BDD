package webTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {

	WebDriver driver;
	
@BeforeMethod
  public void PreCon ()  {	
	    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.indiafirstlife.com/buy-online-insurance/term-plan/?utm_source=website-homepage&utm_campaign=HPBanner2&lead_source=TermBanner_Feb2021&_ga=2.99246557.234363855.1612774765-542671350.1556420042");
		driver.manage().window().maximize();
}

@Test (dataProvider = "user-data", dataProviderClass = TestData.class )
	public void test1(String day,String month,String year,String sInd,String gender,
			String result,String sumAssured, String policyTerm) throws InterruptedException {
	WebElement bdDay = driver.findElement(By.xpath("//*[@id=\"termPlanDOB\"]/div/ul/li[1]/input"));
	WebElement bdMon = driver.findElement(By.xpath("//*[@id=\"termPlanDOB\"]/div/ul/li[2]/input"));
	WebElement bdYear = driver.findElement(By.xpath("//*[@id=\"termPlanDOB\"]/div/ul/li[3]/input"));
	bdDay.click();
	bdDay.sendKeys(day);
	bdMon.click();
	bdMon.sendKeys(month);
	bdYear.click();
	bdYear.sendKeys(year);
	if(sInd != "") {
		driver.findElement(By.xpath(sInd)).click();
	} else {
		driver.findElement(By.xpath("//*[@id=\"onlinetermWrapper\"]/div[5]")).click();
	}
		driver.findElement(By.xpath(gender)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"onlinetermWrapper\"]/div[5]/div/div[2]/div[2]/div[2]/div/button")).click();
		Thread.sleep(2000);
		WebElement saField = driver.findElement(By.name("points"));
		saField.clear();
		saField.sendKeys(sumAssured);
		WebElement pTerm = driver.findElement(By.id("planTerm"));
		pTerm.clear();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		pTerm.sendKeys(policyTerm);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String output = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div[5]/div/div/div[3]/div/span/span[2]")).getText();
		assertEquals(output, result);
}
	@AfterMethod 
	
	public void closure() {
		driver.close();
	}


}
