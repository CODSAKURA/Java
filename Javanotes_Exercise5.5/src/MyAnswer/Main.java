package MyAnswer;

import textio.TextIO;

/**This class will perform a simple version of Blackjack as it played in a casino.
 * The computer will acts as the dealer. One more function has been added to this program 
 * is that the user will have 100 dollars and the user can make bargain for each game. If 
 * the user lose the game, 100 dollars will be deleted by the bargain price. The game will 
 * end if the user has ran out of money and it will ask user whether he wants to play another 
 * game or not. If the user win the game, 100 dollars will be added by the bargain price. Each
 * game there will be a new random 52 cards that are generated. This class will depend on Card 
 * class, Deck class, Hand class, BlackjackHand class and TextIO class.
 * */
public class Main {

	private static BlackjackHand userHands = new BlackjackHand();	//Generating a hand for user
	private static BlackjackHand dealerHands = new BlackjackHand();	//Generating a hand for dealer
	private static Deck dk;	//Generating a hand for dealer
	
	public static void main(String[] args)
	{
		TextIO.put("Playing a game with me? (y or n):");
		boolean userResponse = TextIO.getlnBoolean();	//Obtaining the user response
		
		/*If user response is positive, then jump into the loop.
		 * If user response is negative, then print the message and quit.
		 * */
		while(userResponse)
		{
			/*Decisions decided by the checkUserBargain method:
			 * If it returns positive, it means the user have ran out money and ask user whether he
			 * wants to play another game or not.
			 * If it returns negative, it means the user does not ran out money but he wants to take the
			 * money and quit the game.*/
			if(checkUserBargain(userResponse))
			{
				System.out.println("Oops! You have run out of money!");
				TextIO.put("\nPlay Another Game? (y or n):");
				userResponse = TextIO.getlnBoolean();
			}
			else
			{
				System.exit(0);
			}
		}
		System.out.println("OK!!!Have a Nice Day!!!");
		System.exit(0);
	}

	/**This method is used to check the user input for bargain. If the user has inputed an invalid value 
	 * for bargain, then it will keep asking the user for the bargain price until the user has inputed
	 * a valid one. If the user has inputed a valid value, then let the user to play the game, 
	 * if the user win the game then add the bargain to the user money which is 100 dollars. If the 
	 * user lose the game then delete the bargain from the user money. During this progress, If the user
	 * has ran out of the money, then quit this method by returning true to the main routine to 
	 * print the message and ask the user whether the user want to play another game or not. If the 
	 * user does not want to continue the game during the progress, it will print the message and quit 
	 * this method by returning false to the main routine in order to let main routine exit the system.
	 * @param userResponse the boolean value given from the main routine but it will be changed in this method.
	 * @return true if the user has ran out the money
	 * @return false if the user does not want to continue the game during the progress and wants to quit the game
	 * */
	private static boolean checkUserBargain( boolean userResponse ) {
	
		double userMoney = 100.0;	//Generating the initial price for the user which is 100 dollars
		TextIO.putln("\nYou have [" + userMoney + "] dollars in your pocket currently.");
		
		/*The variable userResponse will be false at the end of the loop as the user does not want
		 * to continue the game instead he wants to take the money and quit the game*/
		while(userResponse)
		{
			TextIO.put("Your bargain for this game:");
			double userBargain = TextIO.getlnDouble();			
			System.out.println();
			
			/*Checking the user input for bargain whether it is valid or not.
			 * If valid, play the game.
			 * If not valid, ask the user to input the bargain again
			 * */
			if(userBargain > userMoney || userBargain <= 0)
			{
				System.out.println("Your bargain is invalid. Try again!");
				continue;
			}
			else
			{
				if(playGame())
				{
					userMoney = userMoney + userBargain;
					System.out.println("[-----Your Value: " + userHands.getBlackjackValue() + " [V/S] Dearler Value: " + dealerHands.getBlackjackValue() + "-----]");
					System.out.println("Result: YOU wins");
					System.out.println("You have [" + userMoney + "] dollars now.");
				}
				else
				{
					userMoney = userMoney - userBargain;
					System.out.println("[-----Your Value: " + userHands.getBlackjackValue() + " [V/S] Dearler Value: " + dealerHands.getBlackjackValue() + "-----]");
					System.out.println("Result: DEALER wins");
					System.out.println("You have [" + userMoney + "] dollars now.");
					
					if(userMoney <= 0)
					{
						return true;	//If the user have ran out the money, immediately quit the method and 
										//return true to the main routine.
					}
				}
			}		
			
			TextIO.put("\nAgain? (y or n):");
			userResponse = TextIO.getlnBoolean();
		}
		System.out.println("You take [" + userMoney + "] dollars and Run Away!!!!!.");
		System.out.println("Well, Have a Nice Day!!!");
		return false;	//As the user does not want to continue the game instead the user wants to 
						//takes the money and ran away, then return false to the main routine to quit the
						//system.
	}
	
	/**This method generates a random 52 cards and add cards to both dealer and user hands.
	 * Also, it will check whether the initial two assign cards to both dealer or user hands are equal to 21. 
	 * If the total values of initial two assign cards of user is equal to 21, then immediately stop the game 
	 * and return true as the user win.If the total value of dealer cards is equal to 21,then immediately stop 
	 * the game and return false as the dealer win.Besides, if both user hands cards value and dealer hands cards 
	 * value are 21, then return false as dealer wins. If it does not reach any cases described above, then do 
	 * the progress normally.
	 * @return false the dealer wins
	 * @return true the user wins
	 * */
	private static boolean playGame()
	{
		dk = new Deck();	//Generating 52 cards in a sorted order without two jokers
		dk.shuffle();	//Making 52 cards in a random order
				
		userHands.clear();	//Initialing the user hand in case there are some cards on the hands
		dealerHands.clear(); //Initialing the dealer hand in case there are some cards on the hand
		
		/*Adding two cards to both dealer and user hands*/
		for(int i = 0; i < 2; i++)
		{
			/*Adding the cards to the user hands*/
			userHands.addCard(dk.dealCard());			

			/*Adding the cards to the dealer hands*/
			dealerHands.addCard(dk.dealCard());			
		}
		
		/*We can decide the dealer cards value first. Because once dealer gets 21,
		 *no matter what the total cards value in user hands are, dealer wins.
		 *So, we can do this without adding more codes like this (dealerHands.getBlackjackValue == 21 && userHands.getBlackjackValue == 21).
		 **/
		if(dealerHands.getBlackjackValue() == 21)
		{
			showCards(true);
			return false; //Dealer wins
		}
		else if(userHands.getBlackjackValue() == 21)
		{
			showCards(true);	
			return true;//User wins
		}
		else
		{
			showCards(false);
			return(playInMoreDetail());
		}
	}
	
	/**This method will do all the steps about hitting and standing."Hit", which means to add another card to her hand,
	 * or to "Stand", which means to stop taking cards.If the user Hits, there is a possibility that the user will go over 21. 
	 * In that case, the game is over and the user loses. If not, then the process continues. The user gets to decide again 
	 * whether to Hit or Stand.If the user Stands, the game will end, but first the dealer gets a chance to draw cards.
	 * The dealer only follows rules, without any choice. The rule is that as long as the value of the dealer's hand is 
	 * less than or equal to 16, the dealer Hits (that is, takes another card). The user should see all the dealer's cards 
	 * at this point. Now, the winner can be determined: If the dealer has gone over 21, the user wins. Otherwise, if the 
	 * dealer's total is greater than or equal to the user's total, then the dealer wins. Otherwise, the user wins.
	 * @return false Dealer wins
	 * @return true User wins
	 * */
	private static boolean playInMoreDetail()
	{
		System.out.print("Hits or Stands?:");
		boolean chooseH = false;	//The decision for keep doing the do..while loop or not
		String userResponse;
		
		do {			
			userResponse = TextIO.getln();			
			switch(userResponse)
			{
				case "Hit", "H", "h" -> 
				{
					userHands.addCard(dk.dealCard());
					
					/*The statement in if will jump back to the call this method statement as return existed.
					 *The statement in else we make chooseH to true as we want to jump to the beginning of the do..while loop.
					 *Therefore, we make chooseH to true.*/
					if(userHands.getBlackjackValue() > 21)
					{
						showCards(true);
						return false;	//Dealer wins
					}
					else
					{					
						showCards(false);
						System.out.print("Hits or Stands?:");
						chooseH = true;
					}
				}
				
				/*In this case, as we want to jump out of the switch, so we in all the cases we have to make sure chooseH is false. 
				 *So, we make it to false after the if statement.*/
				case "Stand", "S", "s" -> 
				{
					if(dealerHands.getBlackjackValue() <= 16)
					{
						dealerHands.addCard(dk.dealCard());				
					}
					
					if(dealerHands.getBlackjackValue() > 21)
					{
						showCards(true);
						return true;	//User wins
					}
					chooseH = false;
				}
				
				/*If the user does not enter either H or S, then as the user to enter again.
				 *Therefore, we make chooseH to true to do that.*/
				default ->
				{
					System.out.println("Unreadable Response!!!!! Try Again!!!!");
					System.out.print("Hits or Stands?:");
					chooseH = true;
				}
			}			
			
		}while(chooseH);	
		
		/*Because when we enter the S, the computer will do something if its hands is less than or equal to 16.
		 *Then, the computer shows all the cards of both computer and user have and print out the result.
		 *Therefore, the below statements are used for steps after the computer jump of the do..while loop and switch statment.*/
		showCards(true);
		if(dealerHands.getBlackjackValue() >= userHands.getBlackjackValue())
		{
			return false;	//Dealer wins
		}
		else
		{
			return true;	//User wins
		}
	}
	
	/**This method is used to show the cards in both user hands and dealer hands.It will shows
	 * all the cards in user hands.But,there are two ways of showing dealer cards which is decided 
	 * by the parameter. If the parameter is false, it will shows one of the cards value to the 
	 * user and the other is covered by "*". If the parameter is true, then it will show all the
	 * cards value of the dealer hands to the user.
	 * */
	private static void showCards( boolean showAllOrNot)
	{
		/*Printing all the cards in user hands*/
		System.out.print("\nYour Cards Value:");
		for(int i = 0 ; i < userHands.getCardCount(); i++)
		{
			System.out.printf("%21s",userHands.getCard(i));
		}
		
		System.out.println();
		
		/*Two ways of printing cards depending on the number of cards in dealer hands*/
		System.out.print("Dearler Cards Value:");
		
		if(dealerHands.getCardCount() == 2 && dealerHands.getBlackjackValue() < 21 && !showAllOrNot)
		{
			System.out.printf("%18s%15s\n", dealerHands.getCard(0), "*");
		}
		else
		{
			System.out.printf("%18s",dealerHands.getCard(0));
			for(int i = 1 ; i < dealerHands.getCardCount(); i++)
			{
				System.out.printf("%21s",dealerHands.getCard(i));
			}
			System.out.println();
		}
	}
}
