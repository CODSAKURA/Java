package staticglobalvariable;

import java.util.Scanner;


//related to guessing game file
public class Staticglobalvariable {
		
	 public static int gamesPlayed = 0;   // The number of games the user played.Global variable
	 public static int gamesWon = 0;      // The number of games the user won.Global variable	 
	 								  //因为这两个variable主函数和playGame函数都要用到所以设置为Global variable这样这两个函数都能access variables
//static可以用来优化程序性能，是因为它的特性:只会在类加载的时候执行一次。因此，很多时候会将一些只需要进行一次的初始化操作都放在static代码块中进行。
	
	 public static void playGame() {
		
	       
	       int usersGuess;      
	       int computersNumber = (int)(100 * Math.random()) + 1;

	       int guessCount = 0;
	       System.out.print("What is your guess? ");
	       gamesPlayed++;  // Count this game
	       
	       while (true) 
	       {
	    	  Scanner input = new Scanner(System.in);
	          usersGuess = input.nextInt();
	          guessCount++;
	          
	          if (usersGuess < computersNumber)
	          {
	        	  System.out.print("That's too low.  Try again: ");
	          }
	          else if (usersGuess > computersNumber)
	          {
	              System.out.print("That's too high.  Try again: ");
	          }

	          if (usersGuess == computersNumber) 
	          {
	             System.out.println("You got it in " + guessCount + " guesses!  My number was " + computersNumber);
	             gamesWon++;  // Count this win
	             break;
	          }
	          
	          if (guessCount == 6) 
	          {
	             System.out.println("You didn't get the number in 6 guesses.");
	             System.out.println("You lose.  My number was " + computersNumber);
	             break;
	          }
	       }
	   } 
	   
	   
	   public static void main(String[] args) 
	   {
		      
		   System.out.println("Let's play a game.  I'll pick a number between");
		   System.out.println("1 and 100, and you try to guess it.");
		   String playAgain;
		   
		   do {
			   playGame();
		       System.out.print("Would you like to play again? ");
		       Scanner input = new Scanner(System.in);
		       playAgain = input.next();
		      } while (playAgain.equals("yes"));
		   
		   System.out.println("You played " + gamesPlayed + " games,");
	       System.out.println("and you won " + gamesWon + " of those games.");
		   System.out.println("Thanks for playing.  Goodbye.");
		   }

}

