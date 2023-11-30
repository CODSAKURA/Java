package application;
	
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**This class will allow user to play a simple version of Go Moku game. The user
 * has to act as black and white player to play the game if the user is single player. 
 * Initially, user has to press NewGame button to start the game. Then, during the game, 
 * if one of the player(black or white) has reach a 5 continuous dots in the board in different
 * directions, then that player will immediately win. The meaning of different directions is that
 * horizontal direction, vertical direction, main diagonal direction and sub-diagonal direction. If
 * one of this direction contains 5 continuous same color of dots, that player belonging to that 
 * color will win. Also, during the game, the player can resign if that player feels he/she will lose
 * in the future to start new game.
 * */
public class Main extends Application {
	
	private PlayerBoard board;	// A canvas on which a player board is drawn.
	
    private Button newGameButton;  // Button for starting a new game.
    
    private Button resignButton;   // Button that a player can use to end 
                                    // the game by resigning.
    
    private Label message;  // Label for displaying messages to the user.
	
    /**The main method that will launch the program
     * @param args the command line argument for this program
     * */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**This method will draw the initial state of the program including
	 * show two buttons and disable resign button in order to let player 
	 * to press NewGame button to start the game. Also, it draws the initial
	 * state of the board.
	 * @param stage the current stage that is used
	 * */
	public void start(Stage stage) {
        /*Create the label that will show messages. */      
        message = new Label("Click \"New Game\" to begin.");
        message.setTextFill( Color.rgb(100,255,100) ); // Light green.
        message.setFont( Font.font(null, FontWeight.BOLD, 18) );
        
        /*Create the buttons.*/
        newGameButton = new Button("New Game");
        resignButton = new Button("Resign");
        
        /*Create the playing board*/
        board = new PlayerBoard();
        board.drawBoard();
        
        /*Add listener to buttons and board*/
        newGameButton.setOnAction( e -> board.doNewGame() );
        resignButton.setOnAction( e -> board.doResign() );
        board.setOnMousePressed( e -> board.mousePressed(e) );

        /*Set the location of each child by calling its relocate() method */
        board.relocate(20,20);
        newGameButton.relocate(370, 120);
        resignButton.relocate(370, 200);
        message.relocate(20, 370);
        
        /*Set the sizes of the buttons.  For this to have an effect, make
         *the buttons "unmanaged."  If they are managed, the Pane will set
         *their sizes. */ 
        resignButton.setManaged(false);
        resignButton.resize(100,30);
        newGameButton.setManaged(false);
        newGameButton.resize(100,30);
        
        /*Disable the region button at the beginning of the game*/
        board.gameOver("Click \"New Game\" to start a new game.");
        
        Pane root = new Pane();
        root.setPrefWidth(500);
        root.setPrefHeight(420);
        
        /* Add the child nodes to the Pane and set up the rest of the GUI */
        root.getChildren().addAll(board, newGameButton, resignButton, message);
        root.setStyle("-fx-background-color: darkgreen; "
                           + "-fx-border-color: darkred; -fx-border-width:3");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Five Stones!");
        stage.show();
	}
	
	// --------------------  Nested Classes -------------------------------
	
	/**This class is inherited from the canvas class, it will handle all the 
	 * case in the board and the buttons.
	 * */
	private class PlayerBoard extends Canvas {
				
		private int[][] digitialBoard = new int[13][13];//Converting the graph board to digital board to let computer understand
		
		private boolean currrentPlayerBlack = true, gameInProgress = false;//Switching between two players black and white, Checking the states of the game process
		
		private final int blackPlayer = 1, whitePlayer = -1;//Representing the dot that player plays in digital board(1 for black; -1 for white)
		
		private int numberOfDots = 0, countVertical = 0, countHorizontal = 0, countMainDiagonal = 0, countSubDiagonal = 0;//Getting the number of the dots in the board that achieving the goal 
		
		private ArrayList<Integer> lineX, lineY;//If five dots are continue connecting to each other, this will obtain these dots' location in the digital board
		
		/**The constructor that super from the canvas which will
		 * create a 325*325 canvas.*/
        PlayerBoard() {
            super(13 * 25, 13 * 25);//13 is the number of the square 
            						//25 is the area of a square's border plus square
        }
		
        /**
         * This method will handle and update all the states happened in the board.
         * */
        public void drawBoard() {
            
            GraphicsContext g = getGraphicsContext2D();

            /* Draw the squares of the player board. */
            for (int row = 0; row < 13; row++) {
                for (int col = 0; col < 13; col++) {                		
                	g.setStroke(Color.BLACK);
                	g.strokeRect(0.5 + col*25, 0.5 + row*25, 24, 24);
                	g.setFill(Color.LIGHTGRAY);
                	g.fillRect(1 + col*25, 1 + row*25, 23, 23);
                	
                	/*Setting the dot's color for black player*/
                	if(digitialBoard[row][col] == blackPlayer)
                		g.setFill(Color.BLACK);
                	
                	/*Setting the dot's color for white player*/
                	if (digitialBoard[row][col] == whitePlayer)
                		g.setFill(Color.WHITE);
                	g.fillOval(2 + col*25, 2 + row*25, 21, 21);	
                }
            }
            
            /*Checking the previous player wins the game or not.
             *As the program have change the state of currentPlayerBlack once the player has clicked legal place,
             *so if the currentPlayerBlack is true, then checking whether the previous player(white) wins the game or not.
             * */
            if(currrentPlayerBlack) 
            {
            	/*Different style of drawing line.
            	 *For checking the vertical, horizontal and main diagonal, it uses ++ and --, but for sub-diagonal it uses
            	 *+- and -+(seeing the code of returnCounter and checkSubDiagonalNumberOfDots). Therefore, the style of printing 
            	 *the line will also be different. In order to do this, it passing the parameter to the drawline function.
            	 * */
            	if((countVertical >= 5 || countHorizontal >= 5 || countMainDiagonal >= 5 || countSubDiagonal >= 5))
            	{
            		drawLine(countSubDiagonal >= 5);
            		gameOver("WHITE wins the game!");
            	}
            }
            
            /*Same as above.
             *As the program have change the state of currentPlayerBlack once the player has clicked legal place,
             *so if the currentPlayerBlack is false, then checking whether the previous player(black) wins the game or not.
             * */
            if(!currrentPlayerBlack) 
            {
            	/*Same as above*/
            	if((countVertical >= 5 || countHorizontal >= 5 || countMainDiagonal >= 5 || countSubDiagonal >= 5))
            	{
            		drawLine(countSubDiagonal >= 5);
            		gameOver("BLACK wins the game!");            		
            	}
            }
            
            /*Checking whether the full board has been covered by dots.
             *If so, then it will be a tie.
             **/
            if(numberOfDots == digitialBoard.length * digitialBoard[0].length) {
            	gameOver("Tie Game. No one wins");
            }
        }      
        
        /**
         * This method will handle draw the red line for vertical, horizontal, main diagonal and sub-diagonal direction.
         * Caution: the style of printing the line will be different between the horizonal, vertical, main diagonal direction
         * with the sub-diagonal direction.
         * @param stateOfSubDiagonal True or false of whether there is a continuous 5 or more than 5 dots in sub-diagonal direction
         * as there will be a different printing style between the different directions.
         * */
        public void drawLine(boolean stateOfSubDiagonal) {
        	GraphicsContext g = getGraphicsContext2D();
        	
        	Collections.sort(lineX);
        	Collections.sort(lineY);
        	
        	g.setStroke(Color.RED);
        	g.setLineWidth(3);
        	
        	if(stateOfSubDiagonal)
        		g.strokeLine(12.5 + lineX.get(lineX.size()-1) * 25, 12.5 + lineY.get(0) * 25, 12.5 + lineX.get(0) * 25, 12.5 + lineY.get(lineY.size()-1) * 25);
        	else
        		g.strokeLine(12.5 + lineX.get(0) * 25, 12.5 + lineY.get(0) * 25, 12.5 + lineX.get(lineX.size()-1) * 25, 12.5 + lineY.get(lineY.size()-1) * 25);
        	
        	/*Resetting to the default line width*/
        	g.setLineWidth(1);
        }
        
        /**
         * This method is handling with the mouse click on the board for both black and white player including
         * checking whether the mouse clicked has clicked in an available place or not.
         * It also do the job on switching the black and white player and obtaining the number of the dots which are
         * same as the current player dot in vertical, horizontal, main diagonal and sub-diagonal direction.
         * @param evt the object of mouseEvent class which contains all the information of current mouse click.
         * */
        public void mousePressed(MouseEvent evt) {
            if (gameInProgress == false) {
            	message.setText("Click \"New Game\" to start a new game.");
            	return;
            }               
        	int col = (int)((evt.getX() - 2) / 25);//col denotes x axis
        	int row = (int)((evt.getY() - 2) / 25);//row denotes y axis
        	
        	/*If the player has clicked an available place, then assign the value to the digital board.
        	 *Available place means that user has clicked in the board and there is no value occupy that 
        	 *place in digital board.
        	 */
        	if (col >= 0 && col < 13 && row >= 0 && row < 13)
        	{
        		/*Checking the black player move*/
        		if (currrentPlayerBlack && digitialBoard[row][col] == 0) {
        			digitialBoard[row][col] = blackPlayer;
        			currrentPlayerBlack = false;
        			numberOfDots++;
        			message.setText("WHITE:  Make your move.");
        		}
        		
        		/*Checking the white player move*/
        		if (!currrentPlayerBlack && digitialBoard[row][col] == 0){
        			digitialBoard[row][col] = whitePlayer;
        			currrentPlayerBlack = true;
        			numberOfDots++;
        			message.setText("BLACK:  Make your move.");
        		}
        	}
        	checkVerticalNumberOfDots(col, row);
        	checkHorizontalNumberOfDots(col, row);
        	checkMainDiagonalNumberOfDots(col, row);
        	checkSubDiagonalNumberOfDots(col, row);
        	drawBoard();
        }
        
        /**
         * Obtaining the number of the dots that have same color of current player's dot in vertical direction.
         * @param col the column number within the digital board that player has clicked
         * @param row the row number within the digital board that player has clicked
         * */
        public void checkVerticalNumberOfDots(int col, int row) {        	
        	int dirX = 0, dirY = 1;	//Given the direction of vertical(x will not change, only y changes)
        							//As it is 0, 1, in the returnCounter function, it will go up and down to check the number of same square
        	countVertical = returnCounter(col, row, dirX, dirY);
        }
        
        /**
         * Obtaining the number of the dots that have same color of current player's dot in horizontal direction.
         * @param col the column number within the digital board that player has clicked
         * @param row the row number within the digital board that player has clicked
         * */
        public void checkHorizontalNumberOfDots(int col, int row) {        	
        	int dirX = 1, dirY = 0;//Given the direction of vertical(x will change, y will not change)
								   //As it is 1, 0, in the returnCounter function, it will go left and right to check the number of same square
        	countHorizontal = returnCounter(col, row, dirX, dirY);
        }
        
        /**
         * Obtaining the number of the dots that have same color of current player's dot in main diagonal direction.
         * @param col the column number within the digital board that player has clicked
         * @param row the row number within the digital board that player has clicked
         * */
        public void checkMainDiagonalNumberOfDots(int col, int row) {        	
        	int dirX = 1, dirY = 1;//Given the direction of main diagonal(x will change, y will change)
			   					   //As it is 1, 1, in the returnCounter function, it will go along the main diagonal to check the number of same square
        	countMainDiagonal = returnCounter(col, row, dirX, dirY);
        }
        
        /**
		 * Obtaining the number of the dots that have same color of current player's dot in sub-diagonal direction.
         * @param col the column number within the digital board that player has clicked
         * @param row the row number within the digital board that player has clicked
         * */
        public void checkSubDiagonalNumberOfDots(int col, int row) {        	
        	int dirX = 1, dirY = -1;//Given the direction of sub-diagonal(x will change, y will change)
			   						//As it is 1, -1, in the returnCounter function, it will go along the main diagonal to check the number of same square
        	countSubDiagonal = returnCounter(col, row, dirX, dirY);
        }
        
        
        /**
         * This method is a counter for counting the number of the dots that have same color of current player's dot
         * in vertical, horizontal, main diagonal and sub-diagonal direction. Also, it will assign the value to the 
         * global variable called lineX and lineY unless the result this method got is equal or greater than 5.
         * @param col the column number within the digital board that player has clicked
         * @param row the row number within the digital board that player has clicked
         * @param dirX, dirY the two elements that make decision for this method which direction it will go to count.
         * @return the number of the dots that have same color of the current player's dot
         * */
        public int returnCounter(int col, int row, int dirX, int dirY) {
        	int ct = 1;	//Counter that tracking the number of the same square in different direction which is decided by parameter dirX and dirY.
        	ArrayList<Integer> ctX = new ArrayList<Integer>();	//Local variable that store the x location of the digital board that have same value of current player(black:1; white:-1)
        	ArrayList<Integer> ctY = new ArrayList<Integer>();  //Local variable that store the x location of the digital board that have same value of current player(black:1; white:-1)
    		ctY.add(row);	//Adding the current location of the digital board to the arraylist
    		ctX.add(col);	//Adding the current location of the digital board to the arraylist
        	
    		/*Obtaining the x and y axis of the previous square and then checking whether it is the same value
    		 *of the current player.
    		 *If so, then add that location and do the loop and keep tracking of the previous square.*/
        	int r = row - dirX;	
        	int c = col - dirY;     	
        	while ( r >= 0 && r < 13 && c >= 0 && c < 13 && digitialBoard[r][c] == digitialBoard[row][col] ) {
        		ct++;
        		ctY.add(r);
        		ctX.add(c);
        		r -= dirX;
        		c -= dirY;
        	} 
        	
    		/*Obtaining the x and y axis of the after square and then checking whether it is the same value
    		 *of the current player.
    		 *If so, then add that location and do the loop and keep tracking of the after square.*/
        	r = row + dirX;
        	c = col + dirY;
        	while ( r >= 0 && r < 13 && c >= 0 && c < 13 && digitialBoard[r][c] == digitialBoard[row][col] ) {
        		ct++;
        		ctY.add(r);
        		ctX.add(c);
        		r += dirX;
        		c += dirY;
        	}
        	
        	/*If the counter has value equal or greater than 5, it means that player will wins.
        	 *Then, assigning the X and Y arraylists to the global variable in order to draw the line.*/
        	if(ct >= 5) {
        		lineX = ctX;
        		lineY = ctY;
        	}
        	
        	/*No matter how many is stored in the counter, just return it as there are some if 
        	 *statements that will check the result in drawBoard() function.*/
        	return ct;
        }
        
        /**
         * This method will be called if the user has pressed NewGame button and it will reset all the 
         * states of the game to the initial state to let user play a new game. 
         * */
        public void doNewGame() {
            if (gameInProgress == true) {
                message.setText("Finish the current game first!");
                return;
            }
            digitialBoard = new int[13][13];
            currrentPlayerBlack = true;
            numberOfDots = 0;
            countVertical = 0;
            countHorizontal = 0;
            countMainDiagonal = 0;
            countSubDiagonal = 0;
            message.setText("BLACK:  Make your move.");
            gameInProgress = true;
            newGameButton.setDisable(true);
            resignButton.setDisable(false);
            drawBoard();
        }
        
        /**
         * This method will be called if the user has pressed resign button and it means that the current
         * play will lose immediately and output the result on the screen.
         * */
        public void doResign() {
            if (gameInProgress == false) {
                message.setText("There is no game in progress!");
                return;
            }
            if (currrentPlayerBlack)
                gameOver("BLACK resigns.  WHITE wins.");
            else
                gameOver("WHITE resigns.  BLACK wins.");
        }
        
        /**
         * This method will handle all the cases that one of the player wins the game including
         * showing the result at the bottom of the screen and enable the newGame button and disable
         * the resign button and also let global variable gameInProgress to false.
         * */
        public void gameOver(String str) {
            message.setText(str);
            newGameButton.setDisable(false);
            resignButton.setDisable(true);
            gameInProgress = false;
        }
	}
}
