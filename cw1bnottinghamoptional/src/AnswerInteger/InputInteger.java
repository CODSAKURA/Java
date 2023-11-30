package AnswerInteger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class InputInteger {
	public static void main(String[] args) throws Exception {
		try 
		{	
			ArrayList<Integer> list = new ArrayList<Integer>();
		
			BufferedReader br = new BufferedReader(new FileReader("InputInteger.txt"));
		
			String line;
			
			while ((line = br.readLine()) != null) 
			{				
				list.add(Integer.parseInt(line));
			}
		
			br.close();		
		
			Collections.sort(list);
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("OutputInteger.txt"));
		
			for(Integer i:list)
			{
                	bw.write( i + "\r\n");
			}
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
