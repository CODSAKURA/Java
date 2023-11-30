package Algorithm;

/** COMP2009-ACE-ADE 2020-21 LAB - FORMATIVE EXERCISE
Title:  Analysis of Algorithms
Author: Andrew Parkes
Version Date: 2020-11-25-10:18

This exercise is formative, so feel free to work together, but recommend to try it yourself first.

Not guaranteed to be bug free.
The point is that the algorithm "arrayMax" being analysed is basically trivial, so can focus on the counting and analysis.
*/
import java.util.Random;

public class LabMain {

static int c; 	// used for counting primitive operations
static Random rnd;

/* Main method:  runs the experiments and prints results.

	You can (and should) change this as needed.
	
	E.g. You should change the maxN, maxRuns and maxVal to values of your choice.
	You may well also want to do more than just report the n,c from each run.
	e.g. to collect and print more 'statistics' such as worst, best, average at each value of n.
*/
public static void main(String[] a){
	
	int maxN = 30;   // CHANGE AS NEEDED
	int numRuns = 1;  // CHANGE AS NEEDED
	int maxVal = 1000;  // CHANGE AS NEEDED
	
	rnd = new Random();

	for (int n = 1 ; n <= maxN ; n+=1 ) {
		int[] A = new int[n];
		double worst_case=0.0,best_case=Integer.MAX_VALUE,sum=0.0;
		for (int run = 0 ; run < numRuns ; run++ ) {
			// initialise A with randomised values
			
			// pick one of the following to initialise the matrix
			// (these are defined below, and can be adjusted if you want)
			// make up more options if you like
			 randInit(A,maxVal);
//			 incInit(A);
//			randIncInit(A,maxVal);
			
			// reset the counter, c, run f, and report the count
			c=0;
			int out = arrayMax(A);
			
			// System.out.println(n + " " + c + "  A[0]= " + A[0]);
			System.out.println(c);
			// KEEP EXTRA STATISTICS AS NEEDED
			if (c>worst_case) worst_case=c;
			if (c<best_case) best_case=c;
			sum+=c;
			
		}
		// System.out.println(n+" "+worst_case+" "+best_case+" "+sum/numRuns);
	}
	// PROCESS/PRINT EXTRA STATISTICS AS NEEDED/DESIRED
}

/* 	This is the function that needs to be analysed.
	It works on an integer array, 'A' with n elements.
	
	The point is to change the "c += ??" statements to be your estimate 
	of the number of primitive operations assocaited with the line.
	I.e. change the entries below to be what you think they should be.
	
	IMPORTANT: note the some of the "c += ??" statements are inside the loop, and so 
	will be executed each time. 
	Hence do not then need to include the number of times the operation is done in total. 
	It would be wrong to put c+= n or similar inside the loop as then you will be over-counting.
	(Try it, and see the change on the graphs.)
	Note this is just a different presentation of the counting than the way it was done in the lectures; simply because it is actually 
	being done as an operation in code as opposed to an annotation on a slide.
	
	NOTE:  do not try to include the primitive operations used by the "c+=??" statements  - they are not part of the algorithm, but are there 
	just to enable automated counting, and so make it easier to produce graphs.
	
*/
static int arrayMax(int[] A) {
	int n = A.length;                   	
	if ( n == 0 ) {return -1;}
	
	// start counting primitive operations from here
	int currentMax = A[0];                  c += 2 ;
    for (int p=1; p < n; p++) {     		c += 1 ;
    								        c += 1; // for 'anything else'
		if ( A[p] > currentMax ) {			c += 2 ;
			currentMax = A[p];				c += 2 ; // (ridiculous) value is just to get you started - and you should adjust it
			// System.out.println( "Update at p= " + p);
											c += 2; // for 'anything else'
		}
	}
								c += 2; // for 'anything else'
	
								c += 1; // for the 'return'
	return currentMax;
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