package ch22.ex22_11;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CVSParser {
	
	public static List<String[]> readCVSTable(Reader source, int cellNum)throws IOException {
		
		StreamTokenizer in = new StreamTokenizer(source);
		in.whitespaceChars(',', ',');
		in.eolIsSignificant(true);

		
		int i = 0;
		List<String[]> result = new ArrayList<String[]>();
		String[] line = new String[cellNum];
		
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			
			if (in.ttype == StreamTokenizer.TT_WORD) {
				if (i >= cellNum)
					throw new IllegalArgumentException("illegal file format"+i+in.sval);
				line[i] = in.sval;
			} else if (in.ttype == StreamTokenizer.TT_NUMBER) {
				if (i >= cellNum)
					throw new IllegalArgumentException("illegal file format"+i+in.nval);
				line[i] = Double.toString(in.nval);
			} else if (in.ttype == StreamTokenizer.TT_EOL) {
				if (i != cellNum && i != 0)
					throw new IllegalArgumentException("illegal file format"+i);
				if (i != 0) {
					result.add(line);
					line = new String[cellNum];
					
				}	
				
				i = 0;
				continue;
			} else {
				throw new IllegalArgumentException("not supported file format"+in.ttype);
			}
			i++;
		}
			
		if (i != 0)
			result.add(line);
		return result;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader(new File("input22_11.txt"));
		List<String[]> result = readCVSTable(fr, 4);
		for (String[] line : result) { 
			for (String word : line)
				System.out.print(word+" ");
			System.out.println();
		}
	}
	

}
