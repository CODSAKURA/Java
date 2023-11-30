package MyAnswer;

/**This class will keep creating the object of PairOfDice until
 * it finds the sum of two dices equals to 2. Then, it will output 
 * the times that the system takes. 
 * */
public class RollTwoPairs {

	public static void main(String[] args) {

		int count = 0;	//The times of rolling
		boolean outcome = false;	//Once the sum of two dices is 2, 
								    //then this value will set to true.
		do {
			PairOfDice dice = new PairOfDice();	//Generating the object of PairOfDice class
												//which means, generating two random values for two dices. 
			System.out.println(dice);
			count++;
			if((dice.getDice1() + dice.getDice2()) == 2 )
			{
				outcome = true;
			}
		}while(!outcome);

		System.out.println("It takes " + count + " times to get the sum 2 of two dices.");
	}

}	//end of Class RollTwoPairs
