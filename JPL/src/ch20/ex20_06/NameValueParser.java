package ch20.ex20_06;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class NameValueParser {
	
	private StreamTokenizer in;
	private Map<String, Integer> data = new HashMap<String, Integer>();
	public NameValueParser(StreamTokenizer in) {
		this.in = in;
	}
	
	public void parse() throws IOException{
		String valName = null;
		char ope = 0;
		
		while(in.nextToken() != StreamTokenizer.TT_EOF) {
			if (in.ttype == StreamTokenizer.TT_WORD) {
				if (valName != null) 
					throw new IllegalArgumentException("bad file format");
				
				valName = in.sval;
			} else if (in.ttype == StreamTokenizer.TT_NUMBER) {
				if (valName == null || ope == 0) {
					throw new IllegalArgumentException("bad file format");
				}
				
				int val = 0;
				if (data.containsKey(valName))
					val = data.get(valName);
				
				switch(ope) {
				case '+':
					val += in.nval;
					break;
				case '-':
					val -= in.nval;
					break;
				case '*':
					val *= in.nval;
					break;
					
				default:
					throw new IllegalArgumentException("unknown operator"+ ope);
				}
				data.put(valName, val);
				valName = null;
				ope = 0;
			} else {
				if (valName == null)
					throw new IllegalArgumentException("bad file format");
				ope = (char) in.ttype;
			}
		}
	}
	
	public void print() {
		for (String name : data.keySet()) {
			System.out.println(name+":"+data.get(name));
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		NameValueParser nvp = 
				new NameValueParser(new StreamTokenizer(new FileReader("input2.txt")));
		nvp.parse();
		nvp.print();
	}

}
