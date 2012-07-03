package ch06.ex06_05;

		
enum SignalColor {
	RED {
		Color getColor() {
			return new Color("RED_");
		}
	},
	BLUE {
		Color getColor() {
			return new Color("BLUE_");
		}
	},
	YELLOW {
		Color getColor() {
			return new Color("YELLOW_");
		}
	};

	
	abstract Color getColor();
	
}

