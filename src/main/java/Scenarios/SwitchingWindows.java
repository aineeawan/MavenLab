package Scenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchingWindows {

	WebDriver driver;
	@Test
	public void switchWin()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Classes\\Sel@11.30AM(EST)\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		Set<String> allWindIds=driver.getWindowHandles();
		System.out.println("total windows are="+allWindIds.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWindIds.iterator();
		if(itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();
		}
		System.out.println("Window1 title="+driver.getTitle());
		System.out.println("Window1 id="+win1);
		System.out.println("Window2 id="+win2);
		driver.switchTo().window(win2);
		System.out.println("window2 title="+driver.getTitle());
		boolean chkLoginEnbl=driver.findElement(By.id("w3loginbtn")).isEnabled();
		//Assert.assertEquals(chkLoginEnbl, true);
		if(chkLoginEnbl=true)
		{
			System.out.println("Login button enabled");
		}
		else
		{
			System.out.println("Login button disabled");
		}
		driver.quit();
	}
}
