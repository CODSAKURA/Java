package Answer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UsingScanner {
	public static void main(String[] args) throws Exception {
		try 
		{		
			Scanner s = new Scanner(new FileReader("InputString.txt"));
		
			ArrayList<String> list = new ArrayList<String>();
		
			while (s.hasNext())
			{
		    	list.add(s.next());
			}
			s.close();
		
			Collections.sort(list);		
		
			BufferedWriter bw = new BufferedWriter(new FileWriter("OutputString.txt"));
		
			for(String Str:list)
			{
                	bw.write( Str + "\r\n");
        	}
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
