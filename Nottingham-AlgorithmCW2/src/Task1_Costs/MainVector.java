package Task1_Costs;

/** COMP2009-ACE 2020-21 ADE CW4   
    Title:  main to run and test Vector
    Author: Andrew Parkes
	
    You possibly need to complete and modify this.
*/

public class MainVector {
	
	/// used for keeping a running count of primitive operations
	// static int c;
	
	/* Main method:  runs the experiments and prints results.
			You can (and should) change this as needed.
	*/
	public static void main(String[] a){
		
		int maxN = 100;   // CHANGE AS NEEDED - '10' is too small !!
		
		Vector v = new Vector();

		v.count=0;
		if (false) { // turn this on to do a small test - but turn it off again for the experiments
			v.count=0;
			v.push(1);
			System.out.println("Count: " + v.count);
			System.out.println("");
			
			v.count=0;
			v.push(2);
			System.out.println("Count: " + v.count);
			System.out.println("");
			
			v.count=0;
			v.push(3);
			System.out.println("Count: " + v.count);
			System.out.println("");
			
			v.count=0;
			v.push(4);
			System.out.println("Count: " + v.count);
			System.out.println("");
			
			v.count=0;
			v.push(5);
			System.out.println("Count: " + v.count);
			System.out.println("");
			
			v.count=0;
			v.push(6);
			System.out.println("Count: " + v.count);
			System.out.println("");
			
			v.count=0;
			v.push(7);
			System.out.println("Count: " + v.count);
			System.out.println("");
			
			while ( v.size() > 0 ) { System.out.println("out= "+v.pop() ); }
		}	
		
		System.out.println("Costs For Each Push:");
		for (int n = 1 ; n <= maxN ; n+=1 ) {
			v.count=0;
			v.push(n);  // it does not actually matter what value is added (?)
			System.out.println(v.count); // change to csv format if you want
		}

		while ( v.size() > 0 ) { v.pop(); } // just for checking the implementation
		
	}
}
