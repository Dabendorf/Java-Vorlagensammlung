package jframeVorlage; 

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class JFrameVorlageGridBagLayout {
	
	private JFrame frame1 = new JFrame("JFrame Vorlage");
	
	public JFrameVorlageGridBagLayout() {
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setPreferredSize(new Dimension(300,200)); //ANPASSEN
		frame1.setMinimumSize(new Dimension(300,200));
		frame1.setMaximumSize(new Dimension(450,300));
		frame1.setResizable(true);
		Container cp = frame1.getContentPane();
		cp.setLayout(new GridBagLayout());
		
		frame1.pack();
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}	

	public static void main(String[] args) {
		new JFrameVorlageGridBagLayout();
	}
}