package superconstructor;

import java.awt.Font;
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
	
	public MyLabel( String str )
	{
		super( str + count++);
		setFont(new Font("Ariel", Font.BOLD, 30));
	}
	
}
