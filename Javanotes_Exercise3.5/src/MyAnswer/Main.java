package MyAnswer;

import textio.TextIO;

public class Main {

	public static void main(String[] args) 
	{
		/*To Check whether the program can open a file or not
		 * If not, then print the messages and quit the system.
		 * */
		try
		{
			TextIO.readFile("sales.dat");
		}
		catch(IllegalArgumentException a)
		{
			System.out.println("Can not open the file!!!");
			System.out.println("Check your file's name input!!");
			System.out.println("Bye!");
			System.exit(0);
		}
		
		
		int count = 0;
		double totalSales = 0.0;
		
		while(TextIO.eof() == false)
		{
			String nameSales = TextIO.getln();	//Read each line
			String saleWithSpaces = nameSales.substring(nameSales.indexOf(":") + 1,nameSales.length());	//Ignore characters up to the colon which is ";"
			String sales = saleWithSpaces.replaceAll("\\s", "");	//Delete all empty space
			
			/*Try to convert String to Double
			 * If successful, then add it to the totalSales
			 * If not, add it to the count variable.
			 * */
			try
			{
				Double salesDouble = Double.parseDouble(sales);
				totalSales = totalSales + salesDouble;
			}
			catch(NumberFormatException a)
			{
				count++;
			}
		}
		
		System.out.println("Total Sales:" + totalSales);
		System.out.println("CAUTION: there are " + count + " cities without data!!");
	}

}
