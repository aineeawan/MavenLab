package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Rediff {
	WebDriver driver;
	@BeforeClass(description="launch rediff")
	public void openBrowser()
	{
		System.out.println("This test excutes only once before class");		
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Classes\\Sel@11.30AM(EST)\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(description="close rediff")
	public void closeBrowser()
	{
		System.out.println("This test executes only once after class");
		driver.quit();
	}
	
//	@Test(priority=2,description="Hard Assert",enabled=false)
//	public void login()
//	{
//		driver.findElement(By.linkText("Sign in")).click();
//		String title=driver.getTitle();
//		Assert.assertEquals(title, "Rediffmail");
//		driver.findElement(By.id("login1")).sendKeys("m.arpana1234");
//		driver.findElement(By.id("password")).sendKeys("arpana123");
//		driver.findElement(By.id("remember")).click();
//		driver.findElement(By.name("proceed")).click();
//		
//		
//	}
	@Test(priority=2,description="Soft Assert")
	public void login1()
	{
		SoftAssert assertion=new SoftAssert();
		
		driver.findElement(By.linkText("Sign in")).click();
		String title=driver.getTitle();
		assertion.assertEquals(title, "Rediffmail");
		driver.findElement(By.id("login1")).sendKeys("m.arpana1234");
		driver.findElement(By.id("password")).sendKeys("arpana123");
		driver.findElement(By.id("remember")).click();
		driver.findElement(By.name("proceed")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/a[2]")).click();
		assertion.assertAll();
		
	}
}
