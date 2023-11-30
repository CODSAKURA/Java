package Answer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CommandLine {
	public static void main(String[] args) throws Exception {
		if(args.length == 0)
		{
			throw new Exception("Empty Input");
		}
		try 
		{	
			//将String【】 args转换成String
			//直接args或者args.toString()不可以转换成String
			
			String s = "";
			
			for (int i =0;i<args.length;i++)
			{
				s+=args[i];
			}
					
			ArrayList<String> list = new ArrayList<String>();
		
			BufferedReader br = new BufferedReader(new FileReader(s));
		
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

