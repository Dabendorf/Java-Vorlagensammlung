package canvasVorlage;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CanvasVorlageButton {
	
	private static JFrame frame1 = new JFrame("Canvas Vorlage");
	private Canvas canvas = new Canvas() {
		public void paint(Graphics stift) {
			zeichne(stift);
		}
	};
	private Button buttonzeichnen = new Button();
	
	public CanvasVorlageButton() {
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(600,600);
		frame1.setResizable(false);
		Container cp = frame1.getContentPane();
		cp.setLayout(null);
		
		canvas.setBounds(0,50,frame1.getWidth(),frame1.getHeight()-50);
		cp.add(canvas);
		buttonzeichnen.setBounds(500,10,75,25);
		buttonzeichnen.setLabel("Zeichne");
		buttonzeichnen.setVisible(true);
		buttonzeichnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonZeichne_ActionPerformed(evt);
			}
		});
		cp.add(buttonzeichnen);
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}
	private void buttonZeichne_ActionPerformed(ActionEvent evt) {
		canvas.repaint();
	}
	  
	private void zeichne(Graphics stift) {
		//stift.drawLine(0, 0, 300, 500);
	}
	
	public static void main(String[] args) {
		new CanvasVorlageButton();
	}
}