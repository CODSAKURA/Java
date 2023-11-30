package AnswerFloat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class AnswerFloat {
	public static void main(String[] args) throws Exception {
		try 
		{	
			ArrayList<Float> list = new ArrayList<Float>();
		
			BufferedReader br = new BufferedReader(new FileReader("InputFloat.txt"));
		
			String line;
			
			while ((line = br.readLine()) != null) 
			{				
				list.add(Float.parseFloat(line));
			}
		
			br.close();		
		
			Collections.sort(list);
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("OutputFloat.txt"));
		
			for(Float i:list)
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
