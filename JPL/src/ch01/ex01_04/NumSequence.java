package ch01.ex01_04;


public class NumSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 1;
		int num = 1;
		System.out.println("An = ��i");
		System.out.println(i+"�Ԗ�:"+num);
		while (i < 10) {
			i++;
			num = num + i;
			System.out.println(i+"�Ԗ�:"+num);
		}
		
		i = 0;
		num = 0;
		System.out.println("������");
		while (i < 10) {
			i++;
			System.out.println(i+"�ԖځF"+i*i);
		}
	}
}
