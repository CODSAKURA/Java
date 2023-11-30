package MyAnswer;

import textio.TextIO;

/**This program test user with ten questions includes addition and
 * subtraction and guessing number and then show the result of each question 
 * whether the user has responded correctly or not. If not, what is the 
 * correct answer for that question. Finally, the program will output the grade 
 * that the user got of all correct questions. This program depends on a 
 * non-standard class called TEXTIO which is included in textio package, an 
 * AddtionQuestion class, IntQuestion interface and SubtractionQuestion class.
 * */
public class Main {	
	
	private static IntQuestion[] IntQuestionArray = new IntQuestion[10];	//Array variable stores all the objects that implements IntQuestion interface.
	
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
	
	/**This subroutine will create 10 questions include addition and
	 * subtraction and guessing number and store them in IntQuestionArray 
	 * array global variable. Which type of questions will be stored in a
	 * place of array is decided by random number. 1 is addition number; 2
	 * is subtraction number; 3 is guessing number.
	 * */
	public static void createTheTest()
	{
		for(int i = 0; i < 10; i++)
		{
			int randomNumber = (int)(3 * Math.random()) + 1;
			if(randomNumber == 1)
			{
				IntQuestionArray[i] = new AdditionQuestion();
			}
			else if(randomNumber == 2)
			{
				IntQuestionArray[i] = new SubtractionQuestion();
			}
			else
			{
				IntQuestionArray[i] = new IntQuestion() {
				    public String getQuestion() {
				        return "Guess a number from 1 to 6?";
				    }
				    public int getCorrectAnswer() {
				        return ((int)(6 * Math.random()) + 1);
				    }
				};
			}
		
		}//End of the for loop
		
	}//End of the createTheTest subroutine
	
	/**This subroutine will output all the questions that the user need to answer and obtain the user 
	 * responses of each question. After that, store the user response of each question into an array 
	 * global variable called userAnswerArray. 
	 * */
	public static void administerTheTest()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.print(IntQuestionArray[i].getQuestion());
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
			if(IntQuestionArray[i].getCorrectAnswer() != userAnswerArray[i])
			{
				System.out.println(IntQuestionArray[i].getQuestion() + " = " + userAnswerArray[i] + 
						"[Wrong (" + (IntQuestionArray[i].getCorrectAnswer()) + " is Correct)]");		
				
				fullGrade = fullGrade - 10;
			}
			else
			{
				System.out.println(IntQuestionArray[i].getQuestion() + " = " + userAnswerArray[i] + "[Correct]");
			}
		}
		
		System.out.println("Your Total Grade is " + fullGrade);
	}

}
