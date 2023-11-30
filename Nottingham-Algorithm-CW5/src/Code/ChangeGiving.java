package Code;

/**  COMP2009-ACE 2020-21 ADE CW5 Part 1. Hash table exercise

Author: Andrew Parkes

Implementation is just for the purposes of simplicity and clarity for the C/W 5.
Absolutely not an example of how one should really implement a hash table;
not least because "find" and "delete" are missing !!

You can modify the code as needed to do experiments - e.g. turning parts on and off, and modifying the output to give something more convenient for usage in producing graphs.



*/

import java.util.Collections;
import java.util.Vector;

public class ChangeGiving {
	
	private static Vector<Integer> x;
	private static int K;
	private static int[] y;
	
	public static void init_y() 
	{
		y = new int[K+1];
		y[0] = 0;
		
		for (int i = 1; i < y.length; i++) 
		{
			y[i] = -1;
		}
	}
	
	// The occurrences of "-99" are just placeholder that you need to replace with correct expressions for II.A	
	public static void RunDP() 
	{
		
		for (int i = 0; i < x.size(); i++) 
		{
			for (int m = K - x.get(i); m >= 0; m--) 
			{

				int index = m + x.get(i);
				if (y[m] >= 0) 
				{
					
					if (y[m+x.get(i)] == -1) 
					{
						y[ m+x.get(i) ] = index ;   // TODO add correct expressions
					}
					else 
					{
						y[ m+x.get(i) ] = Math.min( index , y[ m+x.get(i) ] ); // TODO add correct expressions
					}
					
				}
				
			}
		}
	}
	
	/**   Apply a greedy algorithm and return the number of coins that are used, or -1 if the method does not meet the target
	
	TODO: finish the implementation
		
	*/
	public static int RunGreedy(int local_K) 
	{
		
		//copy the coins 'x' to a new Vector  x_do
		Vector<Integer> x_DO = new Vector<Integer>();
		for (int i=0;i<x.size();i++) 
		{ 
			x_DO.add(x.get(i)); 
		}
		
		//sort the new vector x_DO (using the Vector library is fine) 
		Collections.sort(x_DO);
			
		//scan from largest to smallest - assigning the coins when they are allowed 
		for (int i=x_DO.size() - 1  ; i >= 0 ; i-- ) 
		{
			int coin = x_DO.get(i);
			System.out.println("coin= " + coin);
		
			// TODO finish off the implementation here for II.C  and using local_K as the target
			if(coin >= local_K){return 1;}
			local_K = local_K - coin;
		}
				
		return -1;
	}
	
	public static void main(String[] args) {
		K=776;
		
		x = new Vector<Integer>();

		// build the set of coins
		int mult=2; 		
		for (int m = 0 ; m < mult ; m++ ) 
		{
			x.add(1);
			x.add(2);
			x.add(5);
			x.add(10);
			x.add(20);
			x.add(50);
			x.add(100);
			x.add(200);
		}
		
		int sumCoins=0;
		for (int i = 0 ; i < x.size() ; i++ ) 
		{
			sumCoins += x.get(i); 
		}
		System.out.println("Sumcoins: " + sumCoins);

//		System.out.print("COINS ");
//		for (int i = 0 ; i < x.size() ; i++ ) 
//		{
//			System.out.print(" " + x.get(i)); 
//		}
		
		
		System.out.println("");

		
		// just so that you can turn on/off the running of DP
		// this does a scan of a range of possible target values using DP
		// TODO PART II.B : Try to improve this so that it becomes more efficient, and avoids multiple invocations of RunDP()
		if (true) 
		{  						
			init_y();
			RunDP();
			for (int target = 1; target <= sumCoins+1 ; target++ ) 
			{
				if(target > sumCoins)
				{
					System.out.println("The maximum target should not be more than the sum of all coins.");
					break;
				}
				K = target;
				System.out.println("TARGET= " + K);
				for(int i = 0; i <= K ; i++)
				{
					System.out.println(i + " " + y[i]);
				}
			}
			System.out.println("");
		}
		
		
		// just so that you can turn on/off the running of DP
		// this does a scan of a range of possible target values using Greedy
		if (false) 
		{   			
			for (int target = 1; target <= sumCoins+1 ; target ++ ) 
			{
				if(target > sumCoins)
				{
					System.out.println("The maximum target should not be more than the sum of all coins.");
					break;
				}
				K = target;
				System.out.println("TARGET= " + K);
				int greedy = RunGreedy(K);
				System.out.println("Greedy: " + K + " " + greedy);
				System.out.println("");
			}
		}
		
	}
}
