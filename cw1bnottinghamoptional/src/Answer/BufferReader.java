package Answer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BufferReader {

	public static void main(String[] args) throws Exception {
		try 
		{	
			ArrayList<String> list = new ArrayList<String>();
		
			BufferedReader br = new BufferedReader(new FileReader("InputString.txt"));
		
			String line;
		
			while ((line = br.readLine()) != null) 
			{
				list.add(line);
			}
		
			br.close();
		
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


