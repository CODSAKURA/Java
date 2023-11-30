package ArrayExample;

import java.sql.Time;

public class TimeExample {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		//1.
		Time[] t = new Time[10];
		System.out.println(t.length); // prints 10
		System.out.println(t[0]); // prints null
		System.out.println(t[1]); // prints null
		
		t[0] = new Time(7, 30, 0);
		System.out.println(t[0]); 
		
		//2.
		double[] x = { 0.1, 0.3, 0.5, 0.7 }; //Static Initialisation
		for(int i = 0; i < x.length ; i ++)
		{
			System.out.print(x[i] + " ");
		}
		System.out.println(" ");
		
		for (double number: x) 
		{
			System.out.print(number + " ");
		}
		
		//3.
		@SuppressWarnings("unused")
		int[][] xs = new int[3][4]; //Multidimensional Arrays (3:number of rows ; 4:number of columns)
		
		@SuppressWarnings("unused")
		int[][] ys = { { 1, 2, 3, 4 },
					   { 2, 4, 6, 8 },
					   { 7, 5, 3, 1 } };


	}
}
