/*This class introduces the writing style of two parameters in Lambda Expressions*/
public class TwoParametersInLambdaExpressions {
	
	public interface ArrayProcessor {
	    void process( String[] array, int count );
	}
	
	public static void main(String[] args) 
	{
		ArrayProcessor concat = (A,n) -> { // parentheses around (A,n) are required!
		    String str;
		    str = "";
		    for (int i = 0; i < n; i++)
		        str += A[i];
		    System.out.println(str);
		};  // The semicolon marks the end of the assignment statement;
		    //      it is not part of the lambda expression.

		String[] nums = new String[4];
		nums[0] = "One";
		nums[1] = "Two";
		nums[2] = "Three";
		nums[3] = "Four";
		
		for (int i = 1; i <= nums.length; i++) {
		   concat.process( nums, i );
		}

	}
}
