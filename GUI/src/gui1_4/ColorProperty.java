package gui1_4;

import java.awt.Color;


public enum ColorProperty {
	
	BLUE(Color.BLUE),
	WHITE(Color.WHITE),
	BLACK(Color.BLACK),
	GREEN(Color.GREEN),
	YELLOW(Color.YELLOW),
	RED(Color.RED);
	
	
	private Color color;
	ColorProperty(Color color) {
		this.color = color;
	}
	public Color getColor() {
		return color;
	}

}
