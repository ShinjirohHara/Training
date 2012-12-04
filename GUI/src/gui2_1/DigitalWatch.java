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
	private Font currentFont = new Font("dialog", Font.PLAIN, 64);

	public static void main (String args[]) {
		
		JFrame frame = new JFrame("DigitalWatch");
		frame.setSize(350, 200);
		
		
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		DigitalWatch watch = new DigitalWatch();
		frame.add(watch, BorderLayout.CENTER);
		frame.setVisible(true);
		while(true) {
			frame.repaint();
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		String dateString = sdf.format(new Date());
		System.out.println(dateString);
		g.setFont(currentFont);
		g.drawString(dateString, 30, 100);

	}
	

	
}
