package ch14.ex14_07;

public class Babble extends Thread {

	static boolean doYield;
	static int howOften;
	private String word;
	
	Babble(String whatToSay) {
		word = whatToSay;
	}
	
	public void run() {
		for (int i = 0; i < howOften; i++) {
			System.out.println(word);
			if (doYield) {
				Thread.yield();
			}
		}
	}
	
	public static void main(String args[]) {
		doYield = true;
		howOften = 5;
		String[] word = {"Java", "C++", "Ruby"};
		for (int i = 0; i < word.length; i++) {
			new Babble(word[i]).start();
		}
	}
}
