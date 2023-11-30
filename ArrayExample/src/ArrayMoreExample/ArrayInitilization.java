package ArrayMoreExample;

public class ArrayInitilization {
	  public static void main(String[] args) {

		// Initializations for one-dimensional arrays

			@SuppressWarnings("unused")
			int[] s = null;

			@SuppressWarnings("unused")
			int[] k = new int[3];  
			  	  
		    int[] q = null;
		    q = new int[5];   // elements will be 0
		    
		    for (int i = 0; i < q.length; ++i) {
		        System.out.println(q[i]);
		      }
		    
		    //int[] bad = { 0.1, 0.3, 0.5, 0.7 };(This won't work (type mismatch))
		    @SuppressWarnings("unused")
			int[] bad = { 1, 3, 5, 7 };//(This will work)
		    
		    @SuppressWarnings("unused")
			int[] cubes = new int[] { 1, 8, 27, 64, 125, 216, 343 };

		    System.out.println("");


		// Legal initializations for two-dimensional arrays

		    @SuppressWarnings("unused")
			int[][] w = null;

		    @SuppressWarnings("unused")
			int[][] x = new int[3][4];//(3:number of rows ; 4:number of columns)

		    int[][] y = { { 1, 2, 3, 4 },
		                  { 2, 4, 6, 8 },
		                  { 7, 5, 3, 1 } };

		    System.out.println(y[2][1]);   // what does this print?
		  
		  }
}
