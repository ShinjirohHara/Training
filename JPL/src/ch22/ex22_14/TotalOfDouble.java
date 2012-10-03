package ch22.ex22_14;

import java.io.*;
import java.util.StringTokenizer;

public class TotalOfDouble {
	
	static double sumStream(String source ) throws IOException{
		double ret = 0;
		StringTokenizer in =  new StringTokenizer(source);
		while (in.hasMoreTokens()) {
			try {
				ret += Double.parseDouble(in.nextToken());
			} catch (NumberFormatException nfe) {
				; // noting to do
			}
		}
		
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		String input = "1 2 3.1 this is test  1 3.2 10 1 test 2 100"; 
		System.out.println("sum = "+sumStream(input));
	}

}
