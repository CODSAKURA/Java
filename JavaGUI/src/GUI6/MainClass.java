package GUI6;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass 
{	
	public static void main(String[] args) {
		
		JFrame guiFrame = new JFrame();
		
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		
		guiFrame.getContentPane().add(panel1);
		guiFrame.getContentPane().add(panel2);
		
		panel1.add(new ColorLabel());
		panel2.add(new ColorLabel(200,200,Color.CYAN));
		
		
		
		guiFrame.setTitle("Hello World!");
		guiFrame.setLocationRelativeTo(null); 
		guiFrame.getContentPane().setLayout( new GridLayout(2,2) ); 
			
		guiFrame.getContentPane().add(new ColorLabel(100,100,Color.BLUE));
		guiFrame.getContentPane().add(new ColorLabel(100,100,Color.BLACK));
		guiFrame.getContentPane().add(new ColorLabel(100,100,Color.GREEN));
		guiFrame.getContentPane().add(new ColorLabel(100,100,Color.YELLOW));
		

		guiFrame.pack(); 
		guiFrame.setVisible(true);
	}
}

