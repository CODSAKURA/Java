package Task1_Primitive_Operation;

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
		
		
		System.out.println("Total Primitive Operations For Each Push: ");
		v.count=0;
		for (int n = 1 ; n <= maxN ; n+=1 ) {			
			v.push(n);  // it does not actually matter what value is added (?)
			System.out.println(n + " " + v.count); // change to csv format if you want
		}

		while ( v.size() > 0 ) { v.pop(); } // just for checking the implementation		
		System.out.println("");
		
		
		
		System.out.println("Primitive Operations For Each Push: ");		
		Vector v2 = new Vector();		
		for (int n = 1 ; n <= maxN ; n+=1 ) {
			v2.count=0;			
			v2.push(n);  // it does not actually matter what value is added (?)
			System.out.println(n + " " + v2.count); // change to csv format if you want
		}

		while ( v2.size() > 0 ) { v2.pop(); } // just for checking the implementation
		
	}
}

