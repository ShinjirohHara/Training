		
enum SignalColor {
	RED(new Color("RED_")), YELLOW(new Color("YELLOW_")), BLUE(new Color("BLUE_"));
	
	Color colorObj;
	
	SignalColor(Color color) {
		this.colorObj = color;
	}
	public Color getColor() {
		return colorObj;
	}
	
}

