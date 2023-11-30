package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		Canvas canvas = new Canvas(400,400);		
		
		canvas.setOnMousePressed( evt -> {
		    GraphicsContext g = canvas.getGraphicsContext2D();
		    if ( evt.isShiftDown() ) {
		        g.setFill( Color.BLUE );
		        g.fillOval( evt.getX() - 30, evt.getY() - 15, 60, 30 );
		    }
		    else {
		        g.setFill( Color.RED );
		        g.fillRect( evt.getX() - 30, evt.getY() - 15, 60, 30 );
		    }
		} );
		
		BorderPane root = new BorderPane();
		root.setCenter(canvas);
		
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	

}
