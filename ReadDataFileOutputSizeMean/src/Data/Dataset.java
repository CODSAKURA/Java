package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dataset {
	
	private ArrayList<Double> data;
	
	public Dataset(String filename) throws FileNotFoundException 
	{
		data = new ArrayList<Double>();
		Scanner input = new Scanner(new File(filename));
		
		Double lineNumber = (double)0;
		while(input.hasNext()){
            Double line = input.nextDouble();
            data.add(line);
            lineNumber++;
		}
		input.close();
	}	
	
	
	public int size()
	{
		return data.size();
	}	
	
	
	public double meanValue()
	{
		double sum = (double)0;
		for ( int i = 0; i < data.size(); i++) 
		{
			sum += data.get(i);
		}
		if(sum > 0)
		{
			return sum/data.size();
		}
		throw new ArithmeticException("Invalid calculation");
	}

}

