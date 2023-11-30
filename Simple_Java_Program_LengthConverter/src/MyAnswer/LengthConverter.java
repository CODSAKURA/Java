package MyAnswer;
import textio.TextIO;

public class LengthConverter {

	public static void main(String[] args) 
	{
		TextIO.put("Measurement:");
		Double digit = TextIO.getDouble();	//Getting the first input part
		String unit = TextIO.getlnWord();	//Getting the second input part
		String unitUpper = unit.toUpperCase();	//Convert to UpperCase in order to check the input unit
		
		while(true)	//Loop checking the user input unit
		{
			if(unitUpper.equals("MILE") || unitUpper.equals("MILES") || unitUpper.equals("YARD") || unitUpper.equals("YARDS") || unitUpper.equals("INCH") || unitUpper.equals("INCHES") || unitUpper.equals("FEET") || unitUpper.equals("FEETS"))
			{
				if(unitUpper.equals("MILE") || unitUpper.equals("MILES"))
				{
					System.out.printf(digit + " " + unit + " = " + "%.5g yards\n" , digit * 1760.0);
					System.out.printf(digit + " " + unit + " = " + "%.5g feet\n" , digit * 5280.0);
					System.out.printf(digit + " " + unit + " = " + "%.5g inches\n" , digit * 63360.0);
					break;
				}
				else if (unitUpper.equals("YARD") || unitUpper.equals("YARDS"))
				{
					System.out.printf(digit + " " + unit + " = " + "%.5g miles\n" , digit / 1760.0);
					System.out.printf(digit + " " + unit + " = " + "%.5g feet\n" , digit * 3.0);
					System.out.printf(digit + " " + unit + " = " + "%.5g inches\n" , digit * 36.0);
					break;
				}
				else if(unitUpper.equals("INCH") || unitUpper.equals("INCHES"))
				{					
					System.out.printf(digit + " " + unit + " = " + "%.5g miles\n" , digit / 63360.0);
					System.out.printf(digit + " " + unit + " = " + "%.5g yards\n" , digit / 36.0);
					System.out.printf(digit + " " + unit + " = " + "%.5g feet\n" , digit / 12.0);
					break;
				}
				else
				{
					System.out.printf(digit + " " + unit + " = " + "%.5g miles\n" , digit / 5280.0);
					System.out.printf(digit + " " + unit + " = " + "%.5g yards\n" , digit / 3.0);
					System.out.printf(digit + " " + unit + " = " + "%.5g inches\n" , digit * 12.0);
					break;
				}
			}
			System.out.println("Unknown Unit, Try again!!!");
			TextIO.put("Measurement:");
			digit = TextIO.getDouble();
			unit = TextIO.getlnWord();		
			unitUpper = unit.toUpperCase();

		}
		
		
	}

}
