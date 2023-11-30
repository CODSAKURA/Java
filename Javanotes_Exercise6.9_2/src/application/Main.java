package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**This class generate a GUI for user to play a blackjack game. When the user
 * first run the program, a welcome screen will show and it will lead user to play 
 * blackjack until user has inputed a valid bet. User can check it input bet by 
 * press the NewGame button or press Enter key. The total money user has is 100.
 * If the user has inputed an invalid number, a message will show at the bottom
 * of the screen. After user making a valid bet, user then can play blackjack game. 
 * Computer will act as dealer. User can press buttons on the bottom of the screen 
 * to do the action. User has to press Hit or Stand button during a game. 
 * The program will disable user press NewGame button during a game. If a 
 * game has ended, the result of a game will shown, the program will disable 
 * user to press Hit and Stand buttons at this time. User has to check it money and
 * make a bet for the next game. If user has ran out of the money, another 100 dollar
 * will add to user's account and user has to make a valid bet before pressing newGame
 * button. This program depends on BlackjackHand class, Card class, Deck class and Hand class.
 * */
public class Main extends Application {
	
    private Deck deck;      // A deck of cards to be used in the game.
    private BlackjackHand handDealer,handPlayer;      // The cards on both dealer and user's hand.
    private String message; // A message drawn on the canvas, which changes to reflect the state of the game.
    private Canvas board;     // The canvas on which cards and message are drawn.
    private Button hit, stand, newGame; //Buttons for hit, stand and new Game.
    private TextField betValue; //An area for user input bet.
    private Image cardImages; // A single image contains the images of every card.
    
    private boolean gameInProgress, isFirstScreen = true, longSentence;  // gameInProgress: Set to true when a game begins and to false when a game ends.
    																	 // isFirstScreen: Set to true to draw the initial board and to false if the user pass the initial board.
    																	 // longSentence: checking whether there is a long sentence need to print at initial board.
    private double currentBetValue = 100;	//Record the money that user currently has.
    private double userBetValue;	//Obtaining the user bet value.
    private boolean runOutOfMoney;	//Checking whether the user has ran out of money.
	
    /**This main method use to launch the program.
     * @param args the command line arguments.
     * */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**This method will generate a default layout of the screen and
	 * set event handlers to three buttons and Enter Key Press.
	 * @param stage the current stage object.
	 * */
	public void start(Stage stage) {
		/*Assign cardImages value*/
		cardImages = new Image("cards.png");
		
		/*Creating a canvas*/
		board = new Canvas(5*99 + 20 + 171, 2*123 + 40 + 40 + 40 + 40);
		
		/*The three buttons at the bottom of the screen.*/
		hit = new Button("Hit");
		hit.setOnAction( e -> doHit() );
		stand = new Button("Stand");
		stand.setOnAction(e -> doStand());
		newGame = new Button("New Game");
		newGame.setOnAction( e -> doNewGame() );
		
		/*Creating a label and a text field.*/
		Label yourBet = new Label(" Your bet: $");
		yourBet.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		betValue = new TextField();
		
		/*Set three buttons and a label and a text field equally obtain the area of the space.
		 * First, I let three buttons occupy 1/5 part from board which will left 2/5 space
		 * for label and text field. Then, I want label occupy a area depending on its content
		 * and text field occupy the rest of the space. Therefore, I let text field occupy an 
		 * area as much as it can and let label occupy a area which it should occupy. 
		 * */
		hit.setPrefWidth(board.getWidth()/5);
        stand.setPrefWidth(board.getWidth()/5);
        newGame.setPrefWidth(board.getWidth()/5);
             
        /*Letting the text field grow without restriction.*/
        HBox.setHgrow(betValue, Priority.ALWAYS);
        betValue.setMaxWidth(Double.POSITIVE_INFINITY);
		
        /*The container that contains all the buttons and label and text field.*/
		HBox buttonBar = new HBox(hit,stand,newGame,yourBet,betValue);
		
		/*The root pane that contains all the nodes.*/
        BorderPane root = new BorderPane();
        root.setCenter(board);
        root.setBottom(buttonBar);
        
        /*Calling this method to draw the board.*/
        doNewGame();
        
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(e -> {
        	if(e.getCode() == KeyCode.ENTER)
        		doNewGame();
        });
        
        stage.setScene(scene);
        stage.setTitle("Blackjack Game");
        stage.setResizable(false);
        stage.show();
	}
	
	/**This method will be called at the start stage. Before leading user to play the 
	 * blackjack game, it will test user whether user has inputed valid number at the 
	 * initial welcome board. After passing the welcome screen, this function will 
	 * check the blackjack value for both dealer and user hands as there will be a 
	 * situation that user or dealer will get 21 value at the start of a game. If so, 
	 * then immediately print result and let user to play next game. If a game is in progress, 
	 * the user can not access NewGame button and code with a relative error message show at 
	 * the bottom of the screen. If user has made invalid number, the user can not
	 * access NewGame code with a relative error message show out.
	 * */
	private void doNewGame() {		
		
		/*As this function is called at start in order to draw the board, it will
		 *draw an initial welcome board which is different from playing board by using the
		 *below codes.*/
		if(isFirstScreen && !checkInputValue())
		{
			/*In the welcome screen, it will disable certain buttons.*/
			disableButton(gameInProgress);
			
	    	/*Drawing the background*/
	        GraphicsContext g = board.getGraphicsContext2D();
	        g.setFill( Color.DARKGREEN);
	        g.fillRect(0, 0, board.getWidth(), board.getHeight());
	        
	        /*Drawing a first message*/
	        g.setFill( Color.rgb(220,255,220) );
	        g.setFont( Font.font(50) );
	        g.fillText("Welcome To Blackjack Game!!", 20, 195);
	        
	        /*Drawing a second message*/
	        g.setFill( Color.YELLOW );
	        g.setFont( Font.font(25) );
	        g.fillText("You have $100. Start your bet!!", 151, 285);	        
	        	        
	        /*Drawing a third message*/
	        g.setFill( Color.rgb(200,255,200) );
	        g.setFont( Font.font(18) );	        	        
	        
	        if(betValue.getText().isEmpty())
	        {
	        	message = "[Please enter your bet on the right bottom corner]";
	        }
	        
	        /*Drawing the long sentence at different position*/
	        if(longSentence)
	        {
	        	g.fillText(message, 5, 360);
	        	longSentence = false;
	        }
	        else
	        	g.fillText(message, 135, 360);
	        	        
	        return;
		}  
		else
			isFirstScreen = false;
				
		/*Below are the code that user has passed the welcome screen*/
		
		/* 
         * If the current game is still process, disable the NewGame button
         * and disable the user to access the code of the doNewGame function.
         * 
         * Or, if the user has inputed an invalid number, disable user to access
         * the rest of code in doNewGame and relative error message shown out.
         * */ 
		if (gameInProgress || !checkInputValue()) {
			drawBoard();
			return;
		}
				
		/*Creating a deck and shuffle the cards in the deck.*/
		deck = new Deck();
		deck.shuffle();
		
		/*Creating both dealer and player's hand.*/
		handDealer = new BlackjackHand();
		handPlayer = new BlackjackHand();	
		
		/*Adding initial two cards to both dealer and user hands*/
		for(int i = 0; i < 2; i++)
		{
			/*Adding the cards to the dealer hands*/
			handDealer.addCard(deck.dealCard());			

			/*Adding the cards to the user hands*/
			handPlayer.addCard(deck.dealCard());			
		}
		
		/*Checking blackjack value for the initial two cards on both dealer and player's hands.*/
		if(handDealer.getBlackjackValue() == 21)
		{
			if(handPlayer.getBlackjackValue() == 21)
			{
				message = String.format("You got %d . Dealer also got %d. You lose...", handPlayer.getBlackjackValue(), handDealer.getBlackjackValue());
			}
			else
			{
				message = String.format("Dealer got %d. You got %d. You lose...", handDealer.getBlackjackValue(), handPlayer.getBlackjackValue());			
			}
			currentBetValue = currentBetValue - userBetValue;
			gameInProgress = false;
		}
		else if(handPlayer.getBlackjackValue() == 21)
		{
			message = String.format("You got %d!!! Dealer got %d. You Win!!!", handPlayer.getBlackjackValue(), handDealer.getBlackjackValue());
			currentBetValue = currentBetValue + userBetValue;
			gameInProgress = false;
		}
		else
		{
			message = "You have " + handPlayer.getBlackjackValue() + " Hit or Stands?";
			gameInProgress = true;			
		}
		
		/*Drawing the changes on the board.*/
		drawBoard();
	}
	
	/**This method will draw all the content on the board. Also, it will
	 * draw the changes on those contents.
	 * */
	private void drawBoard() {
		
		/*Before drawing board, checking whether user has ran out money.*/
		if(currentBetValue == 0)
		{
			runOutOfMoney = true;
		}
		
		/*Before drawing the board, disable the certain buttons that have already been drawn
		 *on the screen. This is depended on the state of the game.*/
		disableButton(gameInProgress);
		
    	/*Drawing the background*/
        GraphicsContext g = board.getGraphicsContext2D();
        g.setFill( Color.DARKGREEN);
        g.fillRect(0, 0, board.getWidth(), board.getHeight());
        
        /*Drawing Top label*/
        g.setFill( Color.rgb(220,255,220) );
        g.setFont( Font.font(16) );
        g.fillText("Dealer's Cards:", 20, 25);
        
        /*Drawing Middle label*/
        g.setFill( Color.rgb(220,255,220) );
        g.setFont( Font.font(16) );
        g.fillText("Your Cards:", 20, 40 + 123 + 25);
        
        /*Drawing Middle below label
         *Show this label in different form:
         *If user has ran out the money, then show the message, add money to user account and set boolean to false.
         *If the currentBetValue has decimal like 58.4, then show the whole currentBetValue.
         *If the currentBetValue has no decimal like 100.0, then only show 100 not 100.0. 
         **/
        String middleBelow = "";
        if(runOutOfMoney)
        {
        	middleBelow = "Sorry ran out of money. I have add $100 to your account.";
        	currentBetValue = 100;
        	runOutOfMoney = false;
        }
        else
        {
        	if(currentBetValue % 1 == 0)
        		middleBelow = "Current Money You Have: $" + (int)currentBetValue;
        	else
        		middleBelow = "Current Money You Have: $" + currentBetValue;
        }        		
        g.setFill( Color.YELLOW );
        g.setFont( Font.font(16) );
        g.fillText(middleBelow, 20, 40 + 123 + 40 + 123 + 30);
        
        /*Drawing Bottom label*/
        g.setFill( Color.rgb(220,255,220) );
        g.setFont( Font.font(16) );
        g.fillText(message, 20, 40 + 123 + 40 + 123 + 40 + 20);
        
        /*Situation of drawing Dealer's cards
         *On the situation of drawing dealer's card, it will also be a back side 
         *of a card and a front side of a card from dealer's hand drawn. If the result
         *of who wins has been concluded, all the cards of dealer's hand will be drawn. 
         * */
        int cardCtDealer = handDealer.getCardCount();       
        if(gameInProgress)
        {
            for (int i = 0; i < cardCtDealer - 1; i++)
                drawCard(g, handDealer.getCard(i), 20 + i * 99, 40);
            
            /*Drawing a back side of a card to act as the last card of dealer's hand.*/
        	drawCard(g, null, 20 + (cardCtDealer - 1) * 99, 40);
        }
        else
        {
            for (int i = 0; i < cardCtDealer; i++)
                drawCard(g, handDealer.getCard(i), 20 + i * 99, 40);
        }
        
        /*Situation of drawing Player's cards
         *On the situation of drawing player's card, all the cards of player's hand
         *will be drawn all the times.
         **/
        int cardCtPlayer = handPlayer.getCardCount();       
        for (int i = 0; i < cardCtPlayer; i++)
            drawCard(g, handPlayer.getCard(i), 20 + i * 99, 40 + 123 + 40);

	}
	
	/**This method will draw the cards from the image(card.png) depending on the 
	 * cards that currently dealer and player's hand had. Also, it will
	 * draw the face down card.
	 * @param g GraphicContext object from the current canvas.
	 * @param card the card that need to be drawn.
	 * @param x,y the x and y position that card will be drawn on the canvas.
	 * */
    private void drawCard(GraphicsContext g, Card card, int x, int y) {
        int cardRow, cardCol;
        if (card == null) {  
            cardRow = 4;   // row and column of a face down card in card.png
            cardCol = 2;
        }
        else {
            cardRow = 3 - card.getSuit();
            cardCol = card.getValue() - 1;
        }
        double sx,sy;  // top left corner of source rect for card in cardImages
        sx = 79 * cardCol;
        sy = 123 * cardRow;
        g.drawImage( cardImages, sx,sy,79,123, x,y,79,123 );
    } // end drawCard()
    
    /**This method is for the Hit button. If the user press Hit button,
     * it will deal a card to user's hand and this function will do that action
     * and it will check whether the blackjack value of the player's hand has
     * greater than 21. If so, then show the result.
     * */
    private void doHit() {            
    	/* 
    	 * If the game has ended, user can not be able to press
    	 * Hit button, therefore disable the Hit Button and 
    	 * disable the user to access the doHit function code.
    	 * */
    	if (gameInProgress == false) {
    		drawBoard();
    		return;
    	}
    	
    	handPlayer.addCard(deck.dealCard());
		
    	/*The following code will check whether the blackjack value for user's hand is greater than 21 after
    	 * dealing a card to the user's hand or user hand's cards number is equal to 5. 
    	 * If so, immediately stop the program and show the result.*/
		if(handPlayer.getBlackjackValue() > 21)
		{
			message = String.format("Dealer got %d. You got %d. You lose...", handDealer.getBlackjackValue(), handPlayer.getBlackjackValue());
			currentBetValue = currentBetValue - userBetValue;
			gameInProgress = false;
		}
		else if (handPlayer.getCardCount() == 5)
		{
			message = String.format("You got %d cards without exceed 21([Y]%d and [D]%d). You Win!!", 
																				handPlayer.getCardCount(),handPlayer.getBlackjackValue(),handDealer.getBlackjackValue());
			currentBetValue = currentBetValue + userBetValue;
			gameInProgress = false;
		}
		else
		{
			message = "You have " + handPlayer.getBlackjackValue() + " Hit or Stands?";
		}
		drawBoard();
    }
    
    /**This method is for the stand button. If user press stand button, it will
     * deal a card to dealer's hand depending on whether the blackjack value for dealer's
     * card is less than or equal to 16. Then comparing the blackjack value between the user and dealer's
     * hand and stop the current game and show the result.
     * */
    private void doStand() {  	
    	/* 
    	 * If the game has ended, user can not be able to press
    	 * Stand button, therefore disable Stand button and disable
    	 * the user to access the doStand function code.
    	 * */
    	if (gameInProgress == false) {
    		drawBoard();
    		return;
    	}
    	
    	/*If the blackjack value of dealer's hand is less than or equal to 16 and less than 5 cards, then
    	 * deal a card to dealer's hand. If not, then do nothing.*/
        while (handDealer.getBlackjackValue() <= 16 && handDealer.getCardCount() < 5)
        	handDealer.addCard( deck.dealCard() );
		
		if(handDealer.getBlackjackValue() > 21)
		{
			message = String.format("You got %d!!! Dealer got %d. You Win!!!", handPlayer.getBlackjackValue(), handDealer.getBlackjackValue());
			currentBetValue = currentBetValue + userBetValue;
			gameInProgress = false;
		}		
		else if(handDealer.getBlackjackValue() >= handPlayer.getBlackjackValue())
		{
			if(handDealer.getBlackjackValue() == handPlayer.getBlackjackValue())
			{
				message = String.format("You got %d . Dealer also got %d. You lose...", handPlayer.getBlackjackValue(), handDealer.getBlackjackValue());
			}
			else
			{
				message = String.format("Dealer got %d. You got %d. You lose...", handDealer.getBlackjackValue(), handPlayer.getBlackjackValue());
			}
			currentBetValue = currentBetValue - userBetValue;
			gameInProgress = false;
		}
		else
		{
			message = String.format("You got %d!!! Dealer got %d. You Win!!!", handPlayer.getBlackjackValue(), handDealer.getBlackjackValue());
			currentBetValue = currentBetValue + userBetValue;
			gameInProgress = false;
		}
		drawBoard();
    }
    
    /**This method will disable the buttons that need to be disable
     * depending on the state of the boolean variable gameInProgress.
     * If true, NewGame button will disable, others will be able.
     * If false, NewGame button will be able, others will be disable.
     * @param gameInProgress the boolean variable which shows the state of the game
     * */
    private void disableButton(boolean gameInProgress) {
    	if(gameInProgress)
    	{
    		newGame.setDisable(true);
    		betValue.setDisable(true);
    		hit.setDisable(false);
    		stand.setDisable(false);
    	}
    	else
    	{
    		/*Once NewGame button and text field are able, setting focus on the text field
    		 *and select all the strings that user has inputed on the text field. It allows
    		 *user to make another bet easily.*/
    		newGame.setDisable(false);
    		betValue.setDisable(false);
    		hit.setDisable(true);
    		stand.setDisable(true);
			betValue.requestFocus();
			betValue.selectAll();
    	}
    }
    
    /**This method will check input on the text area.
     * If it is empty, it will output an error message at the bottom of the canvas.
     * If it is not a digit, it will output an error message at the bottom of the canvas.
     * If it is a digit but less than 0, it will output an error message at the bottom of the canvas.
     * If it is a digit but equal to 0, it will output an error message at the bottom of the canvas.
     * If it is a digit but more than the current money user has, it will output an error message at the bottom of the canvas
     * Otherwise, it will set global value userBetValue to the text field string.
     * */
    private boolean checkInputValue() {
    	String input = betValue.getText();
    	
		if(betValue.getText().isEmpty())
		{
			message = "You have to input your bet!!! Try again!!!";
			return false;
		}
		else
		{
	        try {
	            userBetValue = Double.parseDouble(input);            
	            if(userBetValue < 0) {
	            	message = "You have inputed a value less than 0!!! Try again!!!";
	            	return false;
	            }
	            
	            if(userBetValue == 0){
	            	message = "You have to input a value greater than 0!!! Try again!!!";
	            	return false;
	            }
	            
	            if(userBetValue > currentBetValue) {
	            	longSentence = true;
	            	if(currentBetValue % 1 == 0)
	            		message = "You have inputed a value greater than the current money you have: "  + (int)currentBetValue + "!!! Try again!!!";
	            	else
	            		message = "You have inputed a value greater than the current money you have: "  + currentBetValue + "!!! Try again!!!";
	            	return false;
	            }
	            
	        } catch (NumberFormatException nfe) {
	        	message = "You have inputed a non-digit string!!! Try Again!!";
	            return false;
	        }
		}
        return true;
    }
}
