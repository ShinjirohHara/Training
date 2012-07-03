package ch13.ex13_01;

public class CharCounter {
	
	private String param;
	
	CharCounter(String param) {
		this.param = param;
	}
	
	public int count (int ch) {
		int index = 0;
		int counter = 0;
		while (true) {
			index = param.indexOf(ch, index);
			if (index == -1) {
				break;
			}
			counter++;
			index++;
		}
		return counter;
	}
	
	public static void main(String[] args) {
		System.out.println("test");
		CharCounter target = new CharCounter("Hara Shinjiroh");
		
		System.out.println("S count is :" + target.count('S'));
		System.out.println("s count is :" + target.count('s'));
		System.out.println("h count is :" + target.count('h'));
		System.out.println("a count is :" + target.count('a'));
		
	}
}
