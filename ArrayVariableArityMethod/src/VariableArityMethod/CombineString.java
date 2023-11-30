package VariableArityMethod;

public class CombineString {

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
	
	
	public static void main(String[] args) {

		//the method call concat("Hello", "World") would return the string "HelloWorld", and concat() would return an empty string
		System.out.println(concat());
		System.out.println(concat("Hello", "World"));
		System.out.println(concat("Hello", "World","Zhou"));
		System.out.println(concat("Hello", "World","Zhou","Di"));
		System.out.println();
		
		//ince a variable arity method can also accept an array as actual parameter, we could also call concat(lines) where lines is of type String[]. This would concatenate all the elements of the array into a single string.
		String[] lines = {"Hello","World","Zhou","Di"};
		System.out.print(concat(lines));

	}

}
