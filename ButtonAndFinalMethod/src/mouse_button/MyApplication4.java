package mouse_button;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyApplication4
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
    		guiFrame.getContentPane().add(labels[i]);
    	for ( int i = 0 ; i < labels.length ; i++ )
    		labels[i].addMouseMotionListener( new LabelMouseMoved() );
    	
		but1 = new JButton("Press me"); // Create the new button
   		guiFrame.getContentPane().add(but1);
   		but1.addActionListener(new ButtonPressed());
 		
   		JButton but2 = new JButton("Reset");
  		but2.addActionListener(new ButtonPressed2());
  		guiFrame.getContentPane().add(but2);
  		   		
    	guiFrame.getContentPane().setLayout( new FlowLayout() );
    	guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    	guiFrame.setTitle("Hello World!"); 
    	guiFrame.setLocationRelativeTo(null); 
    	guiFrame.pack();
    	guiFrame.setVisible(true); 
	}

	public class LabelMouseMoved extends MouseAdapter
	{

		@Override
		public void mouseMoved(MouseEvent e)
		{
			but1.setText("changed");
			if ( e.getSource() == labels[0] )
				but1.setText("0");
			else if ( e.getSource() == labels[1] )
				but1.setText("1");
			else if ( e.getSource() == labels[2] )
				but1.setText("2");
			super.mouseMoved(e);
		}
	}

	public class ButtonPressed implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			but1.setText( but1.getText()+".");
			guiFrame.pack();
		}
	}

	public class ButtonPressed2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			but1.setText( "Button 2" );
			guiFrame.pack();
		}
	}
	
}
