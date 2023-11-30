package application;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *  This file can be used to draw simple pictures.  Just fill in
 *  the definition of drawPicture with the code that draws your picture.
 */
public class Main extends Application {

    /**
     * Draws a picture.  The parameters width and height give the size 
     * of the drawing area, in pixels.  
     */
    public void drawPicture(GraphicsContext g, int width, int height) {
    	
    	for(int i = 0 ; i < height; i = i + 50)
    	{
    		/*Check whether the row number is odd or even*/
    		if(i % 20 == 0)
    		{
    			/*Check whether the column number is odd or even*/
    			for(int j = 0; j < width; j = j + 50)
    			{
    				if(j % 20 != 0)
    				{
    					g.setFill(Color.BLACK);
    					g.fillRect(j, i, 50, 50); 
    				}
    				else
    				{
    					g.setFill(Color.RED);
    					g.fillRect(j, i, 50, 50); 
    				}
    			}
    		}
    		else
    		{
    			/*Check whether the column number is odd or even*/
    			for(int j = 0; j < width; j = j + 50)
    			{
    				if(j % 20 != 0)
    				{
    					g.setFill(Color.RED);
    					g.fillRect(j, i, 50, 50); 
    				}
    				else
    				{
    					g.setFill(Color.BLACK);
    					g.fillRect(j, i, 50, 50); 
    				}
    			}
    		}    		
    	}
    } // end drawPicture()

    //------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------


    public void start(Stage stage) {
        int width = 400;   // The width of the image.  You can modify this value!
        int height = 400;  // The height of the image. You can modify this value!
        Canvas canvas = new Canvas(width,height);
        drawPicture(canvas.getGraphicsContext2D(), width, height);
        BorderPane root = new BorderPane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Checkerboard"); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);
    } 

    public static void main(String[] args) {
        launch();
    }

} // end SimpleGraphicsStarter