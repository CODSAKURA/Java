package application;
	
import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**This class will generate a board that allows user to click
 * the point on the board. It will generate a 10*10 black square
 * on the point that user has clicked and a line connected the points.
 * Once the user clicks the initial clicked point, a polygon will be 
 * drawn on the screen with black border and red filling. If the user
 * clicks on the screen again after the polygon shown, the program will
 * do the same thing as stated above.
 * */
public class Main extends Application {
	
	private Canvas canvas = new Canvas(400,400);		//The canvas that allows user to do the action。
	private GraphicsContext g = canvas.getGraphicsContext2D();		//The graphic context that related to the canvas.
	private double[] x = new double[0];		//The array that stored the x axis of the click point.
	private double[] y = new double[0];		//The array that stored the y axis of the click point.
	private int addNodesNumber = 0;			//Counting the number that nodes have been stored.
	private boolean hasDrawnPolygon = false;	//Checking the state whether the polygon has been drawn or not.
	
	/**The main method that uses to launch the program.
	 * @param args the command line arguments for this program.
	 * */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**This method generates the initial layout of the screen and
	 * set an event handler on the canvas so that it can generate
	 * different reaction on the state after polygon has drawn, the 
	 * state if the user click the initial point after multiple clicks and
	 * the state besides the states mentioned above.
	 * @param stage the stage object that represents the current stage.
	 * */
	public void start(Stage stage) {
		
		canvas.setOnMousePressed(evt -> {	

			/*Checking whether there are something left on the screen before user clicks. If so,
			 *then clean the canvas.*/
			if(hasDrawnPolygon)
			{
				resetInitialState();
			}
			
			/*If the user has clicked more than 3 nodes and clicked a 5*5 square around the initial click point,
			 *then the program will draw the polygon. Otherwise, it will add nodes to two global arrays.*/
			if(addNodesNumber > 2 && Math.abs(x[0] - evt.getX()) < 5 && Math.abs(y[0] - evt.getY()) < 5)
			{
				draw();
			}
			else
			{
				addNodes(evt);
			}
		});
				
		BorderPane root = new BorderPane(canvas);
		root.setStyle("-fx-border-color: black; -fx-border-width: 2px");
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Polygons Drawing");
		stage.show();
	}
	
	/**This method is used to draw the polygon by using the nodes that user 
	 * has been clicked which are stored in the global array variables. Then,
	 * setting the boolean variable to true.
	 * */
	private void draw() {		
		g.setFill(Color.WHITE);
		g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		g.setStroke(Color.BLACK);
		g.setLineWidth(5);
		g.strokePolygon(x, y, addNodesNumber);
		
		g.setFill(Color.RED);
		g.fillPolygon(x, y, addNodesNumber);
		
		hasDrawnPolygon = true;
	}
	
	/**This method will add the point that user has been clicked and draw
	 * a line between the user clicked points. Noticed that there will 
	 * be not line drawn if there is only one point stored in array.
	 * The way it stored the node is that: as the array starts from 0 and
	 * addNodesNumber is started from 1, the array size will increase by using the
	 * addNodesNumber and copy the previous data that stored in array(for example: 4) to the new
	 * size array(for example: 5) and store the current point to the new size array - 1(for example: 4).
	 * @param evt the MouseEvent object that stored the messages of the mouse action.
	 * */
	private void addNodes(MouseEvent evt) {
		addNodesNumber++;
		x = Arrays.copyOf(x, addNodesNumber);		
		y = Arrays.copyOf(y, addNodesNumber);
		x[addNodesNumber - 1] = evt.getX();
		y[addNodesNumber - 1] = evt.getY();
		
		g.setFill(Color.BLACK);
		g.fillRect(evt.getX() - 5, evt.getY() - 5, 10, 10);
		
		if(x.length > 1)
		{
			g.setStroke(Color.BLACK);
			g.strokeLine(x[addNodesNumber - 2], y[addNodesNumber - 2], evt.getX(), evt.getY());
		}
	}
	
	/**This method use to reset the state of the stage to the initial
	 * state and set all variables to the initial state.
	 * */
	private void resetInitialState() {
		g.setFill(Color.WHITE);
		g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		x = new double[0];
		y = new double[0];
		addNodesNumber = 0;
		hasDrawnPolygon = false;
	}
}	
