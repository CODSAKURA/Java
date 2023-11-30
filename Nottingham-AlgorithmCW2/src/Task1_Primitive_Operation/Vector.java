package Task1_Primitive_Operation;

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
			count = count + 1;				//counting the primitive operations for assigning a value to a variable
	}

	Vector(int init) {
			A = new int[init];
			
			m=0;
			count = count + 1;				//counting the primitive operations for assigning a value to a variable
	}

	public void push (int a){
		
		// m is the number of elements that have been stored		
	    if ( m >= A.length ) 	    	
	    {
			count = count + 1;				//counting the primitive operations for comparing two numbers
			
	    	resize(); //When the size of A is not big enough for next element to put in, then resize the size of A
	    	count = count + 1;				//counting the primitive operations for calling a method
	    } 
	    count = count + 1;				//counting the primitive operations for comparing two numbers
	    
		A[m] = a; //add the a into the end of array A		
		count++; //Increase the primitive operations as adding the index into array
		
		m++; //m which is the number of elements that have been stored add 1 to it
		count = count + 2;				//counting the primitive operations for adding and assigning.
	}	
		
	public int pop() {
		m--;
		count = count + 2;				//counting the primitive operations for adding and assigning.
		
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
		
		A = Arrays.copyOf(B, newSize);
		count = count + 3;				//counting the primitive operations for calling a method and returning a method and assigning
	}
	
	private void resize() {
		// ADD/AMEND to account for the actual resize policy
		resize( 2 * A.length ); 
		count = count + 2;				//counting the primitive operations for calling a method and multiplying
	}
	
}
