package ch01.ex01_10;


public class Element {
	private boolean even = false;
	private int num = 0;
	
	public Element(int num) {
		this.num = num;
		if (num % 2 == 0) {
			even = true;
		}
	}
	
	public boolean isEven() {
		return even;
	}
	
	public int getNum() {
		return num;
	}
	
	public String toString() {
		String result;
		if (isEven()) {
			result = num + " *";
		} else {
			result = num + "";
		}
		return result;
	}

}
