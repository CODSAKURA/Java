package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**This class generates a blue screen with two dices. The dices are in a random
 * numbers at beginning. User can change these dices' numbers by clicking anywhere
 * in the blue screen. As the screen is too small to hold the minimize button on the
 * stage. Therefore, this program only hold close button and title on the screen.
 * */
public class Main extends Application {
	private Canvas canvas = new Canvas(100,100);	//Creating a canvas which belonging to this class.
	private GraphicsContext g = canvas.getGraphicsContext2D();	//Creating this class's graphics context by using canvas.
	private Dice d1,d2; 	//Creating two dices class objects which belonging to this class.
	
	/**The main method uses to launch this program.
	 * @param args this program's argument.
	 * */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**This method generates everything which will be shown on the window screen.
	 * Also, it creates an event handler for reacting the user clicking event.
	 * @param stage the stage class's object which will hold all the nodes that will be shown on the screen
	 * */
	public void start(Stage stage) {		
		draw();
		canvas.setOnMouseClicked(evt -> {
			draw();
		});
		
		BorderPane root = new BorderPane(canvas);
		root.setStyle("-fx-border-color:blue; -fx-border-width:2px");
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		stage.initStyle(StageStyle.UTILITY);	//Hidden the minimize, maximize button 
		stage.setResizable(false);		//Disable the resize function
		
		stage.setTitle("JavaFX Test");
		stage.show();
	}
	
	/**This method will draw all the things that will appear on the screen including the 
	 * background and two dices. Also, it will draw the new changes after the user clicking.
	 * */
	private void draw() {
		g.setFill(Color.rgb(200, 200, 255));
		g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		d1 = new Dice(10,10);
		d1.roll();
		d2 = new Dice(55,55);
		d2.roll();
	}
	
	//The nested class of Dice
	
	class Dice{
		
		private int diceX,diceY;	//Two variables which are belonging to a specific dice
		
		/**The dice constructor which requires two parameters to specify its location. And,
		 * the drawing itself event is done by calling constructor.
		 * @param x,y variables that specify the dice's location.
		 * */
		public Dice(int x, int y) {
			this.diceX = x;
			this.diceY = y;
			g.setFill(Color.BLACK);
			g.setLineWidth(2);
			g.strokeRect(diceX - 1, diceY - 1, 40, 40);
			g.setFill(Color.WHITE);
			g.fillRect(diceX, diceY, 38, 38);
		}
		
		/**This method will generate a random number in a range 1 to 6. This number will
		 * decide the number that are shown on the dice. Once the number has decided, this
		 * method will draw the dots on the dice.
		 * */
		public void roll() {
			int number = (int)(6 * Math.random()) + 1;
			g.setFill(Color.BLACK);
			
			switch(number) {				
				case 1:
					g.fillOval(diceX + 14, diceY + 14, 10, 10);		//Why 14?: As a dice's height and width are 38,38, the middle point will be (19,19).
																	//Because the radius of the dot is 5, we have to delete middle point by 5 to find the 
																	//left top point of the rectangle as the oval is drawn in a rectangle. Therefore, the 
																	//point will be (14,14).[All this is making a assumption that dice is drawn on the (0,0)]
					break;
				case 2:
					g.fillOval(diceX + 4, diceY + 4, 10, 10);
					g.fillOval(diceX + 24, diceY + 24, 10, 10);
					break;
				case 3:
					g.fillOval(diceX + 4, diceY + 4, 10, 10);
					g.fillOval(diceX + 14, diceY + 14, 10, 10);
					g.fillOval(diceX + 24, diceY + 24, 10, 10);
					break;
				case 4:
					g.fillOval(diceX + 4, diceY + 4, 10, 10);
					g.fillOval(diceX + 24, diceY + 4, 10, 10);
					g.fillOval(diceX + 24, diceY + 24, 10, 10);
					g.fillOval(diceX + 4, diceY + 24, 10, 10);
					break;
				case 5:
					g.fillOval(diceX + 4, diceY + 4, 10, 10);
					g.fillOval(diceX + 24, diceY + 4, 10, 10);
					g.fillOval(diceX + 14, diceY + 14, 10, 10);
					g.fillOval(diceX + 24, diceY + 24, 10, 10);
					g.fillOval(diceX + 4, diceY + 24, 10, 10);
					break;
				default:
					g.fillOval(diceX + 6, diceY + 2, 10, 10);
					g.fillOval(diceX + 6, diceY + 14, 10, 10);
					g.fillOval(diceX + 6, diceY + 26, 10, 10);
					
					g.fillOval(diceX + 22, diceY + 2, 10, 10);
					g.fillOval(diceX + 22, diceY + 14, 10, 10);
					g.fillOval(diceX + 22, diceY + 26, 10, 10);
					break;
			}	
		}
	}
}
