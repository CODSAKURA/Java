package application;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class RoundRectShape extends Shape {
	    Color randomColor() { 
	        Random random = new Random(); 
	        int r = random.nextInt(255); 
	        int g = random.nextInt(255); 
	        int b = random.nextInt(255); 
	        return Color.rgb(r, g, b); 
	    } 
            // This class represents rectangle shapes with rounded corners.
            // (Note that it uses the inherited version of the 
            // containsPoint(x,y) method, even though that is not perfectly
            // accurate when (x,y) is near one of the corners.)
        void draw(GraphicsContext g) {
            g.setFill(color = randomColor());
            g.fillRoundRect(left,top,width,height,width/3,height/3);
            g.setStroke(Color.BLACK);
            g.strokeRoundRect(left,top,width,height,width/3,height/3);
        }
    }
