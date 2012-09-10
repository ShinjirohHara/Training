package ch10.ex10_05;

public class DisplayChar {
	public static void main(String[] args) {
		dispChar('0', '9');
		dispChar('A', 'Z');
		dispChar('あ', 'ん');
	}
	
	static void dispChar(char S, char E) {
		char x;
		for (x = S; x <= E; x++) {
			System.out.print(x+ " ");
		}
		System.out.println();
	}
	

}
