package gui1_3;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontMenu extends Menu implements ActionListener {

	private String cuurentFont;

	public FontMenu(String string, String initFont) {
		super(string);
		cuurentFont = initFont;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		for (Font font: ge.getAllFonts()) {
			MenuItem mi = new MenuItem(font.getName());
			add(mi);
			mi.addActionListener(this);
		}
	}

	
	public void actionPerformed(ActionEvent ae) {
		cuurentFont = ae.getActionCommand();
		
	}

	public String getValue() {
		return cuurentFont;
	}

}
