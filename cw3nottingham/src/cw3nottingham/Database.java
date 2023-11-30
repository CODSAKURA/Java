package cw3nottingham;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class Database {

	/*easier for the other class to access the name of the output file*/
	public String filename = "output.txt";
	
	
	/*make the Database class as singelton*/
	private static Database myObj;

    private Database(){}

    public static Database getInstance()
    {
        if(myObj == null){
            myObj = new Database();
        }
        return myObj;
    }	

    
    /*easier for the other class to access the internal data structure*/
	public ArrayList<String> internalArray = new ArrayList<String>();
	
	
	/*initialise all of the data / data structures in the
database object.*/
	public synchronized void initialise() throws IOException {
		
		FileOutputStream file = new FileOutputStream(filename);
		file.write(new String("").getBytes());
		file.close();
		
		myObj = null;
		
		internalArray.clear();
	}
	
	
	/*load all of the lines from the text file specified*/
	public void load(String filename) throws IOException 
    {
		File File = new File(filename);
		String inString;
        try (BufferedReader reader = new BufferedReader(new FileReader(File))) {
			while ( (inString = reader.readLine()) != null )
				internalArray.add(inString);
			reader.close();
		}
        
    }
	
	
	/*save output to a new text file*/
	public void save() throws IOException
	{
		File inFile = new File(filename);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inFile))) 
        {        	
    		for (Iterator<String> it = internalArray.iterator();it.hasNext();)
    			bw.write( (String) it.next() + "\r\n");
    		bw.close();
        }
	}
	
}
