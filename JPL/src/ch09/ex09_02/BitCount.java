package ch09.ex09_02;


public class BitCount {
	private int data;
	BitCount(int data) {
		this.data = data;
	}
	public int count() {
		int result = 0;
		for (int i = 0; i < Integer.SIZE; i++){
			if (((data >> i) & 0x01) == 0x01) {
				result++;
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		BitCount data = new BitCount(-1);
		System.out.println(data.count());
	}
}
