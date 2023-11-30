package MyAnswer;

import textio.TextIO;

/**
 * This class is used to change a sentence to a capitalised version sentence.
 * Caution: the input sentence must be all characters are letter. 
 * If there is a non-letter occurred in a sentence, then the system will not change the system to capitalised,
 * instead it will find it and output it and output it location. The program was written to test printCapitalized subroutine.
 * It depends on the non-standard TextIO class.
 * */

public class Main {

	/**
    *  Print a copy of a string to standard output, with the first letter
    *  of each word in the string changed to upper case.
	 * @param input the user input string that is to be output in capitalised form
	 */
	public static void printCapitalized( String input )
	{
		/*This array contains all non-letter characters.*/
		char[] errorWord = new char[input.length()];
		
		/*This array contains all non-letter characters' locations.*/
		int[] errorLocation = new int[input.length()];
		
		/*This is used to determine different output format for both non-letter sentence and letter sentence.*/
		int count = 0;
		
		/*This subroutine check whether a sentence all characters(except the last one) are letter or not.
		 * If a sentence contains non-letter character in middle then output it and output its location.
		 * */
		for(int i = 0; i < input.length() - 1; i++)
		{
			if(input.charAt(i) != 32 && Character.isLetter(input.charAt(i)) != true)
			{
				errorWord[i] = input.charAt(i);
				errorLocation[i] = i + 1;
				count++;
			}
		}
		
		/*Output different output format for both non-letter sentence and letter sentence.*/
		if(count == 0)
		{
			System.out.println("Your have inputted a sentence contains Letters");
			System.out.println("Good Job!");
			System.out.println("Now changing it to a capitaqlized version:");
			System.out.print(input + " -> ");
			
			for(int i = 0 ; i < input.length(); i++)
			{
				/*Why using try catch?: 
				 * Because it will occurred IndexOutOfBounding Exception.
				 * For Example: if input is "Hello ", there is a space in the end, so when the program
				 * try to upper the next letter after space. It will find an error. Therefore, using try catch
				 * in order to not output that exception instead of quit the program as it reach the end of the string.
				 * */
				try
				{
					if(input.charAt(i) == 32)
					{
						System.out.print(input.charAt(i));
						System.out.print(Character.toUpperCase(input.charAt(i+1)));
						i++;
					}
					else
					{
						if(i == 0)
						{
							System.out.print(Character.toUpperCase(input.charAt(0)));
						}
						else
						{
							System.out.print(input.charAt(i));
						}
					}
					
				}catch(IndexOutOfBoundsException ex)
				{
					System.exit(0);
				}

			}		
		}
		else
		{
			System.out.println("You have inputted a non-letter sentence!!!");
			System.out.println("The followings are the non-letter occured and location:");
			for(int i = 0 ; i < errorWord.length; i++)
			{
				/*Null character of char in java is \0*/
				if(errorWord[i] == '\0' && errorLocation[i] == 0)
				{
					continue;
				}
				else
				{
					System.out.println("Non-letter character: " + errorWord[i] + "  Location: " + errorLocation[i]);
				}
				
			}
		}
	}
	
	
	public static void main(String[] args) 
	{
		TextIO.put("Enter a sentence:");
		printCapitalized(TextIO.getln());

	}

}
