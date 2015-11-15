package jframeVorlage;

import java.awt.Container;

import javax.swing.JFrame;

public class JFrameVorlage {
	
	private JFrame frame1 = new JFrame("JFrame Vorlage");
	
	public JFrameVorlage() {
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(600,600);
		frame1.setResizable(false);
		Container cp = frame1.getContentPane();
		cp.setLayout(null);
		
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}	

	public static void main(String[] args) {
		new JFrameVorlage();
	}
}