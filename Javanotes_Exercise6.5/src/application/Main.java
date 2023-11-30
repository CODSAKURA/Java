package application;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *  This program draws a checkerboard and allows user to click the square.
 *  If the square is clicked, there will be a blue border around that square.
 *  If the user clicks that highlight square again, the highlight square will
 *  be not highlighted. If the user clicks other's square, the previous highlighted
 *  square will be not highlighted instead the new square that user has clicked will
 *  be highlighted. 
 */
public class Main extends Application {

	private int preX = -1,preY = -1;	//Obtaining the previous mouse click x and y position
    /**
     * Draws a picture.  The parameters width and height give the size 
     * of the drawing area, in pixels. It will highlight the square that user
     * has clicked with a blue border around that square.
     * @param g the graphic context object that is used to do the drawing
     * @param width the canvas width
     * @param height the canvas height
     */
    public void drawPicture(GraphicsContext g, int width, int height) {

          int row;   // Row number, from 0 to 7
          int col;   // Column number, from 0 to 7
          int x,y;   // Top-left corner of square

          for ( row = 0;  row < width;  row++ ) {

             for ( col = 0;  col < height;  col++) {
                x = col * 50;
                y = row * 50;
                if ( (row%2 == 0 && col%2 == 0) || (row%2 == 1 && col%2 == 1) )
                   g.setFill(Color.RED);
                else
                   g.setFill(Color.BLACK);
                g.fillRect(x, y, 50, 50);
             } 

          }
          
          if(preX >= 0 && preY >= 0)
          {      		
      		g.setStroke(Color.rgb(12, 243, 243));
      		g.setLineWidth(3);
      		g.strokeRect(preX*50 + 1.5, preY * 50 + 1.5, 47, 47);
          }

    } // end drawPicture()

    //------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------


    /**This method creates the default screen and allows the user click the 
     * square.
     * @param stage the object of Stage that contains all the nodes. 
     * */
    public void start(Stage stage) {
        int width = 400;   // The width of the image.  You can modify this value!
        int height = 400;  // The height of the image. You can modify this value!
        Canvas canvas = new Canvas(width,height);
        drawPicture(canvas.getGraphicsContext2D(), width, height);
        
        canvas.setOnMousePressed(evt -> {
        	
        	/*If the user clicks the previous highlighted square, that square will not be 
        	 * highlighted anymore. If the user clicks other square, the previous highlighted 
        	 * square will not highlighted instead the new square that user has clicked will be
        	 * highlighted.*/
        	if(preX == (int)(evt.getX()/50) && preY == (int)(evt.getY()/50))
        	{
        		preX = -1;
        		preY = -1;
        	}
        	else
        	{        	
        		preX = (int)(evt.getX()/50);
        		preY = (int)(evt.getY()/50);
        	}
        	drawPicture(canvas.getGraphicsContext2D(), width, height);

        });
        
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Checkerboard"); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);
    } 

    /**The main method that launch the program.
     * @param args the command line arguments for this program.
     * */
    public static void main(String[] args) {
        launch();
    }

} // end Checkerboard
