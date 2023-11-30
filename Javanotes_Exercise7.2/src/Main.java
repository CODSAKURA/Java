/**This class is do the transpose on the matrix and output
 * the original matrix and transpose of that matrix. The 
 * precondition is that the matrix is a typical 2D array
 * in which all the rows have the same length.
 * */
public class Main {
	
	/**This subroutine does the transpose on the matrix which
	 * the rows of the transpose matrix is the column of the matrix
	 * and the column of the transpose matrix is the row of the 
	 * matrix. Inside the transpose matrix, the ith rows and jth 
	 * column of the transpose matrix is the jth rows and ith columns
	 * of the original matrix.
	 * @param matrix which is ready to be transposed
	 * @return transposeA which is the transpose of the argument matrix
	 * */
	public static int[][] transpose_matrix(int[][] matrix)
	{
		int[][] transposeA = new int[matrix[0].length][matrix.length];
		
		for(int i = 0; i < matrix[0].length; i++)
		{
			for(int j = 0; j < matrix.length; j++)
			{
				transposeA[i][j] = matrix[j][i];
			}
		}
		
		return transposeA;
	}
	
	/**This subroutine will print the argument matrix in a
	 * well designed outlay.
	 * @param matrix which is ready to be printed
	 * */
	public static void printMatrix(int[][] matrix) {	
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				System.out.printf("   %2d", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	/**This subroutine will test the above two subroutines by
	 * using the in-built functions to print the original
	 * matrix and transpose of that matrix.
	 * @param args the command line arguments of this program
	 * */
	public static void main(String[] args) {
		int[][] A = { {1,0,12,-1},
					  {7,-3,2,5},
					  {-5,-2,2,-9}
		};
		
		System.out.println("Original Matrix is: " );
		printMatrix(A);
		
		System.out.println("\nTranspose of that matrix is: " );
		printMatrix(transpose_matrix(A));
	}

}
