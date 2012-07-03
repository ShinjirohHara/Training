package ch13.ex13_02;

import ch13.ex13_01.CharCounter;

public class StringCounter {
	private String param;
	
	StringCounter(String param) {
		this.param = param;
	}
	
	public int count (String str) {
		int index = 0;
		int counter = 0;
		while (true) {
			index = param.indexOf(str, index);
			if (index == -1) {
				break;
			}
			counter++;
			index += str.length();
		}
		return counter;
	}
	
	public static void main(String[] args) {
		System.out.println("test");
		StringCounter target = new StringCounter("Hara Shinjirohihihih");
		
		System.out.println("Shi count is :" + target.count("Shi"));
		System.out.println("s count is :" + target.count("s"));
		System.out.println("oh count is :" + target.count("oh"));
		System.out.println("a  count is :" + target.count("a "));
		System.out.println("hi count is :" + target.count("hi"));
		System.out.println("hih count is :" + target.count("hih"));
	}
}
