package canvasVorlage;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;

public class CanvasVorlage {
	
	private static JFrame frame1 = new JFrame("Canvas Vorlage");
	private Canvas canvas = new Canvas() {
		public void paint(Graphics stift) {
			zeichne(stift);
		}
	};
	
	public CanvasVorlage() {
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(600,600);
		frame1.setResizable(false);
		Container cp = frame1.getContentPane();
		cp.setLayout(null);
		
		canvas.setBounds(0,0,frame1.getWidth(),frame1.getHeight());
		cp.add(canvas);
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}
	
	private void zeichne(Graphics stift) {
		//stift.drawLine(0, 0, 300, 500);
	}
	
	public static void main(String[] args) {
		new CanvasVorlage();
	}
}