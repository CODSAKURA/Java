package VariableArityMethod;

import java.awt.Graphics;
import java.awt.Point;

public class DrawPolygon {

	public static void drawPolygon(Graphics g, Point... points) 
	{
	    if (points.length > 1) 
	    {  // (Need at least 2 points to draw anything.)
	       for (int i = 0; i < points.length - 1; i++) 
	       {
	           // Draw a line from i-th point to (i+1)-th point
	           g.drawLine( points[i].x, points[i].y, points[i+1].x, points[i+1].y );
	       }
	       // Now, draw a line back to the starting point.
	       g.drawLine( points[points.length-1].x, points[points.length-1].y,points[0].x, points[0].y );
	    }
	}

}
