package ch06.ex06_01;

		
public class SignalColor {

	enum ColorType {
		RED, YELLOW, BLUE
	}
	public static void main(String[] args) {
		for (ColorType type: ColorType.values()) {
			System.out.println(type);
		}

	}

}
