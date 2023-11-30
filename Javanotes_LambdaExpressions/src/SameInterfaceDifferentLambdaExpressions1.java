/*This class introduces different Lambda Expressions but in the same interfaces
 * This is the Example 1.
 * */
public class SameInterfaceDifferentLambdaExpressions1 {

	public interface Runnable {
	    public void run();
	}
	
	static void doSeveralTimes( Runnable task, int repCount ) {
	    for (int i = 0; i < repCount; i++) {
	        task.run();  // Perform the task!
	    }
	}
	
	public static void main(String[] args) {
		
		doSeveralTimes( () -> System.out.println("Hello World"), 10 );
		
		doSeveralTimes( () -> { 
	        // count from 1 up to some random number between 5 and 25
			int count = 5 + (int)(21*Math.random()); 
	    	for (int i = 1; i <= count; i++) { 
	        	System.out.print(i + " ");
	    	}
	    	System.out.println();
		}, 100);

	}
}
