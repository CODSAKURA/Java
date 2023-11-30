package JFrame;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyGUIBaseClass4 
{
	
	static JLabel create()
	{
		JLabel label = new JLabel();
		label.setText("Hello World (again)!"); 
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
		guiFrame.pack();/*know how big the window are*/ /*change*/
		guiFrame.setLocationRelativeTo(null); /*set location to the center of the screen*/ /*change*/
		guiFrame.setVisible(true);
	}
}
