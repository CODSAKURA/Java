import java.util.ArrayList;
import textio.TextIO;

/**This class will let user to input a file. Then the program will
 * read the file content and obtain all the different words appeared
 * in the file. The program will remove the duplicate words during the
 * obtaining word progress. It will save those word in an arraylist and 
 * it will sort the arraylist using the selection sort and then it will 
 * write the output in the output file. The output file is selected by
 * the user. This class is depened on the TextIO class.
 * */
public class Main {

	/**
	 * Read the next word from TextIO, if there is one.  First, skip past
	 * any non-letters in the input.  If an end-of-file is encountered before 
	 * a word is found, return null.  Otherwise, read and return the word.
	 * A word is defined as a sequence of letters.  Also, a word can include
	 * an apostrophe if the apostrophe is surrounded by letters on each side.
	 * @return the next word from TextIO, or null if an end-of-file is 
	 *     encountered
	 */
	private static String readNextWord() {
	   char ch = TextIO.peek(); // Look at next character in input.
	   while (ch != TextIO.EOF && ! Character.isLetter(ch)) {
	          // Skip past non-letters.
	      TextIO.getAnyChar();  // Read the character.
	      ch = TextIO.peek();   // Look at the next character.
	   }
	   if (ch == TextIO.EOF) // Encountered end-of-file
	      return null;
	   // At this point, we know the next character is a letter, so read a word.
	   String word = "";  // This will be the word that is read.
	   while (true) {
	      word += TextIO.getAnyChar();  // Append the letter onto word.
	      ch = TextIO.peek();  // Look at next character.
	      if ( ch == '\'' ) {
	            // The next character is an apostrophe which is ['].  
	    	    // Caution: char for ['] is '\''; string for ['] is "\'".
	    	    // Read it, and if the following character is a letter, 
	    	    // add both the apostrophe and the letter onto the word 
	    	    // and continue reading the word.  If the character after 
	    	    // the apostrophe is not a letter, the word is done, so 
	    	    // break out of the loop.
	         TextIO.getAnyChar();   // Read the apostrophe.
	         ch = TextIO.peek();    // Look at char that follows apostrophe.
	         if (Character.isLetter(ch)) {
	            word += "\'" + TextIO.getAnyChar();
	            ch = TextIO.peek();  // Look at next char.
	         }
	         else
	            break;
	      }
	      if ( ! Character.isLetter(ch) ) {
	            // If the next character is not a letter, the word is
	            // finished, so break out of the loop.
	         break;
	      }
	      // If we haven't broken out of the loop, next char is a letter.
	   }
	   return word.toLowerCase();  // Convert the word to lower case and return that word that has been read.
	}
	
	/**
	 * This method is using the selection sort to sort an string array.
	 * @param A a string array
	 * */
	public static void selectionSort(ArrayList<String> arrayList) {
	      // Sort A into increasing order, using selection sort
	      
	   for (int lastPlace = arrayList.size()-1; lastPlace > 0; lastPlace--) {
	         // Find the largest item among A[0], A[1], ...,
	         // A[lastPlace], and move it into position lastPlace 
	         // by swapping it with the number that is currently 
	         // in position lastPlace.
	         
	      int maxLoc = 0;  // Location of largest item seen so far.
	      
	      for (int j = 1; j <= lastPlace; j++) {
	         if (arrayList.get(j).compareTo(arrayList.get(maxLoc)) > 0) {
	               // Since A[j] is bigger than the maximum we've seen
	               // so far, j is the new location of the maximum value
	               // we've seen so far.
	            maxLoc = j;  
	         }
	      }

	      String tempStoreMaxPlaceValue = arrayList.get(maxLoc);		//Storing the value of the maximum place in a variable
	      String tempStoreLastPlaceValue = arrayList.get(lastPlace);	//Storing the value of the last place in a variable
	      arrayList.set(lastPlace, tempStoreMaxPlaceValue);	//Setting the value of the maximum place to the last place
	      arrayList.set(maxLoc, tempStoreLastPlaceValue);	//Setting the value of the last place to the maximum place
	      
	   }  // end of for loop
	   
	}
	
	/**This is the main method that is used to do the work on the methods.
	 * It will let the user to select the input file and the program will
	 * sort the content of file, remove the duplicate and write the different
	 * words appeared in the input file to the output file. The output file
	 * which is also selected by the user.
	 * @param args the command line argument for this program
	 * */
	public static void main(String[] args) {
		/*Reading the input file and create an arraylist to store the word*/
		TextIO.readUserSelectedFile();		
		ArrayList<String> wordArrayList = new ArrayList<String>();
		
		String word = readNextWord();
		while(word != null) {
			
			/*Checking whether there is a word already existed in the arraylist 
			 * before adding the word.
			 * indexOf() will returns the index of the first occurrence of the 
			 * specified element in this list, or -1 if this list does not contain 
			 * the element. */
			if(wordArrayList.indexOf(word) == -1)
				wordArrayList.add(word);
			word = readNextWord();
		}
		
		/*Sorting the arraylist*/
		selectionSort(wordArrayList);
		
		/*Write all the element in the arraylist to the output file*/
		TextIO.writeUserSelectedFile();
		TextIO.put(wordArrayList.size() + " different words in the file:\n");
		for(String item: wordArrayList)
			TextIO.put(" " + item + "\n");
	}
}
