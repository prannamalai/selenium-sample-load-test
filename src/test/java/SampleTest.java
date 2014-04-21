import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleTest {

	@Test(invocationCount = 100, threadPoolSize = 5)
	public void loadTest() {

		System.out.printf("%n[START] Thread Id : %s is started!", Thread
				.currentThread().getId());

		WebDriver driver = new FirefoxDriver();
		
		//WebDriver driver2 = new ChromeDriver(); 
		// For chrome driver set the path
	    String baseUrl = "https://www.google.co.in/";
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    driver.get(baseUrl + "/?gws_rd=cr&ei=dppUU-TZF8zhrAfRhYHwAw");
	    driver.findElement(By.id("gbqfq")).clear();
	    driver.findElement(By.id("gbqfq")).sendKeys("paypal");
	    driver.findElement(By.linkText("PayPal: Send Money, Pay Online or Set Up a Merchant ...")).click();
	    driver.findElement(By.id("header-send")).click();
	    driver.findElement(By.linkText("Learn more")).click();
	    driver.quit();
	    
		System.out.printf("%n[END] Thread Id : %s", Thread.currentThread()
				.getId());

	}
}