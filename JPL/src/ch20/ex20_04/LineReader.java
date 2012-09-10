package ch20.ex20_04;


import java.io.*;
import java.util.Arrays;



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
		String ls = System.getProperty("line.separator");
		StringBuffer sb = new StringBuffer();
		sb.append("this is first line");
		sb.append(ls);
		sb.append("this is second line");
		sb.append(ls);
		sb.append("this is third line");
		
		StringReader sr = new StringReader(sb.toString());
		LineNumberReader lnr = new LineNumberReader(sr);
		LineReader lr = new LineReader(lnr);
		

		char[] buff = new char[255];
		while (lr.read(buff) != -1) {
			System.out.println(buff);
			Arrays.fill(buff, (char)0);
		}
	
		
	}
	
}
