package Task1_Costs;

import java.util.Arrays;

/** COMP2009-ACE 2020-21 ADE CW4   
    Title:  Skeleton of Vector
    Author: Andrew Parkes
	
    You need to complete and possibly correct this; but do not change the interface.
	(It is not guaranteed bug-free, and of course you should also run tests on your code to check it works correctly.)
*/

public class Vector {

	private int[] A; // the actual storage

	private int m;  // the current number of elements stored
	
	public int count; // use for counting primitive operations
	
	Vector() {
			A = new int[1];
			m=0;
	}

	Vector(int init) {
			A = new int[init];
			m=0;
	}

	public void push (int a){		

	    if ( m >= A.length ) {resize();} // m是A现在已�?存了多少数，如果A存满了就double A的size 	    
		A[m] = a; //在A的末尾加上a
		count++;
		m++; //m 已�?存的数增加一个
		
	}	
		
	public int pop() {
		m--;           
		return A[m];
	}
	
	public int size() {return m;}

	public int getCapacity() // gives the maximum number of elements that can be stored without a resize
	{
		return A.length; 
	}
	
	private void resize(int newSize) 
	{
		int[] B = new int[newSize];
		count = newSize - A.length;
		A = Arrays.copyOf(B, newSize);				
	}
	
	private void resize() {
		// ADD/AMEND to account for the actual resize policy
		resize( 2 * A.length ); 
	}
	
}

