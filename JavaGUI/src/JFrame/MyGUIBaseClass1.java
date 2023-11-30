package JFrame;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyGUIBaseClass1 
{
	
	static JLabel create()
	{
		return new JLabel();
	}

	public static void main(String[] args) {
		
		JFrame guiFrame = new JFrame(); 		
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Hello World!");
		guiFrame.setLocationRelativeTo(null); 
		guiFrame.getContentPane().setLayout( new FlowLayout() ); 
		
		JLabel label = create();
		label.setText("Hello World (again)!"); 
		label.setFont(new Font("Ariel", Font.BOLD, 70));
		
		guiFrame.getContentPane().add(label); 
		guiFrame.pack(); 
		guiFrame.setVisible(true); 
	}
}
