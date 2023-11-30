import java.util.Arrays;

/**This class is used to compare the running time of two different sorting 
 * on two different types of arrays. One is selection sort and the other is 
 * the in-built function of Arrays.sort(). Both two ways of sorting will be 
 * implemented on a double array and a string array. Output will be the time
 * that are computed for both methods in both nanoseconds and seconds.
 * */
public class Main {
	
	/**This method is generated and return a specific size of a double array which
	 * each element in the array is a random double. The range of the element
	 * in the array is from 1 to 6.
	 * @param size the size of the double array
	 * @return a double array with specific size which each element in the array is random.
	 * */
	public static double[] randomDoubleArray(int size)
	{
		double[] randomReal = new double[size];
		for(int i = 0; i < size; i++)
		{
			double range1To6 = (double)(6 * Math.random()) + 1.0;
			randomReal[i] = range1To6;
		}
		return randomReal;
	}
	
	/**This method is generated and returned a specific size of a string array which
	 * each element in the string array is combined with a random letter from A to Z.
	 * The size of each string element in the string array is randomly selected from a 
	 * range 1 to 8. The algorithm using here to create each string element in a string 
	 * array is first decide the length of the string element, and then creating a char
	 * array which the same size of the string element and then convert char array to string
	 * and assign to the string element.
	 * @param size the specific size of the array
	 * @return a string array with some random string elements assigned to its elements. 
	 * */
	public static String[] randomStringArray(int size)
	{
		String[] randomString = new String[size];
		for(int i = 0; i < size; i++)
		{
			int range1To8 = (int)(8 * Math.random()) + 1;	//Deciding the size of the string element of the string array.
			char[] element = new char[range1To8];	//Generating the size of a char array is same as the string element. 
			for(int j = 0; j < element.length; j++)
			{
				int range65To90 = (int)(26 * Math.random()) + 65;	//Generating an integer from 65 to 90 as
																	//the ASCII code from A to Z is 65 to 90.
				char letter = (char)range65To90;	//Converting the integer to char value
				element[j] = letter;	//Assigning the char value to char array.
			}
			
			/*Converting the char array to a string and store in the string array as an element.*/
			randomString[i] = new String(element);
		}
		return randomString;
	}
	
	/**
	 * This method is using the selection sort to sort an double array.
	 * @param A a double array
	 * */
	public static void selectionSortDouble(double[] A) {
	      // Sort A into increasing order, using selection sort
	      
	   for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
	         // Find the largest item among A[0], A[1], ...,
	         // A[lastPlace], and move it into position lastPlace 
	         // by swapping it with the number that is currently 
	         // in position lastPlace.
	         
	      int maxLoc = 0;  // Location of largest item seen so far.
	      
	      for (int j = 1; j <= lastPlace; j++) {
	         if (A[j] > A[maxLoc]) {
	               // Since A[j] is bigger than the maximum we've seen
	               // so far, j is the new location of the maximum value
	               // we've seen so far.
	            maxLoc = j;  
	         }
	      }
	      
	      double temp = A[maxLoc];  // Swap largest item with A[lastPlace].
	      A[maxLoc] = A[lastPlace];
	      A[lastPlace] = temp;
	      
	   }  // end of for loop
	   
	}
	
	/**
	 * This method is using the selection sort to sort an string array.
	 * @param A a string array
	 * */
	public static void selectionSortString(String[] A) {
	      // Sort A into increasing order, using selection sort
	      
	   for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
	         // Find the largest item among A[0], A[1], ...,
	         // A[lastPlace], and move it into position lastPlace 
	         // by swapping it with the number that is currently 
	         // in position lastPlace.
	         
	      int maxLoc = 0;  // Location of largest item seen so far.
	      
	      for (int j = 1; j <= lastPlace; j++) {
	         if (A[j].compareTo(A[maxLoc]) > 0) {
	               // Since A[j] is bigger than the maximum we've seen
	               // so far, j is the new location of the maximum value
	               // we've seen so far.
	            maxLoc = j;  
	         }
	      }
	      
	      String temp = A[maxLoc];  // Swap largest item with A[lastPlace].
	      A[maxLoc] = A[lastPlace];
	      A[lastPlace] = temp;
	      
	   }  // end of for loop
	   
	}
	
	/**This is the main routine to test the running time of two ways of sorting.
	 * One is the selection sort and the other is the in-built function called sort().
	 * These two ways of sorting will be tested on a double array and a string array.
	 * As the array size is 100000 which is quite a big size, so the result of running 
	 * this program will take a long time as usual. Probably around 20 seconds.
	 * @param args the command line argument of this program
	 * */
	public static void main(String[] args) {
		int arraySize = 100000;		
		
		//Testing sorting on a double array	
		double[] testDoubleArray = randomDoubleArray(arraySize);
		double[] copyOfTestDoubleArray1 = Arrays.copyOf(testDoubleArray, arraySize);	//In order to not modifying the original double array.
		double[] copyOfTestDoubleArray2 = Arrays.copyOf(testDoubleArray, arraySize);	//In order to not modifying the original double array.
			
		long startTimeS = System.nanoTime();
		selectionSortDouble(copyOfTestDoubleArray1);
		long finishTimeS = System.nanoTime();
		long computingTimeS = finishTimeS - startTimeS;
			
		System.out.println("[SelectionSort() on a double array of size 100000]");
		System.out.println("Computing time in nanoseconds: " + computingTimeS);
		System.out.println("Computing time in seconds: " + (double)(computingTimeS / 1000000000.0));
			
			
		long startTimeA = System.nanoTime();
		Arrays.sort(copyOfTestDoubleArray2);
		long finishTimeA = System.nanoTime();
		long computingTimeA = finishTimeA - startTimeA;
			
		System.out.println("\n[Array.sort() on a double array of size 100000]");
		System.out.println("Computing time in nanoseconds: " + computingTimeA);
		System.out.println("Computing time in seconds: " + (double)(computingTimeA / 1000000000.0) + "\n");
		
		//Testing sorting on a string array. Probably running for a while(20 seconds)
		String[] testStringArray = randomStringArray(arraySize);
		String[] copyOfTestStringArray1 = Arrays.copyOf(testStringArray, arraySize);	//In order to not modifying the original string array.
		String[] copyOfTestStringArray2 = Arrays.copyOf(testStringArray, arraySize);	//In order to not modifying the original string array.
		
		startTimeS = System.nanoTime();
		selectionSortString(copyOfTestStringArray1);
		finishTimeS = System.nanoTime();
		computingTimeS = finishTimeS - startTimeS;
			
		System.out.println("[SelectionSort() on a string array of size 100000]");
		System.out.println("Computing time in nanoseconds: " + computingTimeS);
		System.out.println("Computing time in seconds: " + (double)(computingTimeS / 1000000000.0));
			
		startTimeA = System.nanoTime();
		Arrays.sort(copyOfTestStringArray2);
		finishTimeA = System.nanoTime();
		computingTimeA = finishTimeA - startTimeA;
			
		System.out.println("\n[Array.sort() on a string array of size 100000]");
		System.out.println("Computing time in nanoseconds: " + computingTimeA);
		System.out.println("Computing time in seconds: " + (double)(computingTimeA / 1000000000.0) + "\n");	
	}
}
