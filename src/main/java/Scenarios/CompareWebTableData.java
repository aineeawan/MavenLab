package Scenarios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CompareWebTableData {
	ArrayList<String> act_data = new ArrayList<String>();
	ArrayList<String> exp_data = new ArrayList<String>();
	FileReader fr;
	BufferedReader br;
	WebDriver driver;
	String src="G:\\Selenium_Classes\\Sel@11.30AM(EST)\\data.txt";
	@Test(description="reads data from web table",priority=1)
	public void readFromWebTbl()
	{
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
				act_data.add(allCols.get(j).getText());
			}
			
		}
		
		driver.quit();
	}
	@Test(description="read data from text file",priority=2)
	public void readFromTxtFile() throws IOException
	{
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		String content=null;
		while((content=br.readLine())!=null)
		{
			exp_data.add(content);
			
		}
	}
	@Test(description="Compare data",priority=3,enabled=false)
	public void compareData1()
	{
		for(int i=0;i<exp_data.size();i++)
		{
			if(exp_data.get(i).equals(act_data.get(i)))
			{
				System.out.println("Item matched...");
			}
			else
			{
				System.out.println("Item not matched...");
			}
		}
		
	}
	@Test(description="Compare data",priority=3)
	public void compareData()
	{
		for(int i=0;i<exp_data.size();i++)
		{
			SoftAssert assertion=new SoftAssert();
			assertion.assertEquals(exp_data.get(i), act_data.get(i));
			System.out.println("Item matched...");
			assertion.assertAll();
		}
		
	}
}
