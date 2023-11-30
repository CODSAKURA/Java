package MyAnswer;

import textio.TextIO;

public class Main {

	public static void main(String[] args) 
	{
		TextIO.putln("Please enter your first name and last name, separated by a space.");
		TextIO.put("? ");
		String input = TextIO.getln();	//Get the user input
		
		int spacePosition = input.indexOf(' ');		//Find the space position		
		
		String firstName = input.substring(0 , spacePosition);		//First Name position
		String lastName = input.substring(spacePosition + 1, input.length());	//Second Name Position
		
		System.out.println("Your first name is " + firstName + 
				", which has " + firstName.length() + " characters");
		
		System.out.println("Your last name is " + lastName + 
				", which has " + lastName.length() + " characters");
		
		/*Here I convert all letters to upper case and then print out*/
		System.out.println("Your intials are " + 
				firstName.toUpperCase().charAt(0) + lastName.toUpperCase().charAt(0));	
	}

}
