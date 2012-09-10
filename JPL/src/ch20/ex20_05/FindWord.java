package ch20.ex20_05;

import java.io.*;

public class FindWord {
	public static void main(String[] args) throws IOException{
		if (args.length < 2)
			throw new IllegalArgumentException("too few arguments number");
		
		String match = args[0];
		FileReader fileIn = new FileReader(args[1]);
		LineNumberReader lnr = new LineNumberReader(fileIn);
		String line;
		while ((line = lnr.readLine()) != null) {
			if (line.contains(match)) {
				System.out.println(lnr.getLineNumber()+":"+line);
			}
		}
	}
}
