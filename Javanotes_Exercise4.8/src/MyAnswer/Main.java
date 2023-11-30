package MyAnswer;

import textio.TextIO;

/**This program test user with ten addition questions 
 * and then show the result of each question whether the user
 * has responded correctly or not. If not, what is the correct answer
 * for that question. Finally, the program will output the grade that 
 * the user got of all correct questions. This program depends on a 
 * non-standard class called TEXTIO which is included in textio package.
 * */
public class Main {	
	
	private static int[] firstNumberArray = new int[10];	//Array variable stores all the first number of each question.
	
	private static int[] secondNumberArray = new int[10];	//Array variable stores all the second number of each question.
	
	private static int[] userAnswerArray = new int[10];		//Array variable stores all the user response of each question.
	
	/**The main subroutine asks the user whether he/she wants
	 * to start the test or not. If yes, using createTheTest() routine,
	 * administerTheTest() routine and gradeTheTest() routine to do the test
	 * for the user. If no, just print a message and quit the program.
	 * */
	public static void main(String[] args){
		
		TextIO.putln("Hi! Welcome to this test!");
		TextIO.put("Entering \"y\" or \"n\" to start or end the test:");
		boolean userFirstResponse = TextIO.getlnBoolean();		//Getting the user response

		if(userFirstResponse)
		{
			createTheTest();
			administerTheTest();
			gradeTheTest();
		}
		else
		{
			System.out.print("Sorry to hear that.... Bye....");
		}

	}	//End of the main subroutine
	
	/**This subroutine will create the first number and second number of each question 
	 * and store them in firstNumberArray array global variable and secondNumberArray array
	 * global variable.
	 * */
	public static void createTheTest()
	{
		for(int i = 0; i < 10; i++)
		{
			int firstNumber = (int)(15 * Math.random());	//Generating a random value which range from 0 to 14
			firstNumberArray[i] = firstNumber;				//and store it in a variable. And then, store it into the 
															//array global variable.This value is the first number
															//of a question
			
			int secondNumber = (int)(15 * Math.random());	//Generating another random value which range from 0 to 14 
			secondNumberArray[i] = secondNumber;			//and store it in an another variable. And then, store it  
															//into the array global variable. This value is the second 
															//number of a question.
		}//End of the for loop
		
	}//End of the createTheTest subroutine
	
	/**This subroutine will output all the numbers that are stored in firstNumberArray and 
	 * secondNumberArray array variables in a specific format and obtain the user responses
	 * of each question. After that, store the user response of each question into an array 
	 * global variable called userAnswerArray. 
	 * */
	public static void administerTheTest()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.print(firstNumberArray[i] + " + " + secondNumberArray[i] + "=");
			int userAnswer= TextIO.getlnInt();		//Getting the user response of each question
			userAnswerArray[i] = userAnswer;		//and store it in a variable and then store it into
													//the array global variable.
		}
	}
	
	/**This subroutine will output the correct or wrong result of each question.
	 * If the user response of a question is correct, then output it with a sentence
	 * says "[Correct]". If it is wrong, then output it with a sentence says "[Wrong ()]"
	 * and inside the bracket print the correct answer of it. During this progress, once
	 * the user got wrong, it will reduce the total grade 100 by 10. Finally, it will
	 * output the total grade that user have got. 
	 * */
	public static void gradeTheTest()
	{
		int fullGrade = 100;
		
		System.out.println("Grading......");
		for(int i = 0; i < 10; i++)
		{
			if((firstNumberArray[i] + secondNumberArray[i]) != userAnswerArray[i])
			{
				System.out.println(firstNumberArray[i] + " + " + secondNumberArray[i] + " = " + userAnswerArray[i] + 
						"[Wrong (" + (firstNumberArray[i] + secondNumberArray[i]) + ")]");

//				Clear version of printing:
//				System.out.printf("%d + %d = %d [Wrong (%d)]\n", firstNumberArray[i], 
//						secondNumberArray[i], userAnswerArray[i], (firstNumberArray[i] + secondNumberArray[i]));				
				
				fullGrade = fullGrade - 10;
			}
			else
			{
				System.out.println(firstNumberArray[i] + " + " + secondNumberArray[i] + " = " + userAnswerArray[i] + "[Correct]");
			}
		}
		
		System.out.println("Your Total Grade is " + fullGrade);
	}

}
