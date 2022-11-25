package Scenarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class ThruTextFile {

	//declare variables
	File fc;
	FileWriter fw;
	BufferedWriter bw;
	FileReader fr;
	BufferedReader br;
	String src="G:\\Selenium_Classes\\Sel@11.30AM(EST)\\data.txt";
	
	@Test
	public void txtFile() throws IOException
	{
		//Create objects for all the predefined classes
		fc=new File(src);
		fc.createNewFile(); //creates new file in defined path
		fw=new FileWriter(src);
		bw=new BufferedWriter(fw);
		bw.write("This is my First Line");
		bw.newLine();
		bw.write("This is my Second Line");
		bw.close();
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		
		String content=null;
		while((content=br.readLine())!=null)
		{
			System.out.println(content);
		}
		br.close();
	}
}
