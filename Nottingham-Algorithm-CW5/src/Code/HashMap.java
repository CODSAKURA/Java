package Code;
/**  COMP2009-ACE 2020-21 ADE CW5 Part 1. Hash table exercise

Author: Andrew Parkes

Implementation is just for the purposes of simplicitly and clarity for the C/W 5.
Absolutely not an example of how one should really implement a hash table;
not least because "find" and "delete" are missing !!
The code is not particularly efficient, but we are only using the interpretation:

the cost of an insertion iss considered to be the number of positions in the hash table that were "probed" - i.e. places that were considered.
And so actual runtimes are not used.

There is no need to implement "find" or "delete/remove" - this is done just to try to keep the C/W simple!

*/

import java.util.Random;
//import java.util.Vector;

public class HashMap {
	
	// private Vector<Integer> table;
	private static int N;  // size of the hash table
	private static int[] table;  // the hash table
	private static int filled;  // number of active entries in the hash table

	// initialise the table
	// fill each entry with -1
	// no active entries(filled = 0)
	public static void init() 
	{
		table = new int[N];
		for (int i = 0; i < table.length; i++) 
		{
			table[i] = -1;    //   -1  is taken to indicate an entry that is not used
		}
		filled = 0;
	}
	
	// get the hash code  of a given key
	//If key is 2, then return 2
	public static int hash(int key) 
	{
			return key % N;
	}
	
	/* insert key using linear probing, and increasing one step at a time ("c=1" in the lectures)
	 will scan the entire array - in circular fashion - if it is needed
	 returns the number of probe attempts that were made
	 and acts as the "cost of the insertion" 
	*/
	public static int insert(int key) {
		int h = hash(key);
		int probe = 0;
		
		while ( probe < N ) 
		{
			int i = (h+probe) % N;  // i is the index that will be tried
			System.out.println("i: " + i);
			probe++;
			
			System.out.println("table[i]: " + table[i]);
			if ( table[i] < 0 ) 
			{
				table[i] = key;
				filled++;
				break;
			}
			
		}
		
		return probe;
	}
	
	public static void main(String[] args) {

		// TODO: pick some values of N to study - e.g.
		N = 100;
		//N = 99;
	
		Random rn = new Random();
		
		// worst case sequence of insertions - unrealistic
		if (false) 
		{ 
			init();
			for (int i = 0; i < N ; i++) 
			{
				System.out.println("The " + (i + 1) + " insert time:");
				int cost = insert(2);	//cost = probe
				System.out.println("filled: " + filled + " cost: " + cost);
				System.out.println("");
			}
			
			for (int i = 0; i < table.length; ++i) 
			{
				System.out.printf("%d: %d\n", i, table[i]);
			}
		}
		
		// best case sequence of insertions - unrealistic
		if (false) 
		{  
			init();
			for (int i = 0; i < N ; i++) 
			{
				System.out.println("The " + (i + 1) + " insert time:");
				int cost = insert(i+3);  //cost = probe
				System.out.println("filled: " + filled + " cost: " + cost);
				System.out.println("");
			}
			
			for (int i = 0; i < table.length; ++i) 
			{
				System.out.printf("%d: %d\n", i, table[i]);
			}
						
		}
		
		if (true) 
		{ 

			// arrays for tracking statistics of costs as a function of number of entries BEFORE the insertion
			int[] cumulCost = new int[N];
			int[] worstCost = new int[N];
			int[] bestCost =  new int[N];
			
			// insert max value into each entry of bestCost
			for (int i = 0 ; i < N ; i++ ) 
			{ 
				bestCost[i] = Integer.MAX_VALUE; 
			}
			
			// TODO: pick a value here - larger will give a better estimate of the average
			int numRuns = 1;  
			
			for (int run = 0 ; run < numRuns ; run++ )
			{
				init();
				for (int i = 0; i < N ; i++) 
				{

					// TODO pick the input keys, e.g. one of the these two
					
					int key = rn.nextInt(10000000) ;   // pure random
					//int key = 10*rn.nextInt(1000000) ;    // following a pattern - not uniformly spread out

					int oldFilled = filled;  // stores the number of entries BEFORE the insertion
					int cost = insert(key);
					System.out.println("filled: " + filled + " cost: " + cost);
					System.out.println("");
					
					cumulCost[oldFilled] += cost;
					if ( worstCost[oldFilled] < cost ) 
					{ 
						worstCost[oldFilled] = cost; 
					}
					
					if ( bestCost[oldFilled]  > cost ) 
					{ 
						bestCost[oldFilled]  = cost ; 
					}
					
				}
			}
			
			// print out some statistics - e.g. so can redirect to a file, and then can load into Excel
			for (int i = 0; i < N ; i++) 
			{ 
			  System.out.println( "i: "+ i 
			   + " Average Cost of Insertion: " + ( (float) cumulCost[i])/numRuns  // average cost of insertion
			   + " Worst Cost of Insertion: " + worstCost[i]    // worst cost of insertion
			   + " Best Cost of Insertion: " + bestCost[i]);   // best cost of insertion
			}
		}
	}
}
