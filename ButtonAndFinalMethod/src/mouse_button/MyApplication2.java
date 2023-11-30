package mouse_button;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyApplication2
{
	JFrame guiFrame = new JFrame();
	ColorLabel labels[] = new ColorLabel[3]; 
	JButton but1; // Initialised to null as a member
	
	public void createGUI()  
	{
		labels[0] = new ColorLabel( 100, 100, Color.RED );
		labels[1] = new ColorLabel( 100, 100, Color.BLUE );
		labels[2] = new ColorLabel( 100, 100, Color.GREEN );
    	for ( int i = 0 ; i < labels.length ; i++ )
    	{
    		guiFrame.getContentPane().add(labels[i]);
    	}
    	
		but1 = new JButton("Press me"); // Create the new button
   		guiFrame.getContentPane().add(but1);
   		but1.addActionListener(new ButtonPressed());
   		
    	guiFrame.getContentPane().setLayout( new FlowLayout() );
    	guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    	guiFrame.setTitle("Hello World!"); 
    	guiFrame.setLocationRelativeTo(null); 
    	guiFrame.pack();
    	guiFrame.setVisible(true); 
	}

	// NEW CLASS
	public class ButtonPressed implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			but1.setText( but1.getText()+".");
			guiFrame.pack();
		}
	}
}
