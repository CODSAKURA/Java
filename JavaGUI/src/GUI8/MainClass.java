package GUI8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		
		
		guiFrame.getContentPane().setLayout( new BorderLayout() );
		
		guiFrame.getContentPane().add(panel1,BorderLayout.CENTER);
		guiFrame.getContentPane().add(panel2,BorderLayout.NORTH);
		guiFrame.getContentPane().add(panel3,BorderLayout.WEST);
		panel1.add(new ColorLabel());
		panel2.add(new ColorLabel());
		panel3.add(new ColorLabel());
				
		guiFrame.setTitle("Hello World!");
		guiFrame.setLocationRelativeTo(null); 
		 
			
		guiFrame.getContentPane().add(new ColorLabel(200,200,Color.BLUE),BorderLayout.SOUTH);
		guiFrame.getContentPane().add(new ColorLabel(200,200,Color.BLACK),BorderLayout.EAST);
		

		guiFrame.pack(); 
		guiFrame.setVisible(true);
	}
}


