package gui1_4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalWatch extends Frame implements ActionListener {

	private static final long serialVersionUID = -6817980970800362509L;

	private Property property = new Property(this);
	private Color currentColor;
	private Font currentFont;

	public static void main (String args[]) {
		DigitalWatch watch = new DigitalWatch();

		while(true) {
			watch.repaint();
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {

			}
		}
	}
	DigitalWatch() {
		super("DigitalWatch");
		
		setVisible(true);
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		Menu menuDisp = new Menu("•\Ž¦");
		mb.add(menuDisp);
		MenuItem itemProp = new MenuItem(Property.MENU_NAME);
		menuDisp.add(itemProp);
		itemProp.addActionListener(property);
		setBackground(property.getBackground());

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}


	public void actionPerformed(ActionEvent e) {
		property.setVisible(true);
	}


	public void paint(Graphics g) {
		
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		
		String digitalString = sdf.format(date);
		FontMetrics fm = g.getFontMetrics(currentFont);
		int width = fm.charsWidth(digitalString.toCharArray(), 0, digitalString.toCharArray().length);
		int height = fm.getHeight();
		Image back = createImage((int)width+40, (int)height+150);
		Graphics buffer = back.getGraphics();
		buffer.setFont(currentFont);
		buffer.setColor(currentColor);
		buffer.drawString(sdf.format(date), 40, 150);
		g.drawImage(back, 0, 0, this);
		setSize(width+80, height+150);
	}

	public void update(Graphics g) {
		paint(g);
	}
	public void setColor(Color color) {
		this.currentColor = color;
	}
	public void setStringFont(Font font) {
		this.currentFont = font;
		
	}

}
