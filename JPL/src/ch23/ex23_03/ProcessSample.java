package ch23.ex23_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProcessSample {
	
	private static final String endString = "Sample";
	
	public static void main(String[] args) throws IOException{
		if (args.length < 1) throw new IllegalArgumentException("too few args");
		
		Process proc = Runtime.getRuntime().exec(args);
		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String line = null;
		int lineNo = 1;
		while ((line = reader.readLine()) != null) {
			if (line.indexOf(endString) != -1) {
				proc.destroy();
			}
			System.out.println(lineNo+":"+line);
			lineNo++;
		}
		
		
	}

}
