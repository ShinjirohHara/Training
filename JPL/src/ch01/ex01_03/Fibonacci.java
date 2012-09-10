package ch01.ex01_03;


public class Fibonacci {
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println("フィボナッチ数列");
		int i = 1;
		System.out.println(i+"番目:"+lo);
		while (hi < 50) {
			i++;
			System.out.println(i+ "番目:"+hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
