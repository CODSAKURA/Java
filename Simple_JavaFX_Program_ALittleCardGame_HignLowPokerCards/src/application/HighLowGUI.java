package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * This class implements a simple card game.  The user sees a card 
 * and tries to predict whether the next card will be higher or 
 * lower.  Aces are the lowest-valued cards.  If the user makes
 * three correct predictions, the user wins.  If not, the
 * user loses.
 * 
 * This class depends on several additional source code files:
 * Card.java, Hand.jave, Deck.java, and cards.png. 
 */
public class HighLowGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //---------------------------------------------------------------------

    private Canvas board;     // The canvas on which cards and message are drawn.
    private Image cardImages; // A single image contains the images of every card.

    private Deck deck;      // A deck of cards to be used in the game.
    private Hand hand;      // The cards that have been dealt so far.
    private String message; // A message drawn on the canvas, which changes
                            //    to reflect the state of the game.

    private boolean gameInProgress;  // Set to true when a game begins and to false
                                     //   when the game ends.

    
    /**
     * The start() method sets up the GUI and event handling. The root pane is
     * is a BorderPane. A canvas where cards are displayed occupies the center 
     * position of the BorderPane.  On the bottom is a HBox that holds three buttons.  
     * ActionEvent handlers are set up to call methods defined elsewhere
     * in this class when the user clicks a button.
     */
    public void start(Stage stage) {

        cardImages = new Image("cards.png");

        /*
         *4*99 + 20 is total length: 99 = one card's width[79] + the left gap between two cards or between the card and the left side of border pane[20].
         *					   		 4  = the number of the cards
         *					         20 = the right gap between the last card and right side of the border pane.
         *
         *123 + 80 is total width: 123 = one card's height.
         *				           80  = the top gap between the card and top side of border pane[20] + the bottom space between the card and the bottom side of border pane which is the top side of the Bottom[60]. 
         *						   Reason for why 80: As the top gap between the card and top side of border pane[20] + card's height[123] = 143 and the label is drawn in the point(20,180), so the gap between the 
         *						   card and label is 37. Also, we want to make the space between label and the bottom side of border pane which is the top side of the Bottom, we double the gap between the card and 
         *						   label[37 * 2 = 74 which is around 80]. 					
         *
         *Caution: 
         *1.The canvas needs to give enough space for all the objects(cards, gaps, labels). If canvas does not give enough spaces, some objects will be drawn
         *  beyond the window which will not shown on the screen. REMEMBER: The object will NOT EXTEND the canvas if it does not provide enough space for it!!!!!
         *  
         *2.Any addition objects which is not inside the canvas will not occupy the space of canvas. Instead, they will added near the canvas or bottom of the canvas(like Bottom) which will
         *  make the size of the window bigger.
         */
        board = new Canvas(4*99 + 20, 123 + 80); 
        
        /*Creating the buttons*/
        Button higher = new Button("Higher");
        higher.setOnAction( e -> doHigher() );
        Button lower = new Button("Lower");
        lower.setOnAction( e -> doLower() );
        Button newGame = new Button("New Game");
        newGame.setOnAction( e -> doNewGame() );

        /*Adding the buttons to HBox layout*/
        HBox buttonBar = new HBox( higher, lower, newGame );
        
        /* Improve the layout of the buttonBar. Without adjustment
         * the buttons will be grouped at the left end of the
         * HBox.  My solution is to set their preferred widths
         * to make them all the same size and make them fill the
         * entire HBox.  
         * 
         *Make each button fill 1/3 of the width. (Cut the width into three parts, each button occupies one part, then 3/3 = 1)
         */    
        higher.setPrefWidth(board.getWidth()/3.0);
        lower.setPrefWidth(board.getWidth()/3.0);
        newGame.setPrefWidth(board.getWidth()/3.0);
        
//        buttonBar.setAlignment(Pos.CENTER);  // Alternative layout adjustment:
                                             // group the buttons in the
                                             // center of the HBox.

//        higher.setMaxWidth(1000);  // Alternative layout adjustment:
//        lower.setMaxWidth(1000);   // increase the max size of the buttons
//        newGame.setMaxWidth(1000); // tell the HBox to let them grow.
//        HBox.setHgrow(higher, Priority.ALWAYS);  // In this case, the buttons
//        HBox.setHgrow(lower, Priority.ALWAYS);   // fill the HBox, but they are
//        HBox.setHgrow(newGame, Priority.ALWAYS); // not the same size.
        
        BorderPane root = new BorderPane();
        root.setCenter(board);
        root.setBottom(buttonBar);

        doNewGame();  // set up for the first game

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("High/Low Game");
        stage.setResizable(false);
        stage.show();
        
    }  // end start()


    /**
     * Called by an event handler when user clicks "Higher" button.
     * Check the user's prediction.  Game ends if user guessed
     * wrong or if the user has made three correct predictions.
     */
    private void doHigher() {
        if (gameInProgress == false) {
                // If the game has ended, it was an error to click "Higher",
                // So set up an error message and abort processing.
            message = "Click \"New Game\" to start a new game!";
            drawBoard();
            return;
        }
        hand.addCard( deck.dealCard() );     // Deal a card to the hand.
        int cardCt = hand.getCardCount();
        Card thisCard = hand.getCard( cardCt - 1 );  // Card just dealt.
        Card prevCard = hand.getCard( cardCt - 2 );  // The previous card.
        if ( thisCard.getValue() < prevCard.getValue() ) {
            gameInProgress = false;
            message = "Too bad! You lose.";
        }
        else if ( thisCard.getValue() == prevCard.getValue() ) {
            gameInProgress = false;
            message = "Too bad!  You lose on ties.";
        }
        else if ( cardCt == 4) {
            gameInProgress = false;
            message = "You win!  You made three correct guesses.";
        }
        else {
            message = "Got it right!  Try for " + cardCt + ".";
        }
        drawBoard();
    } // end doHigher()


    /**
     * Called by an event handler when user clicks "Lower" button.
     * Check the user's prediction.  Game ends if user guessed
     * wrong or if the user has made three correct predictions.
     */
    private void doLower() {
        if (gameInProgress == false) {
                // If the game has ended, it was an error to click "Lower",
                // So set up an error message and abort processing.
            message = "Click \"New Game\" to start a new game!";
            drawBoard();
            return;
        }
        hand.addCard( deck.dealCard() );     // Deal a card to the hand.
        int cardCt = hand.getCardCount();
        Card thisCard = hand.getCard( cardCt - 1 );  // Card just dealt.
        Card prevCard = hand.getCard( cardCt - 2 );  // The previous card.
        if ( thisCard.getValue() > prevCard.getValue() ) {
            gameInProgress = false;
            message = "Too bad! You lose.";
        }
        else if ( thisCard.getValue() == prevCard.getValue() ) {
            gameInProgress = false;
            message = "Too bad!  You lose on ties.";
        }
        else if ( cardCt == 4) {
            gameInProgress = false;
            message = "You win!  You made three correct guesses.";
        }
        else {
            message = "Got it right!  Try for " + cardCt + ".";
        }
        drawBoard();
    } // end doLower()


    /**
     * Called by the start() method, and called by an event handler if
     * the user clicks the "New Game" button.  Start a new game.
     */
    private void doNewGame() {
        if (gameInProgress) {
                // If the current game is not over, it is an error to try
                // to start a new game.
            message = "You still have to finish this game!";
            drawBoard();
            return;
        }
        deck = new Deck();   // Create the deck and hand to use for this game.
        hand = new Hand();
        deck.shuffle();
        hand.addCard( deck.dealCard() );  // Deal the first card into the hand.
        message = "Is the next card higher or lower?";
        gameInProgress = true;
        drawBoard();
    } // end doNewGame()


    /**
     * This method draws the message at the bottom of the
     * canvas, and it draws all of the dealt cards spread out
     * across the canvas.  If the game is in progress, an extra
     * card is drawn face down representing the card to be dealt next.
     */
    private void drawBoard() {
    	/*Drawing the background*/
        GraphicsContext g = board.getGraphicsContext2D();
        g.setFill( Color.DARKGREEN);
        g.fillRect(0,0,board.getWidth(),board.getHeight());
        
        /*Drawing the label*/
        g.setFill( Color.rgb(220,255,220) );
        g.setFont( Font.font(16) );
        g.fillText(message,20,180);
        
        /*Drawing the card*/
        int cardCt = hand.getCardCount();
        for (int i = 0; i < cardCt; i++)
            drawCard(g, hand.getCard(i), 20 + i * 99, 20);	// 20 + i * 99: 20 = the left gap between the card and the window.
        													// (....,20): 20 = the top gap between the card and the window.
        if (gameInProgress)
            drawCard(g, null, 20 + cardCt * 99, 20);	//If the hand has one card, cardCt will be 1 but the position of that card in hand is 0.
        											    //Therefore, using cardCt is an another way of saying the next card even there is only one card in hand.
        												//Also, cardCt is increasing as each time the user win the guess there is one more card added to the hand.
    } 


    /**
     * Draws a card with top-left corner at (x,y).  If card is null,
     * then a face-down card is drawn.  The card images are from 
     * the file cards.png; this program will fail without it.
     */
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


} // end class HighLowGUI