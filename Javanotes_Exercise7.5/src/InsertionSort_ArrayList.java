import java.util.ArrayList;

import textio.TextIO;

/**This class is using insertion sort to sort the user input. Caution :when 
 * the user has started inputting a new value, it will then start to sort the 
 * arraylist. This class is depended on the TextIO class. 
 * */
public class InsertionSort_ArrayList {

	/**This method is using the insertion sort to sort the arraylist. It is
	 * calling each time when the user has inputed an element.
	 * @param userInput the current user input value
	 * @param userInputDoubleArrayList the arraylist that has been stored the user input
	 * */
	public static void insertionSort(Double userInput, ArrayList<Double> userInputDoubleArrayList){
		int location = userInputDoubleArrayList.size() - 1;		//Starting from the last element in the arraylist
		
		while(location >= 0 && userInputDoubleArrayList.get(location) > userInput) {
			userInputDoubleArrayList.add(location + 1, userInputDoubleArrayList.get(location));	//Moving bigger value to the next position.
			userInputDoubleArrayList.remove(location);	//Removing the original position of the bigger value, it will always make a position empty.
			location = location - 1;	//Getting the previous position of the original position of the bigger value.
		}
		userInputDoubleArrayList.add(location + 1, userInput);	//Adding the value to the empty position.
	}
	
	/**This method is used to print the elements in the arraylist in a 
	 * specific format.
	 * @param doubleArrayList the arraylist that will be printed
	 * */
	public static void printArrayList(ArrayList<Double> doubleArrayList) {
		for(Double item: doubleArrayList)
			System.out.print(" " + item);
	}
	
	/**The main method will obtain the user inputs and store it in the arraylist.
	 * Then it will use the selection sort to sort that arraylist. Finally, it will
	 * print both original unsorted array and sorted array.
	 * @param args the command line arguments for this program.
	 * */
	public static void main(String[] args) {
		ArrayList<Double> userInputDoubleArrayList = new ArrayList<Double>();
		
		do {
			TextIO.put("Enter a positive number(0 ends):");
			double userInput = TextIO.getlnDouble();	
			
			if(userInput == 0.0)
				break;
			
			insertionSort(userInput, userInputDoubleArrayList);
		}while(true);
		
		System.out.print("\nSorted your input will be:");
		printArrayList(userInputDoubleArrayList);
	}
}
