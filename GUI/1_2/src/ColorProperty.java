import java.awt.Color;


enum ColorProperty {
	
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
