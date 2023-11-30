package ArrayListExample;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lotto {
	  public static void main(String[] args) {

		  	// Create numbers from 1 to 59 and shuffle them randomly
		  
		    List<Integer> numbers = new LinkedList<>();

		    for (int i = 1; i <= 59; ++i) {
		      numbers.add(i);
		    }

		    System.out.println(numbers);
		    
		    System.out.println();
		    
		    
		    //为了打乱顺序
		    
		    Collections.shuffle(numbers);
		    
		    System.out.println(numbers);
		    
		    System.out.println();
		
		    
		    // Remove first six items of shuffled list to use as drawn numbers

		    List<Integer> chosen = new LinkedList<>();

		    while (chosen.size() < 6) 
		    {
		      chosen.add(numbers.remove(0));
		    }   

		    Collections.sort(chosen);
		    
		    System.out.print("This week's numbers are");
		    
		    for (int number: chosen) 
		    {
		      System.out.printf(" %d", number);
		    }
		    
		    System.out.println();

	    
		    // Remove a seventh number to use as 'bonus ball'

		    int bonus = numbers.remove(0);

		    System.out.printf("\nThe bonus ball is %d\n", bonus);
		  }
}
