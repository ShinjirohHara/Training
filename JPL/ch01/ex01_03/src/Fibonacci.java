
public class Fibonacci {
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println("�t�B�{�i�b�`����");
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
