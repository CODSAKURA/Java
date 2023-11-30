package ArrayMoreExample;

public class ArrayLiteral {
	public static String concat( String... values ) 
	{
		   StringBuilder buffer;  // Use a StringBuilder for more efficient concatenation.
		   buffer = new StringBuilder();  // Start with an empty StringBuilder.
		   
		   for ( String str : values ) 
		   { // A "for each" loop for processing the values.
		       buffer.append(str); // Add string to the buffer.
		   }
		   
		   return buffer.toString(); // return the contents of the buffer
	}
	
	public static void main(String[] args) 
	{
		//Array Literal More Convenient 
		System.out.print(concat(new String[] { "New", "Open", "Close", null, "Quit" }));
	}
}
