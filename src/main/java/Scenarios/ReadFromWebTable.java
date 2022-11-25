package Scenarios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadFromWebTable {

	WebDriver driver;
	FileWriter fw;
	BufferedWriter bw;
	String src="G:\\Selenium_Classes\\Sel@11.30AM(EST)\\data.txt";
	@Test
	public void readFrmTable() throws IOException
	{
		fw=new FileWriter(src);
		bw=new BufferedWriter(fw);
		
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Classes\\Sel@11.30AM(EST)\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		WebElement myTable=driver.findElement(By.id("customers"));
		//Fetch rows
		List<WebElement> allRows=myTable.findElements(By.tagName("tr"));
		System.out.println("Total Rows="+allRows.size());
		for(int i=1;i<allRows.size();i++)  //focus to row i=2
		{
			List<WebElement> allCols=allRows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<allCols.size();j++)  //3<3
			{
				//System.out.println(allCols.get(j).getText());
				bw.write(allCols.get(j).getText());
				bw.newLine();
			}
			
		}
		bw.close();
		driver.quit();
	}
}
