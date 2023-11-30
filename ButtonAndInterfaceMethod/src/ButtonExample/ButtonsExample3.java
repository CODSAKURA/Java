package ButtonExample;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ButtonsExample3 implements ActionListener
{ 
	public ButtonsExample3()
	{
		JFrame guiFrame = new JFrame(); // Create a new frame object � top level window
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window exits
		guiFrame.setTitle("Hello World!"); // Set a caption/title bar content for the frame
		guiFrame.setLocationRelativeTo(null); // centre on screen
		guiFrame.getContentPane().setLayout(new FlowLayout());
		
		JLabel label = new JLabel(); // Create a new label object
		label.setText("Hello World (again)!"); // Set its message to show
		label.setFont(new Font("Ariel", Font.BOLD, 30)); // Set a font for the label
		guiFrame.getContentPane().add(label); // Add the label to the frame, so that it will show

		JButton button1 = new JButton("Hello");
		guiFrame.getContentPane().add(button1);

		guiFrame.pack(); // Resize frame to fit content
		guiFrame.setVisible(true); // Display it � until you do it will not appear
	}

	public static void main(String[] args)
	{
		new ButtonsExample3();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}

