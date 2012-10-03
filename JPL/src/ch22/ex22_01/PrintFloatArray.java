package ch22.ex22_01;

import java.util.Random;

public class PrintFloatArray {
	private double[] target;
	public PrintFloatArray(double[] target) {
		this.target = target;
	}
	
	
	public void print(int num) {
		if (num < 1) 
			throw new IllegalArgumentException("line is too small");
		
		int width = (80/num - 8) > 15 ? 15: 80/num - 8; 
		if (width < 0) throw new IllegalArgumentException("書けません・・・");
		

		for (int i = 0; i < target.length/num + 1; i++) {
			String separator = "";
			for (int j = 0; j < num; j++) {
				if (i*num + j < target.length)
					System.out.printf(separator+"% ."+width+"e", target[i*num+j]);
				separator=",";
			}
			System.out.println();
		}
		
			
	}
	
	public static void main (String[] args) {
		double[] arg = new double[50];
		Random rnd = new Random();
		for(int i = 0; i < arg.length; i++) {
			arg[i] = rnd.nextInt();
			arg[i] += rnd.nextDouble();
		}
		
		PrintFloatArray printer = new PrintFloatArray(arg);
		printer.print(1);
		printer.print(2);
		printer.print(5);
		printer.print(10);
		printer.print(20);
	}
	
	
	

}
