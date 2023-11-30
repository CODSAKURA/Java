package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**This class let user draw a red rectangle or a blue oval with the user pressing the button.
 * The shape that will be drawn is decided by whether the shift button is down or not. Also,
 * if the user drags, it will left a trail of shape.If the user presses the secondary button of 
 * the mouse, anything drawn on the screen will be removed.
 * */
public class Main extends Application {
	
	private boolean dragging;	//Obtaining the state of the dragging, default dragging is false.
	private Canvas canvas  = new Canvas(400,400);	//Creating a canvas which can only be changed by coding
	private GraphicsContext g = canvas.getGraphicsContext2D();	//Creating the related graphic context for the canvas
	private double preX,preY;	//Obtaining the previous x, y position of the mouse clicking
	
	/**Launching the application
	 * */
	public static void main(String[] args) {
		launch(args);
	}//end of main method	
	
	/**Adding three event handlers to mouse pressing, mouse dragging and mouse releasing events.
	 * Then, creating a container for canvas and set border to the container. After adding the 
	 * container to scene and scene to stage, showing the stage.
	 * @param stage the Stage object which contains all the nodes.
	 * */
	public void start(Stage stage) {
		canvas.setOnMousePressed( evt -> mousePressed(evt));
		canvas.setOnMouseDragged( evt -> mouseDragged(evt));
		canvas.setOnMouseReleased( evt -> mouseReleased());		
		
		BorderPane root = new BorderPane(canvas);	//Creating a container for the canvas
		root.setStyle("-fx-border-color:black; -fx-border-width:2px");	//Creating the border for the border pane container	
		
		Scene scene = new Scene(root);
		stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("JavaFX Test");
		stage.setResizable(false);
		stage.show();		
	}//end of start method
	
	/**This method decides whether a rectangle will be drawn or the oval will be drawn.
	 * This is decided by the whether shift key is pressed down. If shift is down, then
	 * draw the oval with the mouse clicked. Otherwise, the rectangle will be drawn. For
	 * rectangle and oval, there is border drawn around them. This method also records the
	 * position of the current mouse clicked as previous position.
	 * @param x the x axis of the mouse position.
	 * @param y the y axis of the mouse position.
	 * @param evt the object of MouseEvent class.
	 * */
	private void drawRectangleAndOval(double x, double y, MouseEvent evt) {
	    if ( evt.isShiftDown() ) {
	    	g.setFill(Color.BLACK);
	    	g.setLineWidth(2);
	    	g.strokeOval(x - 31, y - 16, 62, 32);		//(x - 31 , y - 16) is the middle point of the border as the line width is 2
	    												//(62 , 32) is 60 + 1(up border) + 1(down border)  [Because line width is 2]	
	    												//			   30 + 1(left border) + 1(right border) [Because line width is 2]	
	        g.setFill( Color.BLUE );
	        g.fillOval( x - 30, y - 15, 60, 30 );
	    }
	    else {
	    	g.setFill(Color.BLACK);
	    	g.setLineWidth(2);
	    	g.strokeRect(x - 31, y - 16, 62, 32);
	        g.setFill( Color.RED );
	        g.fillRect( x - 30, y - 15, 60, 30 );
	    }
		preX = x;		//Once uses this method, recording the position of the mouse
		preY = y;
		dragging = true;
	}//end of drawRectangleAndOval method
	
	/**Removing any drawing on the canvas by covering the whole canvas area with white color.
	 * */
	private void clear() {		
		double width = canvas.getWidth();
		double height = canvas.getHeight();
		
		g.setFill(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		dragging = false;
	}//end of clear method
	
	/**This method listens to the mouse pressing event. If the current user is dragging which means dragging 
	 * is equal to true, if the user press the other button when the user is dragging, it will create another 
	 * pressing event. In order to let system not response to a new pressing event, if the dragging is true, 
	 * then not run this method. If the user is press the secondary button during dragging, it will clean the 
	 * canvas and set dragging to false. If the user press the position is within the acceptable area, then 
	 * drawing the shape. If the user does not press the position in acceptable area, then the system will do 
	 * nothing. Besides, the user press the secondary button of the mouse, then removing any draws on the canvas.
	 * @param evt the object of MouseEvent class.
	 * */
	private void mousePressed(MouseEvent evt) {
		/*If the user press the secondary button during dragging, system immediately not response the press event.*/
		if(evt.isSecondaryButtonDown())
		{
			clear();
			return;
		}
		
		/*If the user press the middle button(except secondary button) during dragging, system immediately not response the press event.*/
		if(dragging == true)
			return;					
		
		double x = evt.getX();
		double y = evt.getY();
		
		int width = (int)canvas.getWidth();
		int height = (int)canvas.getHeight();
		
		if(x > 0 && x < width && y > 0 && y < height){
				drawRectangleAndOval(x, y, evt);
		}
	}//end of mousePressed method
	
	/**This method listens to the dragging event. If the current user is dragging and the user also uses
	 * the other button to dragging, then the system will have two dragging event. But these two dragging events
	 * will become one dragging event as they are drawing the same thing.So,no need to consider this situation.
	 * The if statement of dragging does not relate to the thing that stated above. It is for the user is dragging
	 * and user press the secondary button at the same time, the canvas will be clean and the user draw nothing on 
	 * the screen as the secondary button's press method instead user has to press again to start drawing. If the 
	 * user is dragging, then checking the position of the user dragging, if the position is outside the canvas 
	 * then make the position equal to the edge of the canvas. If the user is dragging in an acceptable area, the 
	 * making sure the next drawn rectangle is 5 pixels more then the previous drawn rectangle.
	 * @param evt the object of the MouseEvent class. 
	 * */
	private void mouseDragged(MouseEvent evt) {	
		/* Secondary Button: If the user is dragging and the user press and drag the secondary button at the same time,
		 * It will clear the screen and set the dragging be false because of the secondary button's press method. Therefore,
		 * user draw nothing on the screen as dragging set to false. The user have to press the button again to active drawing.
		 * 
		 * Middle Button(besides secondary button): If the user is dragging and the user press and drag the middle button
		 * (not secondary button) at the same time, The system will not response to the middle button's press event because 
		 * of the middle button's press method. But system response to the dragging event, However as the first dragging event
		 * and middle button's dragging event response to the same method which means draw the same thing, there will be not
		 * changes on the screen.
		 * */
		if(dragging == false)
			return;
		
		double x = evt.getX();
		double y = evt.getY();		
		
		if(x < 0)
			x = 0;
		if(x > canvas.getWidth())
			x = canvas.getWidth();
		
		if(y < 0)
			y = 0;
		if(y > canvas.getHeight())
			y = canvas.getHeight();
		
		if(Math.abs(x - preX) >= 5 || Math.abs(y - preY) >= 5)		//As we want the next rectangle is 5 pixel apart from the previous,
																	//so we need to make sure the next position of mouse is 5 part from the previous position of mouse.
																	//According to that, we just to make sure the absolute value of current position delete the previous
																	//position is equal or greater to 5. Both x and y have to be considered.
			drawRectangleAndOval(x, y, evt);
			
	}//end of mouseDragged method
	
	/**This method listen to the mouse releasing event. There is one thing need to state is that if
	 * the user is dragging and the user do the same thing on other button(except secondary button) 
	 * at the same time, the other button will also create press, drag and release event. The other 
	 * button's pressing event has been dealt with, its dragging event will not affect anything, but 
	 * releasing event will immediately stop the user drawing as it has been set dragging to false.
	 * For secondary button, If the user is dragging and the user press and drag the secondary button 
	 * at the same time, It will clear the screen and set the dragging be false because of the secondary 
	 * button's press method. So as there will be one more release event which is for secondary button, 
	 * there will be no changes on the screen as the press event of secondary button has already set 
	 * dragging to false.Once the mouse has released which means the user has stopped dragging, then
	 * setting the dragging global variable to false.
	 * */
	private void mouseReleased() {
		/* Secondary Button: If the user is dragging and the user press and drag the secondary button at the same time,
		 * It will clear the screen and set the dragging be false because of the secondary button's press method. 
		 * So as there will be one more release event which is for secondary button, there will be no changes on the screen as
		 * the press event of secondary button has already set dragging to false.
		 * 
		 * Middle Button(besides secondary button): If the user is dragging and the user press and drag the middle button
		 * (not secondary button) at the same time, The system will not response to the middle button's press event because 
		 * of the middle button's press method. But system response to the dragging event, However as the first dragging event
		 * and middle button's dragging event response to the same method which means draw the same thing, there will be not
		 * changes on the screen. As there will be a release event for middle button, it will set dragging to false which will
		 * immediately stop the use drawing. The previous drawing will still be there.
		 * */
		dragging = false;
	}//end of mouseReleased method
}
