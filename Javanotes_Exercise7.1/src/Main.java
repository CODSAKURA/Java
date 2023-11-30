import java.util.ArrayList;

/**This class is used a subroutine to create an arraylist which size and 
 * element value are decided by the subroutine's argument. Then, it
 * used the main routine to output the arraylist and size of it to 
 * test whether it is correct or not. 
 * */
public class Main {

	/**This subroutine is used to create an arraylist which size and 
	 * elements' value are decided by the argument. The range of each element 
	 * in arraylist is from 1 to an argument which is a specified maximum value. 
	 * Finally, it returns the arraylist which each element in the arraylist is different.
	 * @param n the length of the arraylist
	 * @param max the maximum value of each element's range in the arraylist
	 * @return arraylist an arraylist which each element in the arraylist is different
	 * @throws IllegalArgumentException if max is greater than count.
	 * */
	public static ArrayList<Integer> createArrayList(int n, int max) {
		ArrayList<Integer> list= new ArrayList<Integer>();
		
		if(max < n)
		{
			throw new IllegalArgumentException("Can't have " + n + 
                    " different integers in the range 1 to " + max);
		}
		
		while(list.size() < n)
		{
			int range1ToMax = (int)(max * Math.random()) + 1; 	//Range 1 to max 
			
			/*If the size of arraylist is 0, then adding the value;
			 *If the size of arraylist is exceed argument "n", then break the loop;
			 *Otherwise, testing the argument value: If it is in the arraylist, then
			 *do not add that element, looping until finding a value that is not in
			 *the arraylist.*/
			if(list.size() == 0)
				list.add(range1ToMax);
			else
			{
				if(list.indexOf(range1ToMax) == -1)
				{
					list.add(range1ToMax);
				}			
			}			
		}	
		
		return list;
	}
	
	/**The main subroutine which used to test whether the subroutine has
	 * been worked properly by outputting the result.
	 * */
	public static void main(String[] args) {
		ArrayList<Integer> test = createArrayList(3,3);
		System.out.println("ArrayList is " + test);
		System.out.print("Size: " + test.size());

	}

}
