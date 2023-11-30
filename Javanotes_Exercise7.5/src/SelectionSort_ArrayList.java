import java.util.ArrayList;

import textio.TextIO;

/**This class is using the selection sort to sort the user input array.
 * This class depends on the TextIO class.
 * */
public class SelectionSort_ArrayList {

	/**This method is using the selection sort to sort the arraylist.
	 * @param userInputDoubleArrayList the double arraylist that will be used to sort
	 * */
	public static void selectionSort(ArrayList<Double> userInputDoubleArrayList){
		for(int lastPlace = userInputDoubleArrayList.size() - 1; lastPlace > 0; lastPlace--) {
			int maxPlace = 0;
			
			for(int j = 1; j <= lastPlace; j++) {
				if(userInputDoubleArrayList.get(j) > userInputDoubleArrayList.get(maxPlace))
					maxPlace = j;
			}
			
			double tempStoreMaxPlaceValue = userInputDoubleArrayList.get(maxPlace);		//Storing the value of the maximum place in a variable
			double tempStoreLastPlaceValue = userInputDoubleArrayList.get(lastPlace);	//Storing the value of the last place in a variable
			userInputDoubleArrayList.set(lastPlace, tempStoreMaxPlaceValue);	//Setting the value of the maximum place to the last place
			userInputDoubleArrayList.set(maxPlace, tempStoreLastPlaceValue);	//Setting the value of the last place to the maximum place
		}
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
			
			userInputDoubleArrayList.add(userInput);
		}while(true);
		
		System.out.print("\nYour original input will be:");
		printArrayList(userInputDoubleArrayList);
		
		selectionSort(userInputDoubleArrayList);
		
		System.out.print("\nSorted your input will be:");
		printArrayList(userInputDoubleArrayList);
	}

}
