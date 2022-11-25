package Scenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ThruExcel {

	WebDriver driver;
	String src="G:\\Selenium_Classes\\Sel@11.30AM(EST)\\Data.xlsx";
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	FileInputStream fis;
	Object[][] data;
	@DataProvider(name="data")
	public Object[][] readFrmExcel() throws IOException
	{
		fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
		sheet1=wb.getSheetAt(0);
		int rowCount=sheet1.getLastRowNum();
		int colCount=sheet1.getRow(0).getLastCellNum();
		System.out.println("total rows="+rowCount);
		System.out.println("total columns="+colCount);
		data=new Object[rowCount][colCount];
		for(int i=0;i<rowCount;i++)  //focus Row \\1<5
		{
			for(int j=0;j<colCount;j++) //0<2  1<2  2<2(f)
			{
				//System.out.println(sheet1.getRow(i).getCell(j).getStringCellValue());
				data[i][j]=sheet1.getRow(i+1).getCell(j).getStringCellValue();
						}
		}
		wb.close();
		return data;
	}
	
	@BeforeMethod
	public void lauchRediff()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Classes\\Sel@11.30AM(EST)\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeRediff()
	{
		//driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/a[2]")).click();
		driver.quit();
	}
	@Test(dataProvider = "data",enabled=false)
	public void Login(String un,String pwd)
	{
		System.out.println(un);
		System.out.println(pwd);
		driver.findElement(By.linkText("Sign in")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "Rediffmail");
		driver.findElement(By.id("login1")).sendKeys("m.arpana1234");
		driver.findElement(By.id("password")).sendKeys("arpana123");
		driver.findElement(By.id("remember")).click();
		//driver.findElement(By.name("proceed")).click();
		
	}
}
