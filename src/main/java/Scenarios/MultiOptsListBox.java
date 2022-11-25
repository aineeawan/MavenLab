package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultiOptsListBox {



	@Test
	public void listBox() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Classes\\Sel@11.30AM(EST)\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		Select allOpts=new Select(driver.findElement(By.id("cars")));
		allOpts.selectByIndex(0);
		allOpts.selectByValue("saab");
		allOpts.selectByVisibleText("Audi");
		driver.findElement(By.xpath("/html/body/form/input")).click();
		Thread.sleep(5000);
		String selCars=driver.findElement(By.xpath("/html/body/div[1]")).getText();
		System.out.println(selCars);
		driver.quit();
		

	}

}
