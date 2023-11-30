package MyAnswer;

/**This class generates two random values from 1 to 6 for dice1 and dice2.
 * Once the object of this class is created, two random values are assigned to
 * two dices. User can use two getter methods to see the values and use override
 * toString method to see the sum of two dices.
 */
public class PairOfDice {

    private int die1;   // Number showing on the first die.
    private int die2;   // Number showing on the second die.
    
    /**Constructor assigns two random values for dice1 and dice2
     * to initialize the global variables.
     */
    public PairOfDice()
    {
    	die1 = (int)(Math.random()*6) + 1;	//Generate a random value from 1 to 6 to dice1
    	die2 = (int)(Math.random()*6) + 1;	//Generate a random value from 1 to 6 to dice2
    }
    
    /**Getter method which can return the value of dice1
     * to the outer class.
     */
    public int getDice1()
    {
    	return die1;
    }
    
    /**Getter method which can return the value of dice2
     * to the outer class.
     */
    public int getDice2()
    {
    	return die2;
    }
    
    /**Override the toString method in the Object class
     * which can return a different String format that is
     * the sum of two dices. 
     */
    public String toString()
    {
    	return "The sum of die1 and die2 is " + (die1 + die2);
    }

} // end class PairOfDice
