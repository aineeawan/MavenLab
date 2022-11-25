package Scenarios;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Vindeep {

	@Test
	public void HandlingDiffObjs() throws InterruptedException
	{
		
		ArrayList<String> exp_data=new ArrayList<String>();
		exp_data.add("Days1");
		exp_data.add("Months");
		exp_data.add("Years");
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Classes\\Sel@11.30AM(EST)\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://vindeep.com/Calculators/FDCalc.aspx");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("title="+title);
		if(title.equals("Fixed Deposit Calculator | Calculate FD Interest, Maturity value"))
		{
			System.out.println("title matched..");
			driver.findElement(By.id("ContentPlaceHolder1_cphCentre_FDAmount")).clear();
			driver.findElement(By.id("ContentPlaceHolder1_cphCentre_FDAmount")).sendKeys("200000");
			driver.findElement(By.id("ContentPlaceHolder1_cphCentre_Period")).clear();
			driver.findElement(By.id("ContentPlaceHolder1_cphCentre_Period")).sendKeys("70");
			//select item from a list box--FD Period
			WebElement ele=driver.findElement(By.id("ContentPlaceHolder1_cphCentre_PeriodDropDown"));
			Select opts=new Select(ele);
			opts.selectByVisibleText("Years");
			//count no. of items in a listbox
			List<WebElement> allItems=opts.getOptions();
			System.out.println("total number of items="+allItems.size());
			//print items from a listbox
			for(int i=0;i<allItems.size();i++) //0<3
			{
				System.out.println(allItems.get(i).getText());
				if(exp_data.get(i).equals(allItems.get(i).getText()))
				{
					System.out.println("Item Matched..");
				}
				else
				{
					System.out.println("Item not matched...");
				}
			}
			driver.findElement(By.id("ContentPlaceHolder1_cphCentre_InterestRate")).clear();
			driver.findElement(By.id("ContentPlaceHolder1_cphCentre_InterestRate")).sendKeys("6.50");
			//select items from a list box--Interest Compounding Frequency
			Select opts1 = new Select(driver.findElement(By.id("ContentPlaceHolder1_cphCentre_FrequencyDropDown")));
			opts1.selectByIndex(0);
			List<WebElement> allItems1=opts1.getOptions();
			System.out.println("Total Number of items="+allItems1.size());
			for(int i=0;i<allItems1.size();i++)
			{
				System.out.println(allItems1.get(i).getText());
			}
			driver.findElement(By.name("ctl00$ContentPlaceHolder1$cphCentre$btnFDMAmount")).click();
			Thread.sleep(5000);
			String fd_amount=driver.findElement(By.id("ContentPlaceHolder1_cphCentre_MaturityAmountTextBox")).getAttribute("value");
			System.out.println("FD Amount="+fd_amount);
			driver.quit();
			
		}
		else
		{
			System.out.println("title not matched...");
		}
		
	}

}
