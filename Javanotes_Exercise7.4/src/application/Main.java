package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

/**
 * A program that let user create the square on the screen by pressing 
 * the button. The user can drag the squares off the canvas and drop them by
 * pressing Shift + primary button or only pressing secondary button. If the user
 * has pressing other button which will create a square on the screen. If the user
 * has dragged the square outside the canvas, then the dragged square will be deleted
 * and user has to drag other square instead.
 */
public class Main extends Application {

	/**The main subroutine that used to launch the program.
	 * @param args the command line argument of this program.
	 * */
    public static void main(String[] args) {
        launch(args);
    }

    //---------------------------------------------------------------------
    private Canvas canvas;  // The canvas where the squares are drawn.
    private ArrayList<Square> squareList = new ArrayList<Square>();	//The arraylist that is used to store the squares.
    private double selectedSquareX, selectedSquareY;   // x and y coordinates of the selected square.

    /**
     *  The start method sets up the GUI.  It adds mouse event handlers to
     *  the canvas to implement dragging.
     *  @param Stage the stage that this program will be used.
     */
    public void start(Stage stage) {

        canvas = new Canvas(300,250);
        draw(); //Drawing the initial state of the canvas
        
        canvas.setOnMousePressed( e -> mousePressed(e) );
        canvas.setOnMouseDragged( e -> mouseDragged(e) );
        canvas.setOnMouseReleased( e -> mouseReleased(e) );
        
        Pane root = new Pane(canvas);        
        Scene scene = new Scene(root);           
        stage.setScene(scene);
        stage.setTitle("Create and Drag the squares!");
        stage.setResizable(false);
        stage.show();
    } 


    /**
     * Draw the canvas, showing the squares in their current positions.
     */
    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(230,255,230)); // light green
        g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        
        /*Drawing all the squares in the arraylist using its own method called drawSquare()*/
        for(Square s: squareList)
        	s.drawSquare(); 
    }
    
    //-----------------  Inner Class for Square -----------
    
    /**This is an inner class that used to obtain all the information
     * of a square.
     * */
    public class Square {

    	private final static int squareWidth = 30;	//The square width
    	private final static int squareHeight = 30;	//The square height
    	private Color color;	//The color of the square
    	private double squareX,squareY;		//The x and y coordinates of the square
        
    	/**The constructor of Square class used to initialize all the information for
    	 * a square like its x position, its y position, its color.
    	 * @param squareX the x position of the square
    	 * @param squareY the y position of the square
    	 * */
    	public Square(double squareX, double squareY) {
    		this.squareX = squareX;		//Obtaining the initial x position of the square
    		this.squareY = squareY;		//Obtaining the initial y position of the square
    		
    		double randomAlpha = 0.5 * Math.random() + 0.5;		//Generating a random alpha value for the color
    		double randomRed = Math.random();	//Generating a random red component value for the color
    		double randomGreen = Math.random();	//Generating a random green component value for the color
    		double randomBlue = Math.random();	//Generating a random blue component value for the color
    		this.color = Color.color(randomRed, randomGreen, randomBlue, randomAlpha);	//Obtaining the color component for the square		
    	}
    	
    	/**This method is used to draw the square itself in all the 
    	 * defined information.
    	 * */
    	public void drawSquare() {
    		GraphicsContext g = canvas.getGraphicsContext2D();
    		
    		/*Draw the square*/
    		g.setFill(color);
            g.fillRect(squareX + 1, squareY + 1, squareWidth - 2, squareHeight - 2);
            
            /*Draw the border of a square*/
            g.setFill(Color.BLACK);
            g.strokeRect(squareX + 0.5, squareY + 0.5, squareWidth - 1, squareHeight - 1);
    	}
    	
    	/**The getter method for the x position of the square.
    	 * @return the x position of the square
    	 * */
    	public double getSquareX() {
    		return squareX;
    	}
    	
    	/**The getter method for the y position of the square.
    	 * @return the y position of the square
    	 * */
    	public double getSquareY() {
    		return squareY;
    	}
    	
    	/**The setter method for the x position of the square.
    	 * @param x the x position of the square
    	 * */
    	public void setSquareX(double x) {
    		squareX = x;
    	}
    	
    	/**The setter method for the y position of the square.
    	 * @param y the y position of the square.
    	 * */
    	public void setSquareY(double y) {
    		squareY = y;
    	}
    }
    
    //-----------------  Variables and methods for responding to drags -----------

    private boolean dragging;      // Set to true when a drag is in progress.
    private boolean dragOneSquare; 	// Set to true when a square is dragging.
    private double offsetX, offsetY;  // Offset of mouse-click coordinates from the top-left corner of the clicked square.   
    private Square selectedSquare;	// Obtaining the current dragging square.

    /**
     * Respond when the user presses the mouse on the canvas.
     * Check which square the user clicked, if any, and start
     * dragging that square. Also, checking the button that user
     * has pressed. If the user has pressed Shift + primary button
     * or only pressing the secondary button, it means that user will 
     * start to drag. Otherwise, if the user has pressed the other 
     * buttons, it will create a new square on the screen and add it
     * to the arraylist.
     * @param evt the current event of the mouse
     */
    public void mousePressed(MouseEvent evt) { 

        if (dragging)  // Exit if a drag is already in progress.
            return;

        /*If the shift is down and user is pressing the primary button, then it means 
         *the user will drag the square which is the same as pressing secondary button.
         *Otherwise, if the user has pressed other button, then it will create a square 
         *on the canvas and add it to the arraylist.*/
        if(evt.isShiftDown() || evt.isSecondaryButtonDown()){
            double x = evt.getX();  // Location where user clicked.
            double y = evt.getY();
            for(Square s: squareList)
            {
            	/*Note: If a square is covered by another square and we want to drag the top square, my
            	 *following codes will work, as the squares in the arraylist all satisfy the if statement, 
            	 *it will select the last satisfy square which is our goal.*/
                if (x >= s.getSquareX() && x < s.getSquareX()+30 && y >= s.getSquareY() && y < s.getSquareY()+30) {
                	dragging = true;
                	dragOneSquare = true;
                	selectedSquare = s;		//Obtaining the selected square.
                	selectedSquareX = selectedSquare.getSquareX(); //Obtaining the x coordinate of the selected square.
                	selectedSquareY = selectedSquare.getSquareY(); //Obtaining the y coordinate of the selected square.
                	offsetX = x - selectedSquareX;  // Distance from left top corner of square to mouse-clicked x.
                	offsetY = y - selectedSquareY;	// Distance from left top corner of square to mouse-clicked y.
                }              	
            }
        }
        else{
        	/*Creating a square which the coordinate of the mouse clicked is the 
        	 *center of the square.*/
            Square square = new Square(evt.getX() - 15, evt.getY() - 15);
            squareList.add(square);
            draw();
        }
    }

    /**
     * Dragging stops when user releases the mouse button.
     * @param evt the current event of the mouse
     */
    public void mouseReleased(MouseEvent evt) { 
        dragging = false;
        dragOneSquare = false;
    }

    /**
     * Respond when the user drags the mouse.  If a square is 
     * not being dragged, then exit. Otherwise, change the position
     * of the square that is being dragged to match the position
     * of the mouse.  Note that the corner of the square is placed
     * in the same relative position with respect to the mouse that it
     * had when the user started dragging it. Also, if the user has dragged
     * the square outside the screen, that square will be deleted and all the 
     * the user action will set to false which means user has to press a new
     * square on the screen again in order to drag the square.
     * @param evt the current event of the mouse
     */
    public void mouseDragged(MouseEvent evt) { 
        if (dragging == false)  
            return;
        if(evt.isShiftDown() || evt.isSecondaryButtonDown())
        {
            double x = evt.getX();
            double y = evt.getY();
            if (dragOneSquare) {
            	selectedSquareX = x - offsetX;
            	selectedSquareY = y - offsetY;
                selectedSquare.setSquareX(selectedSquareX);
                selectedSquare.setSquareY(selectedSquareY);
                
                /*Checking whether the user has dragged the square out of the canvas.
                 *If the user has dragged the square out of the canvas, then delete that
                 *square and set the action to false to let user do no action.
                 *Note: I used the left, top, bottom and right border of the square to check
                 *whether the square has moved outside the screen or not.
                 *For the right part, if the left border is >= canvas's width and the right border is > canvas.width,
                 *then it is outside the screen.
                 *For the left part, if the left border is < 0 and the right border is <= 0, then it is outside the screen.
                 *For the top part, if the top border is < 0 and the bottom border is <= 0, then it is outside the screen.
                 *For the bottom part, if the top border is >= canvas's height and the bottom border is > canvas's height, 
                 *then it is outside the screen.
                 **/
                double offsetXToRight = selectedSquareX + 30;
                double offsetYToRight = selectedSquareY + 30;
                if(((selectedSquareX >= canvas.getWidth()) && (offsetXToRight > canvas.getWidth())) || 
                										((selectedSquareX < 0) && (offsetXToRight <= 0)) ||
                										((selectedSquareY < 0) && (offsetYToRight <= 0)) ||
                										((selectedSquareY >= canvas.getHeight()) && (offsetYToRight > canvas.getHeight()))){
                	squareList.remove(selectedSquare);
                	dragging = false;
                	dragOneSquare = false;
                }
            }
            draw();  // (Calls the draw() to show squares in new positions.)        	
        }
    }

} // end class DragTwoSquares
