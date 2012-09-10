package ch20.ex20_10;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordNumberParser {
	
	private StreamTokenizer in;
	private Map<String, Integer> data = new HashMap<String, Integer>();
	public WordNumberParser(StreamTokenizer in) {
		this.in = in;
		this.in.whitespaceChars(0, '.');
	}
	
	public void parse() throws IOException{
		
		
		while(in.nextToken() != StreamTokenizer.TT_EOF) {
			if (in.ttype == StreamTokenizer.TT_WORD) {
				String valName = in.sval;
				int val = 0;
				if (data.containsKey(valName))
					val = data.get(valName);
				
				val++;
				data.put(valName, val);
			}
		}
	}
	
	public void print() {
		for (String name : data.keySet()) {
			System.out.println(name+":"+data.get(name));
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		WordNumberParser nvp = 
				new WordNumberParser(new StreamTokenizer(new FileReader("JPL/src/ch20/ex20_10/WordNumberParser.java")));
		nvp.parse();
		nvp.print();
	}

}
