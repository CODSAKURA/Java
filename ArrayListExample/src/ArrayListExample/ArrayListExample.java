package ArrayListExample;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args)
	{
		ArrayList<String> array = new ArrayList<String>();
		array.add("Hello");
		array.add("Goodbye");
		array.add("Zoo is a later word");
		array.add("Apple is a early word");
		// array.add( 1 ); // Will not compile
		// array.add( 4.3f ); // Will not compile
		array.sort(null); // null means default sort(A-Z)按顺序排列
		for ( String s : array ) // For each String in array
			System.out.println(s);
		
		
		//note that lists returned by List.of are unmodifiable
		List<Integer> numbers = List.of(1, 2, 3);		
		for ( int s : numbers )
			System.out.println(s);
		
		List<String> words = List.of("One", "Two", "Three");
		for ( String ss : words )
			System.out.println(ss);
		
		System.out.println("Word's size is: "+ words.size());
	}
}
