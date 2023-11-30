package MyAnswer;

import textio.TextIO;

/**This class ask the user to enter the number which will store in the object of 
 * StatCalc class and then output the numbers, mean, sum, standard deviation, maximum
 * number and minimum number of all the number that are stored in the object of StatCalc
 * class. This class depends on two classes: one is the StatCalc class and the other is
 * TextIO class. 
 * */
public class Main {

	public static void main(String[] args) {

			TextIO.put("Please enter a number that will be stored or 0 to stop: ");
			double input = TextIO.getlnDouble();	//Obtaining the user input
			
			/*Testing whether the user firstly enter 0 or not*/
			
			if(input == 0.0)
			{
				System.out.println("OK, Bye!!");
				System.exit(0);
			}
			else
			{
				StatCalc inputArray = new StatCalc();	//Creating the object of the StatCalc class.
				inputArray.enter(input);
				while(true)
				{
					TextIO.put("Please enter another number that will be stored or 0 to stop: ");
					double inputAgain = TextIO.getlnDouble();
					
					/*If the user have inputed 0 in the loop, then immediately jumped out of the loop.
					 * Otherwise, storing the value using enter method in the StatCalc class.
					 * */
					if(inputAgain == 0.0)
					{
						break;
					}
					inputArray.enter(inputAgain);										
				}
				
				/*Outputting all the details that user probably needed for the input*/
				
				System.out.println("Well, below are all the details that you want to know:");
				System.out.println("Numbers in the array: " + inputArray.getCount());				
				System.out.printf("Sum of the array: %.1f\n" , inputArray.getSum());
				System.out.printf("Mean of the array: %.1f\n" , inputArray.getMean());
				System.out.printf("Standard Deviation of the array: %.1f\n" , inputArray.getStandardDeviation());
				System.out.println("Maximum Number in the array: " + inputArray.getMax());
				System.out.print("Minimum Number in the array: " + inputArray.getMin());
				
			}

	}

}	//end of the Main class
