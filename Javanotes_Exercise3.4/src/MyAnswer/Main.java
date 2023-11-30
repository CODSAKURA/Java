package MyAnswer;

import textio.TextIO;

public class Main {

	public static void main(String[] args) 
	{
		TextIO.put("Enter a sentence:");
		
		String input = TextIO.getln();		//Getting the user input
		char[] inputArray = input.toCharArray();	//Changing the user input into an array
		
		for(int i = 0; i < input.length(); i++)		//Check each letter of the user input
		{
			/*If the letter is a letter(A-Z,a-z), then print that letter without change line*/
			if(Character.isLetter(inputArray[i]))	
			{
				System.out.print(inputArray[i]);
			}
			
			/*If the program has changed line previously and the next letter is also a symbol that need to change line, then the program do nothing*/
			else if(Character.isLetter(inputArray[i - 1]) == false && Character.isLetter(inputArray[i])== false) 	
			{
				continue;
			}
			
			/*An apostrophe(') can be considered to be part of a word if there is a letter on each side of the apostrophe.
			 * Example: If a sentence has "that's", then print "that's", not "that" "s".
			 * If a sentence has "that'",then only print "that" as there is no letter on the right side of apostrophe(').
			 * */
			else if(inputArray[i] == '\'' && Character.isLetter(inputArray[i - 1]) && Character.isLetter(inputArray[i + 1]))
			{
				System.out.print("'");
			}
			
			/*If a letter is not a letter(A-Z,a-z), then change to a new line. */
			else 
			{
				System.out.println();
			}
		}

	}

}
