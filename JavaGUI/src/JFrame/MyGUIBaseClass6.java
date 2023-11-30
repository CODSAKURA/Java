package JFrame;


import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyGUIBaseClass6 
{
	static int count = 1;
	static JLabel create()
	{
		JLabel label = new JLabel("Hello World " + count);/*change*/
		count++; /*change*/
		label.setFont(new Font("Ariel", Font.BOLD, 30));
		return label;
		
	}
	public static void main(String[] args) {
		
		JFrame guiFrame = new JFrame(); 
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Hello World!");

		guiFrame.getContentPane().setLayout( new FlowLayout() ); 
			
		guiFrame.getContentPane().add(create());
		guiFrame.getContentPane().add(create());
		guiFrame.getContentPane().add(create());
		guiFrame.pack();/*know how big the window are*/
		guiFrame.setLocationRelativeTo(null); /*set location to the center of the screen*/
		guiFrame.setVisible(true);
	}
}


