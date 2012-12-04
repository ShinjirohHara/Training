package gui2_3;

import gui2_3.SizeMenu.Value;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.JMenuItem;

public class DigitalWatch extends JWindow implements MouseMotionListener, MouseListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point pressedPoint;
	private JPopupMenu property = new JPopupMenu();
	private Time time;
	

	public static void main (String args[]) {
		
		
		DigitalWatch frame = new DigitalWatch();
		frame.setTime();
		
		

		
						
		frame.setVisible(true);
		while(true) {
			frame.repaint();
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				
			}
		}
	}
	
	DigitalWatch() {
		setSize(500, 200);
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	
	private void setTime() {
		time = new Time(this);
		SizeMenu sizeMenu = new SizeMenu("文字サイズ", Value.SIZE48); 
		property.add(sizeMenu);
		time.setSizeMenu(sizeMenu);
		
		FontMenu fontMenu = new FontMenu("フォント", Font.SANS_SERIF);
		property.add(fontMenu);
		time.setFontMenu(fontMenu);
		
		ColorMenu colorMenu = new ColorMenu("文字色", ColorMenu.Type.BLUE);
		property.add(colorMenu);
		time.setColorMenu(colorMenu);
		
		ColorMenu bkColorMenu = new ColorMenu("背景色", ColorMenu.Type.WHITE);
		property.add(bkColorMenu);
		time.setBackGrround(bkColorMenu);
		
		JMenuItem jmi = new JMenuItem("終了");
		property.add(jmi);
		jmi.addActionListener(this);
		
		add(time, BorderLayout.CENTER);
		
	}
	
	private JMenuItem JMenuItem(String string) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public JPopupMenu getProperty() {
		return property;
	}



	public void mouseDragged(MouseEvent e) {
		if (pressedPoint == null) {
			throw new IllegalStateException("Mouse is not pressed");
		}
		Point current = getLocation();
		current.translate(e.getPoint().x - pressedPoint.x, e.getPoint().y - pressedPoint.y);
		setLocation(current);
	}
	
	public void mouseMoved(MouseEvent e) {
		
	}
	
	public void mouseClicked(MouseEvent me) {
		
	}
	
	public void mouseEntered(MouseEvent arg0) {
		
	}
	
	
	public void mouseExited(MouseEvent arg0) {
		
	}
	
	
	public void mousePressed(MouseEvent e) {
		
		if (e.isPopupTrigger()) {
			property.show(e.getComponent(), e.getX(), e.getY());
		} else if (e.getButton() == MouseEvent.BUTTON1) {
			pressedPoint = e.getPoint();
		}
	}
	
	
	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()) {
			property.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		System.exit(0);
		
	}



}
