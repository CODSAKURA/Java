package MyAnswer;

import textio.TextIO;

public class Main {

	public static void main(String[] args) 
	{
		TextIO.put("What is your name: ");
		
		String input = TextIO.getln();	//Get user input	
		String inputUpper = input.toUpperCase();	//Convert to Upper Case
		
		TextIO.put("Hello," + inputUpper + ",nice to meet you");

	}

}
