package RollTwoPairs;

public class RollTwoPairs {
    public int die1;   // Number showing on the first die.
    public int die2;   // Number showing on the second die.  

    public void roll() {
            // Roll the dice by setting each of the dice to be
            // a random number between 1 and 6.
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }
    
    public static void main(String[] args) {
        
        RollTwoPairs firstDice = new RollTwoPairs();;  // Refers to the first pair of dice.
        
        RollTwoPairs secondDice = new RollTwoPairs();; // Refers to the second pair of dice.
        
        int countRolls = 0;   // Counts how many times the two pairs of
                         	 //    dice have been rolled.
        
        int total1;      // Total showing on first pair of dice.
        int total2;      // Total showing on second pair of dice.
       
        
        do {  // Roll the two pairs of dice until totals are the same.
        
            firstDice.roll();    // Roll the first pair of dice.
            total1 = firstDice.die1 + firstDice.die2;   // Get total.
            System.out.println("First pair comes up  " + total1);
            
            secondDice.roll();    // Roll the second pair of dice.
            total2 = secondDice.die1 + secondDice.die2;   // Get total.
            System.out.println("Second pair comes up " + total2);
            
            countRolls++;   // Count this roll.
            
            System.out.println();  // Blank line.
            
        } while (total1 != total2);
        
        System.out.println("It took " + countRolls + " rolls until the totals were the same.");
        
    } // end main()
}
