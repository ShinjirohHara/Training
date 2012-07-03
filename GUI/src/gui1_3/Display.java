package gui1_3;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Display extends Window implements MouseMotionListener, MouseListener{

	private static final long serialVersionUID = -6817980970800362509L;
	
	

	
	private Property property = new Property();
	
	int cuurentSize = 64;
	
	private Point pressedPoint;
	
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
		super(new Frame("DegitalWatch"));
		setSize(400, 200);
		setVisible(true);
		add(property);
		addMouseMotionListener(this);
		addMouseListener(this);
		setBackground(Color.WHITE);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	

	public void paint(Graphics g) {
		Dimension dim = getSize();
		int size = property.getCurrentFont().getSize();
		double width =  size*5;
		double height = size+2.5 + 20;
		setSize((int)width, (int)height);
		setBackground(property.getBackGround().getColor());
		
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		
		Image back = createImage((int)width, (int)height);
		Graphics buffer = back.getGraphics();
	
		buffer.setFont(property.getCurrentFont());
		buffer.setColor(property.getCurrentColor().getColor());
		buffer.drawString(sdf.format(date), (int)width/15, (int)height/2+20);
		g.drawImage(back, 0, 0, this);
		
		

		
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (pressedPoint == null) {
			throw new IllegalStateException("Mouse is not pressed");
		}
		Point current = getLocation();
		current.translate(e.getPoint().x - pressedPoint.x, e.getPoint().y - pressedPoint.y);
		setLocation(current);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.isPopupTrigger()) {
			property.show(e.getComponent(), e.getX(), e.getY());
		} else if (e.getButton() == MouseEvent.BUTTON1) {
			pressedPoint = e.getPoint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()) {
			property.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}
