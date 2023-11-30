
public class Main {

	public static void main(String[] args) {
		int a = 5;
		int b = 6;	
		
		/*Integer.compare():
		 * if x == y, the value is 0;*
		 * if x < y, the value is -1;
		 * if x > y, the value is 1;
		 * */
		System.out.println(Integer.compare(a, b));

		
				
		int c = 7;
		int d = 5;		
		Boolean boolean1 = (a == d);
		Boolean boolean2 = (b == c);
		
		System.out.println(boolean1);
		System.out.println(boolean2);
		
		/*Boolean.compare():
		 * if x == y, the value is 0;
		 * if x is false and y is true, the value is -1;
		 * if x is true and y is false, the value is 1;
		 * */
		System.out.println(Boolean.compare(boolean1, boolean2));

	}

}
