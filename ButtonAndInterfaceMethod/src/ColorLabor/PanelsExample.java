package ColorLabor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelsExample
{ 
	public static void main(String[] args)
	{ 
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window exits
		frame.setTitle("Hello World!"); // Set a caption/title bar content for the frame
		frame.setLocationRelativeTo(null); // centre on screen
		frame.getContentPane().setLayout(new FlowLayout());

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		frame.getContentPane().setLayout(new BorderLayout(2,2));
		panel1.setLayout(new BorderLayout(2,2)); // 2 pixel gaps
		panel2.setLayout(new FlowLayout()); // Let them flow through
		panel3.setLayout(new GridLayout(5,5)); // 5x5 grid

		frame.getContentPane().add( new ColorLabel( 20, 20, Color.RED, 2, Color.GRAY ), BorderLayout.NORTH );
		frame.getContentPane().add(panel1, BorderLayout.CENTER);
		frame.getContentPane().add( new ColorLabel( 20, 20, Color.GREEN, 2, Color.GRAY ), BorderLayout.SOUTH );
		frame.getContentPane().add( new ColorLabel( 20, 20, Color.BLUE, 2, Color.GRAY ), BorderLayout.WEST );
		frame.getContentPane().add( new ColorLabel( 20, 20, Color.BLUE, 2, Color.GRAY ), BorderLayout.EAST );

		panel1.add(panel2, BorderLayout.NORTH);
		panel1.add(panel3, BorderLayout.CENTER);

		panel2.add(new ColorLabel(100,100, Color.YELLOW, 2,Color.BLACK ));
		panel2.add( new ColorLabel(200,100, Color.PINK, 2,Color.BLACK ));
		panel2.add( new ColorLabel(100,100, Color.YELLOW, 2,Color.BLACK));

		// Add 25 panels
		for ( int i = 0 ; i < 12 ; i++ )
		{
			panel3.add( new ColorLabel( 100, 100, Color.BLUE ) );
			panel3.add( new ColorLabel( 100, 100, Color.BLACK ) );
		}
		panel3.add( new ColorLabel( 100, 100, Color.BLUE ) );

		frame.pack(); // Resize frame to fit content
		frame.setVisible(true); // Display it � until you do it will not appear
	}
}
