package ch01.ex01_09;


public class Fibonacci {
	public static final int MAX_LENGTH = 10;
	
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println("フィボナッチ数列");
		int[] intArray = new int[MAX_LENGTH];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = lo;
			hi = lo + hi;
			lo = hi - lo;	
		}
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println((i+1)+"番目の要素：" + intArray[i]);
		}
	}
}
