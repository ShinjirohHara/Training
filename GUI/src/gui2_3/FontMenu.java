package gui2_3;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FontMenu extends JMenu implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cuurentFont;

	public FontMenu(String string, String initFont) {
		super(string);
		cuurentFont = initFont;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		for (Font font: ge.getAllFonts()) {
			JMenuItem mi = new JMenuItem(font.getName());
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
