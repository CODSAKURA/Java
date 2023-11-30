package superconstructor1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;

public class MyLabel extends JLabel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2705250066070060842L;
	
	protected static int count = 1;
	
	public MyLabel()
	{
		super("这是初始的" + count++);
		setFont(new Font("Ariel", Font.BOLD, 30));
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.drawOval(0,0,getWidth()-1,getHeight()-1);
		g.fillOval(0,0,getWidth()-1,getHeight()-1);
		
	} 

}

