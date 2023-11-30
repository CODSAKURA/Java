package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**This class generate a GUI for user to play a blackjack game. Computer
 * will act as dealer. User can press buttons on the bottom of the screen
 * to do the action. User has to press Hit or Stand button during a game. 
 * The program will disable user press NewGame button during a game with an 
 * error message show out at the bottom of the screen. If a game has ended, 
 * the result of a game will shown, the program will disable user to press
 * Hit and Stand buttons with an error message show at this time. This program
 * depends on BlackjackHand class, Card class, Deck class and Hand class.
 * */
public class Main extends Application {
	
    private Image cardImages = new Image("cards.png");; // A single image contains the images of every card.
    private boolean gameInProgress;  // Set to true when a game begins and to false when a game ends.
    private Deck deck;      // A deck of cards to be used in the game.
    private BlackjackHand handDealer,handPlayer;      // The cards on both dealer and user's hand.
    private String message; // A message drawn on the canvas, which changes to reflect the state of the game.
    private Canvas board;     // The canvas on which cards and message are drawn.
	
    /**This main method use to launch the program.
     * @param args the command line arguments.
     * */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**This method will generate a default outlay of the screen and
	 * set event handlers to three buttons.
	 * @param stage the current stage object.
	 * */
	public void start(Stage stage) {
		
		/*The canvas area that keeps changing.*/
		board = new Canvas(5*99 + 20, 2*123 + 40 + 40 + 40);
		
		/*The three buttons at the bottom of the screen.*/
		Button hit = new Button("Hit");
		hit.setOnAction( e -> doHit() );
		Button stand = new Button("Stand");
		stand.setOnAction(e -> doStand());
		Button newGame = new Button("New Game");
		newGame.setOnAction( e -> doNewGame() );
		
		/*Set three buttons that equally obtain the area of the space.*/
		hit.setPrefWidth(board.getWidth()/3.0);
        stand.setPrefWidth(board.getWidth()/3.0);
        newGame.setPrefWidth(board.getWidth()/3.0);
		
        /*The container that contains all the buttons.*/
		HBox buttonBar = new HBox(hit,stand,newGame);
		
		/*The root pane that contains all the nodes.*/
        BorderPane root = new BorderPane();
        root.setCenter(board);
        root.setBottom(buttonBar);
        
        /*Drawing the initial state of the program.*/
        doNewGame();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Blackjack Game");
        stage.setResizable(false);
        stage.show();
	}
	
	/**This method is for the NewGame button and it will be called
	 * at the first time when the user ran the program. In this function,
	 * it will check the blackjack value for both dealer and user hands as
	 * there will be a situation that user or dealer will get 21 value at the
	 * start of a game. If so, then immediately print result and let user press
	 * Click NewGame button. If a game is in progress, the user can not access
	 * NewGame button with an error message printed at the bottom of the screen.
	 * */
	private void doNewGame() {
        /* 
         * If the current game is still process, an error message will be 
         * shown out at the bottom of the screen and disable the user to
         * access the code of the NewGame function.
         * */ 
		if (gameInProgress) {
			message = "You still have to finish this game!";
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
			gameInProgress = false;
		}
		else if(handPlayer.getBlackjackValue() == 21)
		{
			message = String.format("You got %d!!! Dealer got %d. You Win!!!", handPlayer.getBlackjackValue(), handDealer.getBlackjackValue());
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
    	/*Drawing the background*/
        GraphicsContext g = board.getGraphicsContext2D();
        g.setFill( Color.DARKGREEN);
        g.fillRect(0,0,board.getWidth(),board.getHeight());
        
        /*Drawing Top label*/
        g.setFill( Color.rgb(220,255,220) );
        g.setFont( Font.font(16) );
        g.fillText("Dealer's Cards:",20, 25);
        
        /*Drawing Middle label*/
        g.setFill( Color.rgb(220,255,220) );
        g.setFont( Font.font(16) );
        g.fillText("Your Cards:",20, 40 + 123 + 25);
        
        /*Drawing Bottom label*/
        g.setFill( Color.rgb(220,255,220) );
        g.setFont( Font.font(16) );
        g.fillText(message,20, 40 + 123 + 40 + 125 + 25);
        
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
    	 * Hit button, therefore an error message will print out and
    	 * disable the user to access doHit function code.
    	 * */
    	if (gameInProgress == false) {

    		message = "Click \"New Game\" to start a new game!";
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
			gameInProgress = false;
		}
		else if (handPlayer.getCardCount() == 5)
		{
			message = String.format("You got %d cards(values: %d) without exceed 21. You Win!!", handPlayer.getCardCount(),handPlayer.getBlackjackValue());
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
    	 * Stand button, therefore an error message will print out and
    	 * disable the user to access doStand function code.
    	 * */
    	if (gameInProgress == false) {
    		message = "Click \"New Game\" to start a new game!";
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
			gameInProgress = false;
		}
		else
		{
			message = String.format("You got %d!!! Dealer got %d. You Win!!!", handPlayer.getBlackjackValue(), handDealer.getBlackjackValue());
			gameInProgress = false;
		}
		drawBoard();
    }
}
