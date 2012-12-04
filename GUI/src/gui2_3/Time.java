package gui2_3;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.JPanel;
import javax.swing.JWindow;

public class Time extends JPanel {

	private static final long serialVersionUID = -6817980970800362509L;

	private SizeMenu sizeMenu;
	private FontMenu fontMenu;
	private ColorMenu colorMenu;
	
	private JWindow frame;

	private ColorMenu bkColorMenu;

	Time(JWindow frame) {
		this.frame = frame;
		setVisible(true);
	}
	





	public void paintComponent(Graphics g) {
		
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		
		String digitalString = sdf.format(date);
		Font currentFont = 
				new Font(fontMenu.getValue(), Font.PLAIN, sizeMenu.getValue().getValue());
		FontMetrics fm = g.getFontMetrics(currentFont);
		int width = 
				fm.charsWidth(digitalString.toCharArray(), 0, digitalString.toCharArray().length);
		int height = fm.getHeight();
		g.setFont(currentFont);
		g.setColor(colorMenu.getColor().getColor());
		g.drawString(sdf.format(date), 40, height/2+height/6 + 10);
		frame.setSize(width+80, height+height/10 + 10);
		frame.setBackground(bkColorMenu.getColor().getColor());
	}


	

	public void setSizeMenu(SizeMenu sizeMenu) {
		this.sizeMenu = sizeMenu;
		
	}
	
	public void setColorMenu(ColorMenu colorMenu) {
		this.colorMenu = colorMenu;
		
	}
	
	public void setFontMenu(FontMenu fontMenu) {
		this.fontMenu = fontMenu;
		
	}
	
	public void setBackGrround(ColorMenu colorMenu) {
		this.bkColorMenu = colorMenu;
	}
}
