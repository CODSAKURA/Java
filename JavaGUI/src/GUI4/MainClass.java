package GUI4;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainClass 
{	
	public static void main(String[] args) {
		
		JFrame guiFrame = new JFrame(); 
		guiFrame.setTitle("Hello World!");
		guiFrame.setLocationRelativeTo(null); 
		guiFrame.getContentPane().setLayout( new GridLayout(2,2) ); 
			
		guiFrame.getContentPane().add(new ColorLabel(100,100,Color.BLUE));
		guiFrame.getContentPane().add(new ColorLabel(100,100,Color.RED));
		guiFrame.getContentPane().add(new ColorLabel(100,100,Color.BLACK));
		guiFrame.getContentPane().add(new ColorLabel(100,100,Color.GREEN));
		guiFrame.pack(); 
		guiFrame.setVisible(true);
	}
}
