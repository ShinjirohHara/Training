package ch01.ex01_06;


public class Fibonacci {
	private static final String title = "�t�B�{�i�b�`���� by const";
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println(title);
		int i = 1;
		System.out.println(i+"�Ԗ�:"+lo);
		while (hi < 50) {
			i++;
			System.out.println(i+ "�Ԗ�:"+hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
