

public class S {

	public static void main(String[] args) {
		
		int N = 3;
		
		switch ( N ) {   // (Assume N is an integer variable.)
		   
		   case 1:
		      System.out.println("The number is 1.");
		      break;
		   
		   case 2:
		   case 4:
		   case 8:
		      System.out.println("The number is 2, 4, or 8.");
		      System.out.println("(That's a power of 2!)");
		      break;
		   
		   case 3:
		   case 6:
		   case 9:
		      System.out.println("The number is 3, 6, or 9.");
		      System.out.println("(That's a multiple of 3!)");
		      break;
		   
		   case 5:
		      System.out.println("The number is 5.");
		      break;
		   
		   default:
		      System.out.println("The number is 7 or is outside the range 1 to 9.");
		      
		      
		      
		      /*switch (expression) {
   				case constant-1:
      					statements-1
      					break;
   				case constant-2:
      					statements-2
      					break;
      			.
      			.   				// (more cases)
      			.
   				case constant-N:
      					statements-N
      					break;
   				default:  // optional default case
      					statements-(N+1)
				} // end of switch statement

				The value of the expression can be one of the primitive integer types int, short, or byte. It can be the primitive char type. It can be String.
				note that the expression cannot be a double or float value.
				
				The constant here is a literal of the same type as the expression in the switch.
				
				You can also use the label "default:" in a switch statement; this provides a default jump point that is used when the value of the expression is not listed in any case label.
		       	*/
		}

	}

}
