package ArrayMoreExample;

import java.util.Arrays;

public class ArrayUtil {
	  public static void main(String[] args) {
		  	
		  	// One-liner to print a small array (useful for debugging, etc)
		    int[] data = { 1, 7, -2, 0, 12, 5, 1, 9 };		 
		    System.out.println(Arrays.toString(data));

		    // Copying and sorting an array
		    int[] dataCopy = Arrays.copyOf(data, data.length);
		    Arrays.sort(dataCopy);
		    System.out.println(Arrays.toString(dataCopy));

		    // Searching a sorted array for a value by using binarySearch the array must be sorted.
		    int pos = Arrays.binarySearch(dataCopy, 0);
		    System.out.printf("0 found at index %d\n", pos);
		    pos = Arrays.binarySearch(dataCopy, 9);
		    System.out.printf("9 found at index %d\n", pos);

		    // Filling all array with a value
		    Arrays.fill(dataCopy, 1);
		    System.out.println(Arrays.toString(dataCopy));
		    
		    //Arrays.fill( array, fromIndex, toIndex, value ) fills part of the array with value
		    Arrays.fill(data,0,5,1);
		    System.out.println(Arrays.toString(data));
		    
		    //Arrays.sort( array, fromIndex, toIndex ) sorts just the elements from array[fromIndex] up to array[toIndex-1]
		    int[] a = { 1, 7, -2, 0, 12, 5, 1, 9 };
		    Arrays.sort(a,0,5);
		    System.out.println(Arrays.toString(a));
		  }
}
