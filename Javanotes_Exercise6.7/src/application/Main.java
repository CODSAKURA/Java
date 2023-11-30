package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**This class will create a GUI which enables user to input valid value 
 * into the TextField and then press enter key on keyboard or press enter button
 * on the screen to do the simple calculation on those inputed value. It records
 * number of entries, sum, average and standard deviation of those input value.
 * If the user has inputed an not valid value, it will print a message on the
 * screen and highlight the inputed text. If the user presses clear button, it
 * will clear all the data stored and all result will set to initial state. This
 * program is depended on StatCalc class. 
 * */
public class Main extends Application {
	
	private StatCalc s = new StatCalc();	//Creating the initial StatCalc object, user can create a new one by pressing clear button.
	private Canvas canvasEntries,canvasSum,canvasAverage,canvasDeviation;	//These four canvases will keep changing value.
	private int numberOfEntries;	//Recording the number that have inputed into StatCalc object.
	private Label label= new Label();	//This label will keep changing due to the valid and not valid input.
	
	/**The main method use to launch the program.
	 * @param args the command line argument for this program.
	 * */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**This method is create all the non-changeable nodes on the stage
	 * and add a event handler for two buttons and key presses.
	 * @param stage the current Stage object.
	 * */
	public void start(Stage stage) {
				
		/*Creating a textField and two buttons, then making a horizontal box to contain them*/
		TextField input = new TextField();
		Button enter = new Button("Enter");
		enter.setDefaultButton(true);
		
		Button clear = new Button("Clear");
		HBox containerTextAndButton = new HBox(2,input,enter,clear); //Making 2 gaps between those buttons		
		input.setPrefWidth(100);
		enter.setPrefWidth(100);
		clear.setPrefWidth(100);		
		draw();
		
		enter.setOnMousePressed(evt -> {
			doAction(input,stage);
		});
		
		clear.setOnAction(evt -> {
			s = new StatCalc();
			numberOfEntries = 0;
			input.clear();
			start(stage);
		});
		
		/*Adding all the nodes into a tile pane
		 *Noticed: all nodes are in height 22 and width 304 which is 2 gap between each nodes.
		 **/
		TilePane root = new TilePane(label,containerTextAndButton, canvasEntries,canvasSum,canvasAverage,canvasDeviation);		
		root.setStyle("-fx-background: black; -fx-padding: 2px");	//Setting the top, bottom, left and right padding all be 2
		root.setPrefColumns(1);
		
		Scene scene = new Scene(root);
		
		/*If the user presses the enter key, it also will do the same action as pressing the enter button.*/
		scene.setOnKeyPressed(evt -> {
			if(evt.getCode() == KeyCode.ENTER)
			{
				doAction(input,stage);
			}
		});
		
		stage.setScene(scene);
		stage.setTitle("Simple Calc GUI");
		stage.setResizable(false);
		stage.show();
	}
	
	/**This method will draw all the changeable nodes. Once there
	 * is a number has entered, the program will call this method to
	 * apply the changes.
	 * */
	private void draw() {
		/*Creating Top Label*/
		label.setText("Enter a number, click Enter:");
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		
		/*Creating four canvases.
		 *Canvas's height is 22: white space's height(20) + white space top's gap(2).
		 **/
		
		/*Canvas 1 which is Number of Entries*/
		canvasEntries = new Canvas(304,22);
		GraphicsContext g1 = canvasEntries.getGraphicsContext2D();
		g1.setFill(Color.WHITE);
		g1.fillRect(0, 2, canvasEntries.getWidth(), 20);
		
		g1.setFill(Color.BLACK);
		g1.fillText("Number of Entries : " + numberOfEntries, 10, 16);
		
		/*Canvas 2 which is sum*/
		canvasSum = new Canvas(304,22);
		GraphicsContext g2 = canvasSum.getGraphicsContext2D();
		g2.setFill(Color.WHITE);
		g2.fillRect(0, 2, canvasSum.getWidth(), 20);
		
		g2.setFill(Color.BLACK);
		g2.fillText("Sum : " + s.getSum(), 10, 16);
		
		/*Canvas 3 which is average*/
		canvasAverage = new Canvas(304,22);
		GraphicsContext g3 = canvasAverage.getGraphicsContext2D();
		g3.setFill(Color.WHITE);
		g3.fillRect(0, 2, canvasAverage.getWidth(), 20);		
		g3.setFill(Color.BLACK);		
		
		/*Canvas 4 which is standard deviation*/
		canvasDeviation = new Canvas(304,22);
		GraphicsContext g4 = canvasDeviation.getGraphicsContext2D();
		g4.setFill(Color.WHITE);
		g4.fillRect(0, 2, canvasDeviation.getWidth(), 20);		
		g4.setFill(Color.BLACK);
		
		/*As there is no number in statcalc, the average and Standard Deviation are NaN.
		 *In order to make an understandable showing word, I change NaN to undefined.*/
		if(s.getCount() == 0)
		{
			g3.fillText("Average : undefined", 10, 16);
			g4.fillText("Standard Deviation : undefined", 10, 16);
		}
		else
		{
			g3.fillText("Average : " + s.getMean(), 10, 16);
			g4.fillText("Standard Deviation : " + s.getStandardDeviation(), 10, 16);
		}	
	}
	
	/**This method is do the correct action on those input text in text field.
	 * If the user has inputed an invalid text, it will change the label text and
	 * put focus on the text field and select all the text in text field.
	 * */
	private void doAction(TextField input, Stage stage) {
		try {
			s.enter(Double.parseDouble(input.getText()));
			input.clear();
			numberOfEntries++;
			start(stage);
		}catch(Exception e){
			label.setText("\"" + input.getText() + "\" is not an illegal number!!");
			input.requestFocus();
			input.selectAll();
		}
	}
}
