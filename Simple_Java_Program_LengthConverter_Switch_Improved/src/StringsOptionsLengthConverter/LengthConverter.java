package StringsOptionsLengthConverter;

import textio.TextIO;

public class LengthConverter {

	public static void main(String[] args) {
		String units;       // Unit of measurement, entered by user.
		double measurement; // A numerical measurement, input by the user.
		double inches = 0.0;      // The same measurement, converted into inches.

		/* Read the user's unit of measurement. */

		System.out.println("What unit of measurement does your input use?");
		units = TextIO.getln().toLowerCase();

		/* Read user's measurement and convert to inches. */

		System.out.print("Enter the number of " + units + ":  ");
		measurement = TextIO.getlnDouble();

		switch ( units ) {
		   case "inch", "inches", "in" ->  inches = measurement;
		   case "foot", "feet", "ft"   ->  inches = measurement * 12;
		   case "yard", "yards", "yd"  ->  inches = measurement * 36;
		   case "mile", "miles", "mi"  ->  inches = measurement * 12 * 5280;
		   default -> {
		       System.out.println("Wait a minute!  Illegal unit of measure!  I quit!");
		       System.exit(1);
		   }
		} // end switch
		   
       	/* Convert measurement in inches to feet, yards, and miles. */
           
		double feet = inches / 12.0;
    	double yards = inches / 36.0;
    	double miles = inches / (12.0*5280.0);
          
    	/* Output measurement in terms of each unit of measure. */
        
    	System.out.println();
    	System.out.printf("""
    			That's equivalent to:
    			%14.5g inches
    			%14.5g feet
    			%14.5g yards
    			%14.5g miles
    			""", inches, feet, yards, miles);
    	System.out.println();

	}

}
