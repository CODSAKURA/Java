package ArrayListExample;

import java.util.ArrayList;
import java.util.List;

public class Wrapper {
	  public static void main(String[] args) {

		    // This won't compile: lists contain objects, not primitive values

		    //List<int> bad = new ArrayList<>();(This will not work)

		    List<Integer> data = new ArrayList<>();

		    data.add(1);    // value gets boxed as an Integer object automatically
		    data.add(4);
		    data.add(9);
		    data.add(16);

		    for (int value: data) {       // automatic unboxing happens here
		      System.out.println(value);
		    }
		  }
}
