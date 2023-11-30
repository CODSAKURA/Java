package cw2;

import java.awt.Point;

import javax.swing.JButton;
import javax.swing.text.View;

import java.util.Random;

public class Board{
	
	BoardSquareButton a = new BoardSquareButton(60,60,null,10,10);
	
	public Point getButton(int x, int y)
	{
		x = a.getrow();
		y = a.getcolumn();
		return new Point(x,y);
	}

	public void storeButton(int x, int y, Point button)
	{
		a.setstorecolumn(x);
		a.setstorecolumn(y);
		button.setLocation(x, y);
	}
	
	public void initialiseAll()
	{
		a.initialise();
	}
	
	public void createMines(int number)
	{
		for (int countBomb = 0; countBomb <= number; countBomb++) {
			
		}
	}

}
