package gui2_1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class DigitalWatch extends JPanel
{


	private static final long serialVersionUID = -6817980970800362509L;

	public static void main (String args[]) {
		JFrame frame = new JFrame("DigitalWatch");
		frame.setSize(200, 100);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		DigitalWatch watch = new DigitalWatch();
		frame.add(watch, BorderLayout.CENTER);
		while(true) {
			frame.repaint();
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		Dimension dim = getSize();
		double width =  dim.getWidth();
		double height = dim.getHeight();
		double size = 0;
		if (width < height *2 ) {
			size = width/5;
		} else {
			size = height/2.5;
		}
		g.setFont(new Font("dialog", Font.BOLD, (int) size));
		g.drawString(sdf.format(date), (int)width/15, (int) height/2+30);
	}
	

	
}
