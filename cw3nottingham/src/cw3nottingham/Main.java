package cw3nottingham;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Database a = Database.getInstance();
		a.initialise();
		a.load("input.txt");
		
		validator b = new validator();
		
		/*for loop to use the iterator of the database object (see requirement 1) to
output the content of the database*/
		for (Iterator<String> it = a.internalArray.iterator();it.hasNext();) {
			String next = (String) it.next();
			b.validate(next);/*validate each line in the content*/
			System.out.println(next);
		}
		
		a.save();
		
	}
		
}