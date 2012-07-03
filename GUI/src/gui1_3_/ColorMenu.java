package gui1_3_;


import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorMenu extends Menu implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Type cuurentColor;
	
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
		cuurentColor = color;
		for (Type element: Type.values()) {
			MenuItem mi = new MenuItem(element.toString());
			add(mi);
			mi.addActionListener(this);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		cuurentColor = Type.valueOf(e.getActionCommand());
	}
	
	public Type getColor() {
		return cuurentColor;
	}
}
