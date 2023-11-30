package Task2;

/** COMP2009-ACE 2020-21 ADE CW 4  Heaps and Heap sort
 */
 
import java.util.Random;
 
public class MainHeap
{
	public static void main(String[] args) {

		int numRuns = 1; // TODO change ths as you want
		for (int size = 1 ; size <= 10 ; size ++  ) {   // chance the limit as you want - 10 is too small !
			for (int run = 0 ; run < numRuns ; run++ ) {
				int[] keys = new int[size];
				
				initArray(keys);
				
				int count = heap2Sort(keys);
				
				// CHECK VALUES WERE CORRECTLY SORTED - CAN USE TO VERIFY YOUR HEAP2 CODE
				for (int i = 0 ; i < size ; i++ ) { 
					if ( run == 0 && keys[i] != i ) {
						System.out.println("ERROR i=" + i + " keys[i]= " + keys[i]); 
					}
				}

				System.out.println(size + " " + count );
			}
			
			// if you want you can extend the code here to compute best/worst cases, and print them out
		}
		
		
	}
	
	// initialises the set of keys as being { 0 , ... size-1 } i.e. all the keys but not necessarily in the right order :-)
	public static void initArray(int[] keys) 
	{
		// fill the array in precisely reverse order.
		int size = keys.length;
		for (int i = 0 ; i < size ; i++ ) { 
			keys[i] = size-1-i; 
		}
		
		// might also shuffle here - might want to initially try it without shuffling, then shuffle in later experiments
		if (false) {
			Random random = new Random();

			// NOTE the idea in a correct shuffle is to pick each entry randomly from the remaining entries (including itself)
			for (int i = 0 ; i < size ; i++ ) { 
				int s = i + random.nextInt(size-i); // i==s is allowed - as a shuffle does not have to move every element

				// swap keys[i] and keys[s]
				int tmp = keys[i];
				keys[i] = keys[s];
				keys[s] = tmp;
			}
		}

	}	
	
	public static int heap2Sort(int[] array)
	{
		Heap2 pq = new Heap2(array.length);
		for(int key : array)
		{
			pq.insert(key);
		}
	
		// extract from the heap, and refill the array
		for(int i = 0; i < array.length; i++)
		{
			array[i] = pq.removeMin();
		}
		return pq.count;
	}

}
