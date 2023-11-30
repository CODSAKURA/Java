package application;


import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class RectShape extends Shape {
	    Color randomColor() { 
	        Random random = new Random(); 
	        int r = random.nextInt(255); 
	        int g = random.nextInt(255); 
	        int b = random.nextInt(255); 
	        return Color.rgb(r, g, b); 
	    } 
            // This class represents rectangle shapes.
        void draw(GraphicsContext g) {
            g.setFill(color = randomColor());
            g.fillRect(left,top,width,height);
            g.setStroke(Color.BLACK);
            g.strokeRect(left,top,width,height);
        }
    }