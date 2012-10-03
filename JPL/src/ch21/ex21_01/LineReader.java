package ch21.ex21_01;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;



public class LineReader extends FilterReader {

	private LineNumberReader in;
	private String cuurentLine;
	
	protected LineReader(LineNumberReader in) {
		super(in);
		this.in = in;
	}

	public int read(char[] buf, int offset, int count) throws IOException {
		if (cuurentLine == null) {
			cuurentLine = in.readLine();
			if (cuurentLine == null)
				return -1;
		}
		int maxBuffLength = (buf.length - offset < count) ? buf.length - offset : count; 
				
		String copyLine = null;
		if (cuurentLine.length() > maxBuffLength) {
			copyLine = cuurentLine.substring(0, maxBuffLength);
			cuurentLine = cuurentLine.substring(maxBuffLength);
		} else {
			copyLine = cuurentLine;
			cuurentLine = null;
		}
	
		
		System.arraycopy(copyLine.toCharArray(), 0, buf, offset, copyLine.length());
		return copyLine.length();
	}

	public static void main(String[] args) throws IOException{
				
		LineNumberReader lnr = new LineNumberReader(new FileReader(new File("input21_1.txt")));
		LineReader lr = new LineReader(lnr);
		
		List<String> sortList = new ArrayList<String>();

		char[] buff = new char[255];
		while (lr.read(buff) != -1) {
			int i = 0;
			String line = String.valueOf(buff);
			for (;i < sortList.size(); ++i)
				if (sortList.get(i).compareTo(line) > 0) break;
						sortList.add(i, line);
		}
		
		
		for (Iterator<String> ite = sortList.iterator(); ite.hasNext();)
			System.out.println(ite.next());
			
	}
	
}
