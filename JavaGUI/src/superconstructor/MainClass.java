package superconstructor;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainClass 
{
	
	static JLabel create()
	{
		JLabel label = new JLabel();
		label.setText("Hello World (again)!"); 
		label.setFont(new Font("Ariel", Font.BOLD, 70));
		return label;
		
	}
	
	
	public static void main(String[] args) {
		
		JFrame guiFrame = new JFrame(); 
		guiFrame.setTitle("Hello World!");
		guiFrame.setLocationRelativeTo(null); 
		guiFrame.getContentPane().setLayout( new FlowLayout() ); 
			
		guiFrame.getContentPane().add(new MyLabel());
		guiFrame.getContentPane().add(new MyLabel("周迪是傻缺"));
		guiFrame.getContentPane().add(new MyLabel("周迪是沙雕"));
		guiFrame.pack(); 
		guiFrame.setVisible(true);
	}
}
