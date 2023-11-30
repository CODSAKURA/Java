package Data;

import java.io.FileNotFoundException;

public class Ex10 {
	public static void main(String[] args) throws FileNotFoundException{
		if (args.length != 1) {
			System.err.println("Error: filename must be specified on command line");
			System.exit(1);
		}
		try
		{
			Dataset b = new Dataset(args[0]);
			System.out.println("Dataset size = " + b.size());
			System.out.printf("Mean value = " + "%.3f", b.meanValue());
			System.out.println("");
		}
		catch(Exception e)
		{
			for(String arg : args)
			{
				System.out.println("Error: cannot access"+ "'"+ arg + "'");
			}
		}
	}
}