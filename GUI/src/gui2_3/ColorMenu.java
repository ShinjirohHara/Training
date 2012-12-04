package gui2_3;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ColorMenu extends JMenu implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Type currentColor;
	
	enum Type {
		
		BLUE(Color.BLUE),
		WHITE(Color.WHITE),
		BLACK(Color.BLACK),
		GREEN(Color.GREEN),
		YELLOW(Color.YELLOW),
		RED(Color.RED);
		
		
		private Color color;
		Type(Color color) {
			this.color = color;
		}
		public Color getColor() {
			return color;
		}
	}
	
	public ColorMenu(String menuName, Type color) {
		super(menuName);
		currentColor = color;
		for (Type element: Type.values()) {
			JMenuItem mi = new JMenuItem(element.toString());
			add(mi);
			mi.addActionListener(this);
		}
	}
	

	
	public void actionPerformed(ActionEvent e) {
		currentColor = Type.valueOf(e.getActionCommand());
	}
	
	public Type getColor() {
		return currentColor;
	}
}
