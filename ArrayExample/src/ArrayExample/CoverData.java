package ArrayExample;

public class CoverData {
	public static void main(String[] args) {
		int[] List = new int[3];
		
		List[1] = 17;
		
		int[] newlist = List; // newlist points to the same array as list!
		
		newlist[1] = 42;
		
		System.out.println( List[1] );

	}

	//If list is null, the result is that newlist will also be null. 
	//If list points to an array, the assignment statement does not make a copy of the array. 
	//It just sets newlist to refer to the same array as list
}
