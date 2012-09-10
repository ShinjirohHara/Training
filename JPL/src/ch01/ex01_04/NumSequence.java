package ch01.ex01_04;


public class NumSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 1;
		int num = 1;
		System.out.println("An = Σi");
		System.out.println(i+"番目:"+num);
		while (i < 10) {
			i++;
			num = num + i;
			System.out.println(i+"番目:"+num);
		}
		
		i = 0;
		num = 0;
		System.out.println("平方根");
		while (i < 10) {
			i++;
			System.out.println(i+"番目："+i*i);
		}
	}
}
