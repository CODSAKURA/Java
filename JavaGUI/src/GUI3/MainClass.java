package GUI3;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class MainClass 
{	
	public static void main(String[] args) {
		
		JFrame guiFrame = new JFrame(); 
		guiFrame.setTitle("Hello World!");
		guiFrame.setLocationRelativeTo(null); 
		guiFrame.getContentPane().setLayout( new FlowLayout() ); 
			
		guiFrame.getContentPane().add(new ColorLabel(50,50,Color.GREEN,5,Color.CYAN));
		guiFrame.getContentPane().add(new ColorLabel(100,100,Color.BLACK));
		guiFrame.getContentPane().add(new ColorLabel());
		guiFrame.getContentPane().add(new ColorLabel(50,50,Color.GREEN,5,Color.CYAN));
		guiFrame.getContentPane().add(new ColorLabel(100,100,Color.BLACK));
		guiFrame.getContentPane().add(new ColorLabel());
		guiFrame.pack(); 
		guiFrame.setVisible(true);
	}
}
