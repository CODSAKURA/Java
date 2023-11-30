package cw1c;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Main implements ActionListener{
			
	JFrame guiFrame = new JFrame();		
	ColorLabel arrayLabels[] = new ColorLabel[64];		
	Random rand = new Random();
	JButton but1;
	public void createGUI()
	{
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Label demo");
		guiFrame.setLocationRelativeTo(null);
		guiFrame.getContentPane().setLayout( new BorderLayout() );
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(8,8));
		for(int i = 0 ; i < arrayLabels.length ; i++)
		{
			arrayLabels[i] =new ColorLabel(50,50,new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
			guiFrame.getContentPane().add(arrayLabels[i]);
			panel1.add(arrayLabels[i]);
		}
		but1 = new JButton("Press me to refresh labels");
		synchronized (but1) 
		{
            but1.notify();          
		}
		but1.addActionListener(this);

		
		guiFrame.getContentPane().add(panel1,BorderLayout.NORTH);
		guiFrame.getContentPane().add(but1,BorderLayout.SOUTH);
		
				
		guiFrame.pack(); 
		guiFrame.setVisible(true);
	}
	
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			for(int i = 0 ; i < arrayLabels.length ; i++)
			{
				arrayLabels[i].setDrawColor(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
			}
			guiFrame.repaint();
		}
	
	
	public static void main(String[] args)
	{
		new Main().createGUI();
	}
	

}
