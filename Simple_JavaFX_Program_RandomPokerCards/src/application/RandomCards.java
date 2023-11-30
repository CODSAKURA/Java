package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

/**
 * This program displays 5 cards selected at random from a Deck.
 * It depends on the files Deck.java, Card.java, and cards.png.
 * There is a button that the user can click to redraw the
 * image using new random cards.
 */
public class RandomCards extends Application {

    private Canvas canvas;  // The canvas on which the strings are drawn.
    
    private Image cardImages;  // Contains images of all of the cards.
                               // Cards are arranged in 5 rows and 13 columns.
                               // Each of the first four rows contains the cards
                               // from one suit, in numerical order.  The first
                               // four rows contain clubs, diamonds, hearts, and
                               // spades in that order.  The fifth row contains
                               // two jokers and a face-down card.
    

    public static void main(String[] args) {
        launch();
    }
    

    public void start( Stage stage ) {
        
        cardImages = new Image("cards.png");
        
        /*
         *120 = all the gaps between two cards[20 * 4] + the gap between the first card and left side of border pane[20] + the gap between the last card and right side of border pane[20] 
         *40  = the top gap between the card and top side of the border pane[20] + the bottom gap between the card and the bottom side of the border pane[20].
		 *
		 *Caution: 
         *1.The canvas needs to give enough space for all the objects(cards, gaps). If canvas does not give enough spaces, some objects will be drawn
         *  beyond the window which will not shown on the screen. REMEMBER: The object will NOT EXTEND the canvas if it does not provide enough space for it!!!!!
         *  
         *2.Any addition objects which is not inside the canvas will not occupy the space of canvas. Instead, they will added near the canvas or bottom of the canvas(like Bottom) which will
         *  make the size of the window bigger.
         */
        canvas = new Canvas(5*79 + 120, 123 + 40);      
        draw();  // draw content of canvas the first time.

        /*Creating the button*/
        Button redraw = new Button("Deal Again!");	
        redraw.setOnAction( e -> draw() );

        /*
         *StackPane layout with default Center alignment. More items are added in StackPane, the first item will be the top of the second one and so on.
         */
        StackPane bottom = new StackPane(redraw);	
        bottom.setStyle("-fx-background-color: gray; -fx-padding:5px;" + " -fx-border-color:blue; -fx-border-width: 2px 0 0 0");
        
        
        BorderPane root = new BorderPane(canvas);	//This constructor will add canvas as center which is equal to root.setCenter(canvas).
        root.setBottom(bottom);
        root.setStyle("-fx-border-color:blue; -fx-border-width: 2px; -fx-background-color: lightblue");
        
        stage.setScene( new Scene(root, Color.BLACK) );
        stage.setTitle("Random Cards");
        stage.setResizable(false);
        stage.show();

    }
    

    /**
     * The draw() method is responsible for drawing the content of the canvas.
     * It draws 5 cards in a row.  The first card has top left corner at (20,20),
     * and there is a 20 pixel gap between each card and the next.
     */
    private void draw() {
        
        GraphicsContext g = canvas.getGraphicsContext2D();
        
        Deck deck = new Deck();
        deck.shuffle();
        
        double sx,sy;  // top left corner of source rect for card in cardImages
        double dx,dy;  // top left corner of destination rect for card in the canvas
        
        for (int i = 0; i < 5; i++) {
            Card card = deck.dealCard();
            System.out.println(card); // for testing
            
            sx = 79 * (card.getValue()-1);		//Because the (sx,sy) is the upper left corner of the picture, so the first picture is start (0,0)
            
            sy = 123 * (3 - card.getSuit());	//Because in Card class, the suit is stored different from the picture:
            									//In the picture: clubs is first, diamonds is second, hearts is third, spades is fourth.
            									//In the Card class: spades is first, hearts is second, diamonds is third, clubs is fourth.
            
            dx = 20 + (79+20) * i;
            dy = 20;
            g.drawImage( cardImages, sx,sy,79,123, dx,dy,79,123 );
        }
        
    } // end draw()


}  // end class RandomCards