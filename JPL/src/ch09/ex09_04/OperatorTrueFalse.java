package ch09.ex09_04;

public class OperatorTrueFalse {
	public static void main(String args[]) {
		
		System.out.println("3 << 2L -1 = "+ (3 << 2L - 1)); // int
		System.out.println("((3L << 2) -1 = "+ ((3L << 2) - 1)); // long
		System.out.println("10 < 12 == 6 > 17 = "+ (10 < 12 == 6 < 17)); // boolean
		System.out.println("10 << 12 == 6 << 17 = " + (10 << 12 == 6 << 17)); // boolean
		System.out.println("13.5e-1 % Float.POSITIVE_INFINITY = " + (13.5e-1 % Float.POSITIVE_INFINITY)); // double
		System.out.println("Float.POSITIVE_INFINITY + Doublue.POSITIVE_INFINITY =" +(Float.POSITIVE_INFINITY + Double.POSITIVE_INFINITY)); // double
		System.out.println("Doublue.POSITIVE_INFINITY - Float.POSITIVE_INFINITY =" +( Double.POSITIVE_INFINITY - Float.POSITIVE_INFINITY)); // double
		System.out.println("0.0 / -0.0 == -0.0/0.0 = "+ (0.0 / -0.0 == -0.0/0.0)); //boolean
		System.out.println("Integer.MAX_VALUE + Integer.MAX_VALUE = "+ (Integer.MAX_VALUE + Integer.MAX_VALUE)); // int
		System.out.println("Long.MAX_VALUE + 5 = "+ (Long.MAX_VALUE + 5)); // long
		System.out.println("(short)5 * (byte) 10 = "+ ((short)5 * (byte) 10)); // int ?
		int i = 3;
		System.out.println("(i < 15 ? 1.72e3f : 0 = "+ (i < 15 ? 1.72e3f : 0)); // float;
		System.out.println("i++ + i++ + --i ="+(i++ + i++ + --i)); // int 3 + 4 + 4 
		
	}

}
