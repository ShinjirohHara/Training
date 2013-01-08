package gui2_4;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ColorRenderer extends JLabel implements ListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ColorRenderer() {
		setOpaque(true);
	}
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		ColorProperty color = (ColorProperty) value;
		setText(color.toString());
		setBackground(color.getColor());
		if (Color.BLACK.equals(color.getColor())|| Color.BLUE.equals(color.getColor())) {
			setForeground(Color.WHITE);
		} else {
			setForeground(Color.BLACK);
		}
		
		return this;
	}

}
