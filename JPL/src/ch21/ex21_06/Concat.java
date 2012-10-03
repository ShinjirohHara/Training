package ch21.ex21_06;

import java.io.*;
import java.util.Enumeration;

public class Concat {
	private static class FileSequenceEnumeration implements Enumeration<InputStream>{

		private String[] fileNames;
		private int current = 0;
		private InputStream currentFile = null;
		
		FileSequenceEnumeration(String[] fileNames) {
			this.fileNames = fileNames;
		}
		@Override
		public boolean hasMoreElements() {
			
			return (current < fileNames.length);
		}

		@Override
		public InputStream nextElement() {
			if (currentFile != null) {
				try {
					currentFile.close();
					currentFile = null;
				} catch (IOException e) {
					
				}
			}

			try {
				currentFile = new BufferedInputStream(new FileInputStream(fileNames[current++]));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new IllegalArgumentException("file not found");
			}
			return currentFile;
		}
		
	}
	public static void main(String[] args) throws IOException{
		InputStream in;
		if (args.length == 0) {
			in = System.in;
		} else {
			in = new SequenceInputStream(new FileSequenceEnumeration(args));
		}
		int ch;
		while ((ch = in.read()) != -1) {
			System.out.write(ch);
		}
	}
}
