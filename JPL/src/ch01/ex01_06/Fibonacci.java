package ch01.ex01_06;


public class Fibonacci {
	private static final String title = "フィボナッチ数列 by const";
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println(title);
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
