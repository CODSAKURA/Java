package MyAnswer;

import textio.TextIO;

public class Main {

	public static void main(String[] args) 
	{
		TextIO.putln("This program will evaluate simple expressions.");
		TextIO.putln("[Operators are: +, -, *, and /.]");
		TextIO.put("Enter the expressions or 0 as first number to end:");
		Double firstNumber = TextIO.getDouble();		//Getting the first number
				
		while(true)			//Keep looping until user inputs 0 as first number to end
		{			
			if(firstNumber == 0)		//Checking the first number whether is 0 or not
			{
				System.out.println("OK,GOODBYE!!");
				break;
			}
			else
			{
				char operator = TextIO.getChar();		//Getting the operator
				Double secondNumber = TextIO.getlnDouble();		//Getting the second number
				
				/*Checking which operator has been input.
				 * If it is one of them in the following, then do the calculations;
				 * Otherwise, the program will not understand and ask user to try again.
				 * */
				if(operator == '+')
				{
					System.out.printf("Result: %f\n" , firstNumber + secondNumber);
				}
				
				else if(operator == '-')
				{
					System.out.printf("Result: %f\n" , firstNumber - secondNumber);
				}
				else if(operator == '*')
				{
					System.out.printf("Result: %f\n" , firstNumber * secondNumber);
				}
				else if(operator == '/')
				{
					if(secondNumber == 0)
					{
						System.out.println("Program can not do the calculation:" + "\"" + firstNumber 
														+ operator + secondNumber + "\", as the dividend is 0");
						System.out.println("Try Again!!!");				
						
					}
					else
					{
						System.out.printf("Result: %f\n" , firstNumber / secondNumber);
					}
					
				}
				else
				{
					System.out.println("Sorry, I dont understand the operator "  + "\""+ operator + "\", Try Again!!!");
				}
				
				TextIO.put("Enter another expression or 0 as first number to end:");
				firstNumber = TextIO.getDouble();		

			}		
		}	

	}

}
