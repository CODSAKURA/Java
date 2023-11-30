package application;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class OvalShape extends Shape {
	    Color randomColor() { 
	        Random random = new Random(); 
	        int r = random.nextInt(255); 
	        int g = random.nextInt(255); 
	        int b = random.nextInt(255); 
	        return Color.rgb(r, g, b); 
	    } 
            // This class represents oval shapes.
        void draw(GraphicsContext g) {
            g.setFill(color = randomColor());
            g.fillOval(left,top,width,height);
            g.setStroke(Color.BLACK);
            g.strokeOval(left,top,width,height);
        }
        boolean containsPoint(int x, int y) {
                // Check whether (x,y) is inside this oval, using the
                // mathematical equation of an ellipse.  This replaces the
                // definition of containsPoint that was inherited from the
                // Shape class.
            double rx = width/2.0;   // horizontal radius of ellipse
            double ry = height/2.0;  // vertical radius of ellipse 
            double cx = left + rx;   // x-coord of center of ellipse
            double cy = top + ry;    // y-coord of center of ellipse
            if ( (ry*(x-cx))*(ry*(x-cx)) + (rx*(y-cy))*(rx*(y-cy)) <= rx*rx*ry*ry )
                return true;
            else
                return false;
        }
    }