package ch06.ex06_05;


public class Color {
	
	private String name = "";
	Color(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
	
	
	public static void main(String args[]) {
		for (SignalColor color: SignalColor.values()) {
			System.out.println(color.getColor());
		}
	}
}
