package Algorithm;

/** COMP2009-ACE-ADE 2020-21 C/W TWO 
    Title:  Analysis of Algorithms
	Author: Andrew Parkes
	Version Date: 2020-11-29  MOSTLY FINAL


	See the specification document for how to use this.

*/
import java.lang.Math;
import java.util.Random;

public class Main {
	
	static int c; 	// used for counting primitive operations
	static Random rnd;

	/* Main method:  runs the experiments and prints results.
	
		You can (and should) change this as needed.
		
		E.g. You should change the maxN, maxRuns and maxVal to values of your choice.
		You may well also want to do more than just report the n,c from each run.
		e.g. to collect and print more 'statistics' such as worst, best, average at each value of n.
		(If they are applicable).
	*/
	public static void main(String[] a){
		
		int maxN = 30;   // CHANGE AS NEEDED
		int numRuns = 1;  // CHANGE AS NEEDED - multiple runs not needed if the function and input are deterministic
		int maxVal = 1000;  // CHANGE AS NEEDED - not needed when not used :-).
		
		rnd = new Random();

		for (int n = 1 ; n <= maxN ; n+=1 ) {
			int[] A = new int[n];
			double worst_case=0.0,best_case=Integer.MAX_VALUE,sum=0.0;
			for (int run = 0 ; run < numRuns ; run++ ) {
				// initialise A with randomised values
				
				// pick one of the following to initialise the matrix
				// (these are defined below, and can be adjusted if you want)
				// make up more options if you like
//				randInit(A,maxVal);
//				incInit(A);
//				randIncInit(A,maxVal);
				
				// reset the counter, c, run f, and report the count
				c=0;
				// uncomment the one you need
//				int out = p1(n);
//				int out = p2(n);
				
//				incInit(A) ; int out = p3(A);  // or use one of the initialisation methods
				randInit(A,maxVal) ; int out = p3(A);  // or use one of the initialisation methods
//				randIncInit(A,maxVal) ; int out = p3(A);  // or use one of the initialisation methods
								
//				System.out.println("n=" + n +"," + "c=" + c);
				System.out.println("n=" + n + ","+ "out=" + out);
				
				// KEEP EXTRA STATISTICS AS NEEDED, IF RELEVANT
				if (c>worst_case) worst_case=c;
				if (c<best_case) best_case=c;
				sum+=c;
				
			}
//			 System.out.println("n=" +n+" "+"worst_case=" +worst_case+" "+"best_case=" +best_case+" "+"sum/numRuns=" +sum/numRuns);
//			 System.out.println("");
		}
		// PROCESS/PRINT EXTRA STATISTICS AS NEEDED/DESIRED
	}
	
	// The first function "p1" that needs to be analysed
	static int p1(int n) {
		if ( n < 2 ) {return -1;}
		
		// start counting primitive operations from here
		int m=0;								c += 1;//assign a value to a variable(m = 0)
		while ( n >= 2 ) {			    		c += 2;//two comparisons(larger or equal)
	    	n = n / 2;					        c += 2;//division(n/2) and assign a value to a variable(n = n/2)
			m++ ;								c += 2;//adding(m+1) and assign a value to a variable(m = m+1)
		}
												c += 2;//calling exit method and return value from while loop
												c += 1;//returning from a method
		return m;
	}

	
	// Function "p2" that needs to be analysed
	static int p2(int n) {
		if ( n < 2 ) {return -1;}
		
		// start counting primitive operations from here
		int m=0;							  c += 1;//assign a value to a variable(m = 0)
		while ( n >= 2 ) {			    	  c += 2;//two comparisons(larger or equal)
	    	double s = Math.sqrt(n);		  c += 2;//calling a method(sqrt) and assign a value to a variable(s = sqrt(n))
	    	n = (int) Math.floor(s);          c += 2;//calling a method(floor) and assign a value to a variable(n = floor(s))
			m++ ;							  c += 2;//adding(m+1) and assign a value to a variable(m = m+1)
		}
											  c += 2;//calling exit method and return value from while loop
											  c += 1;//returning from a method
		return m;
	}

	/* 	Function 'p3' that needs to be analysed.
		It works on an integer array, 'A' with n elements.
		You can think of it as a piece of 'legacy code' you are given and it is suspected to 
		be causing trouble, such as making the application program to be going slow. 
		You need to analyse its scaling behaviour and make other comments.
		The "c += " fragments have been added to help, but are not part of the code itself.

		NOTE: Do _NOT_ take this as an example of how to write good code!
		Parts of it may be deliberately poor to illustrate useful points.

		DO NOT CHANGE THIS FUNCTION EXCEPT THE increments to the counter on the r.h.s. !!!
	*/
	static int p3(int[] A) {
		// start counting primitive operations from here

//		 System.out.println("OLD A[0]= " + A[0]);

		int n = A.length;                   	c += 2;//calling a method(length) and assign a value to a variable(n = A.length)
	    int[] B = new int[n];               	c += 1;//indexing into an array
	
		for (int k1=0; k1 < n; k1++) {        	c += 1;//assign a value to a variable(k1 = 0)
												c += 1;//a comparison (k1 < n)
												c += 2;//adding(k1 + 1) and assign a value to a variable (k1 = k1 + 1)
		  B[k1] = A[k1];						c += 3;//indexing into an array twice(B[k1],A[k1]) and assign a value to a variable (B[k1] = A[k1])
		}
												c += 1;//calling exit method from while loop
		A = B;                              	c += 1;//assign a value to a variable(A = B)

//		System.out.println("NEW A[0]= " + A[0]);
	
		int max = 0;                      		c += 1;//assign a value to a variable(max = 0)
		if ( n%2 == 0 ) {						c += 2;//division(n % 2) and comparison (n % 2 == 0)
			// find max sum over all pairs 
			for (int k1=0; k1 < (n-1); k1++) {     			c += 1;//assign a value to a variable (k1=0)
															c += 2;//a subtraction(n - 1) and comparison (k1 < (n-1))
															c += 2;//adding(k1 + 1) and assign a value to a variable (k1 = k1 + 1)
			 for (int k2=k1+1; k2 < n; k2++) {     			c += 2;//adding(k1 + 1) and assign a value to a variable (k2 = k1 + 1)
			 												c += 1;//a comparison (k2 < n)
			 												c += 2;//adding(k2 + 1) and assign a value to a variable (k2 = k2 + 1)
				int m  = A[k1] + A[k2];                     c += 4;//adding(A[k1] + A[k2]),assign a value to a variable(m  = A[k1] + A[k2]) and indexing into an array twice(A[k1],A[k2])
				if ( m > max ) {							c += 1;//a comparison(m > max)
					max = m;               					c += 1; // assign a value to a variable(max = m)
				}
			 }
			}
		}
		else {
			// find maximum sum over all adjacent pairs
			for (int k1=0; k1 < (n-1); k1++) {     			c += 1;//assign a value to a variable (k1=0)
															c += 2;//a subtraction(n - 1) and comparison (k1 < (n-1))
															c += 2;//adding(k1 + 1) and assign a value to a variable (k1 = k1 + 1)
				int m = A[k1] + A[k1+1];    				c += 5;//adding twice(k1+1,A[k1] + A[k1+1]),indexing into an array twice(A[k1+1],A[k1]) and assign a value to a variable(m = A[k1] + A[k1+1])
				if ( m > max ) {    						c += 1;//a comparison( m > max )
					max = m;               					c += 1; //assign a value to a variable (max = m)
				}
			}									
		}
												c += 2; //exit method and return a value from if else method
												c += 1; //return method
		return max;
	}

	/* Used to initialise the array A.
	   Initialises with random values.
	*/
	static void randInit(int[] A, int max) {
		int n = A.length;
		for (int i = 0 ; i < n ; i++ ) {
			A[i] = rnd.nextInt( max );
			// System.out.println( "i= " + i + " A[i]= " + A[i] );
		}
	}
	
	/* Used to initialise the array A.
	   Gives totally sorted as increasing
	*/
	static void incInit(int[] A ) {
		int n = A.length;
		for (int i = 0 ; i < n ; i++ ) {
			A[i] = i;
			// System.out.println( "i= " + i + " A[i]= " + A[i] );
		}
	}

	/* Used to initialise the array A.
	   Tries to do a mix of random and increasing.
	   Try to experiment with different systems here and look at how (or if) the scaling changes.
	*/
	static void randIncInit(int[] A, int max) {
		int n = A.length;
		for (int i = 0 ; i < n ; i++ ) {
			A[i] = max*i + rnd.nextInt( max );
			// System.out.println( "i= " + i + " A[i]= " + A[i] );
		}
	}
    
}