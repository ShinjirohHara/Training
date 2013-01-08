package gui2_4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.prefs.Preferences;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DigitalWatch extends JPanel implements ActionListener {

	private static final long serialVersionUID = -6817980970800362509L;

	private Property property;
	private Color currentColor;
	private Font currentFont;
	private JFrame frame;
	private static final String POINT_X = "PointX";
	private static final String POINT_Y = "PointY";
	private static final int DEFALUT_X = 100;
	private static final int DEFALUT_Y = 100;
	
	public static void main (String args[]) {
		
		JFrame frame = new JFrame("DigitalWatch");
		
		frame.setSize(500, 200);
		Preferences prefs = Preferences.userNodeForPackage(DigitalWatch.class);
		int x = prefs.getInt(POINT_X, DEFALUT_X);
		int y = prefs.getInt(POINT_Y, DEFALUT_Y);
		frame.setLocation(x, y);
		
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				Point point = e.getComponent().getLocation();
				
				Preferences prefs = Preferences.userNodeForPackage(DigitalWatch.class);
				prefs.putInt(POINT_X, (int)point.getX());
				prefs.putInt(POINT_Y, (int)point.getY());
				System.exit(0);
			}
		});
		
		DigitalWatch watch = new DigitalWatch(frame);
		// frame.setSize(watch.getSize());
		
		MenuBar mb = new MenuBar();
		watch.setMenu(mb);
		frame.setMenuBar(mb);
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
	DigitalWatch(JFrame frame) {
		this.frame = frame;
		property = new Property(frame, this);
		setVisible(true);
	}
	
	public void setMenu(MenuBar mb){
		Menu menuDisp = new Menu("表示");
		mb.add(menuDisp);
		MenuItem itemProp = new MenuItem(Property.MENU_NAME);
		menuDisp.add(itemProp);
		itemProp.addActionListener(property);
	}


	public void actionPerformed(ActionEvent e) {
		// property.setVisible(true);
	}


	public void paintComponent(Graphics g) {
		
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		
		String digitalString = sdf.format(date);
		FontMetrics fm = g.getFontMetrics(currentFont);
		int width = fm.charsWidth(digitalString.toCharArray(), 0, digitalString.toCharArray().length);
		int height = fm.getHeight();
		g.setFont(currentFont);
		g.setColor(currentColor);
		g.drawString(sdf.format(date), 40, height/2+50);
		frame.setSize(width+80, height+100);
	}


	
	
	public void setColor(Color color) {
		this.currentColor = color;
	}
	public void setStringFont(Font font) {
		this.currentFont = font;
		
	}

}
