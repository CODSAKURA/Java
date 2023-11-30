package cw2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BoardSquareButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8094353769303680824L;

	private int storerow;
	private int storecolumn;
	
	private boolean mine;
	
	private boolean green;
	private boolean grey;
	
	private boolean potential;
	
	public BoardSquareButton(int width, int height, Color color,int x, int y)
	{
		JButton a = new JButton("?");
		a.setSize(width,height);
		a.setFont(new Font("Dialog", Font.BOLD, 30));
		a.setLocation(x, y);
		a.setBackground(color);
		
		JFrame f=new JFrame("Minesweeper");
		f.setPreferredSize(new Dimension(width, height));
		f.setMinimumSize(new Dimension(width, height));
		
		f.add(a);
	}
	
	public void initialise()
	{
		grey = true;
		mine = false;
		potential = false;
		new JButton().setBackground(Color.gray);
		new JButton().setText("?");
	}
	
	

	public int getrow()
	{
		return storerow;
	}
	
	public void setstorerow( int a )
	{
		storerow = a;
	}
	

	public int getcolumn()
	{
		return storecolumn;
	}
	
	public void setstorecolumn( int f )
	{
		storerow = f;
	}
	
	
	public boolean getmine()
	{
		return mine;
	}
	
	public void setmine( boolean b)
	{
		mine = b;
	}
	

	public boolean getpotential()
	{
		return potential;
	}
	
	public void setpotential( boolean d)
	{
		potential = d;
	}
	

	public boolean getgreen()
	{
		return green;
	}
	
	public void setgreen( boolean c)
	{
		green = c;
	}
	
	
	public boolean getgrey()
	{
		return grey;
	}
	
	public void setgrey( boolean g)
	{
		grey = g;
	}
	
	
}
