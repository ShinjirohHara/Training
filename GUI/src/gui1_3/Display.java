package gui1_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Display extends Frame implements ActionListener {

	private static final long serialVersionUID = -6817980970800362509L;
	

	
	private Property property = new Property(this);
	
	int cuurentSize = 64;
	private Font currentFont = new Font(Font.SANS_SERIF, Font.PLAIN, cuurentSize);
	private Color currentColor = Color.RED;
	
	
	
	
	public static void main (String args[]) {
		Display watch = new Display();
		
		while(true) {
			watch.repaint();
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				
			}
		}
	}
	Display() {
		super("DigitalWatch");

		setSize(400, 200);
		setVisible(true);
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		Menu menuDisp = new Menu("•\Ž¦");
		mb.add(menuDisp);
		MenuItem itemProp = new MenuItem(Property.MENU_NAME);
		menuDisp.add(itemProp);
		itemProp.addActionListener(property);
		setBackground(Color.WHITE);
		
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
		
		
		Dimension dim = getSize();
		double width =  dim.getWidth();
		double height = dim.getHeight();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		
		Image back = createImage((int)width, (int)height);
		Graphics buffer = back.getGraphics();
	
		buffer.setFont(currentFont);
		buffer.setColor(currentColor);
		buffer.drawString(sdf.format(date), (int)width/15, (int)height/2+20);
		g.drawImage(back, 0, 0, this);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	public void setStringColor(Color color) {
		currentColor = color;
	}
	
	public void setStringFont(Font font) {
		currentFont = font;
	}
}
