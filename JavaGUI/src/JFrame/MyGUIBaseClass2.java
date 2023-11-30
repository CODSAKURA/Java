package JFrame;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyGUIBaseClass2 
{
	
	static JLabel create() /*change*/
	{
		JLabel label = new JLabel();
		label.setText("Hello World (again)!"); 
		label.setFont(new Font("Ariel", Font.BOLD, 70));
		return label;
		
	}
	public static void main(String[] args) {
		
		JFrame guiFrame = new JFrame(); 
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Hello World!");
		guiFrame.setLocationRelativeTo(null); 
		guiFrame.getContentPane().setLayout( new FlowLayout() ); 
			
		guiFrame.getContentPane().add(create()); /*change*/
		guiFrame.pack(); 
		guiFrame.setVisible(true);
	}
}