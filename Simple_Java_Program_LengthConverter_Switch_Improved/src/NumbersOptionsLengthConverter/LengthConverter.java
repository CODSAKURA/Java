package NumbersOptionsLengthConverter;

import textio.TextIO;

/**
 * This program will convert measurements expressed in inches,
 * feet, yards, or miles into each of the possible units of
 * measure.  The measurement is input by the user, followed by
 * the unit of measure.  For example:  "17 feet", "1 inch", or
 * "2.73 mi".  Abbreviations in, ft, yd, and mi are accepted.
 * The program will continue to read and convert measurements
 * until the user enters an input of 0.
 */
 public class LengthConverter {
 
    public static void main(String[] args) {
       
    	int optionNumber;   // Option number from menu, selected by user.
    	double measurement; // A numerical measurement, input by the user.
    	                    //    The unit of measurement depends on which
    	                    //    option the user has selected.
    	double inches = 0.0;      // The same measurement, converted into inches.

    	/* Display menu of options, and get user's selected option number. */

    	while(true)
    	{
        	System.out.print("""
        	        What unit of measurement does your input use?
        	        
        	                0. quit
        	                1. inches
        	                2. feet
        	                3. yards
        	                4. miles 	                
        	                
        	        Enter the number of your choice:""");

        	optionNumber = TextIO.getlnInt();

        	/* Read user's measurement and convert to inches. */

        	switch ( optionNumber ) {
        	   case 1 -> {
        	       System.out.print("Enter the number of inches:");
        	       measurement = TextIO.getlnDouble();
        	       inches = measurement;
        	   }
        	   case 2 -> {
        	       System.out.print("Enter the number of feet:");
        	       measurement = TextIO.getlnDouble();
        	       inches = measurement * 12;
        	   }
        	   case 3 -> {
        	       System.out.print("Enter the number of yards:");
        	       measurement = TextIO.getlnDouble();
        	       inches = measurement * 36;
        	   }
        	   case 4 -> {
        	       System.out.print("Enter the number of miles:");
        	       measurement = TextIO.getlnDouble();
        	       inches = measurement * 12 * 5280;
        	    }
        	   case 0 -> {
        	    	System.out.println("OK!  Bye for now.");
        	    	System.exit(1);
        	   }
        	   default -> {
        		   System.out.println();
        	       System.out.println("Error!  Illegal option number!  Try again!!");
        	       System.out.println();
        	       continue;
        	   }

        	} // end switch

        	/* Now go on to convert inches to feet, yards, and miles... */
              
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
      
    } // end main()
    
 } // end class LengthConverter
