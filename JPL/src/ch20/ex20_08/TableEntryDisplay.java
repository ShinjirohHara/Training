package ch20.ex20_08;

import java.io.*;


public class TableEntryDisplay {
		
	
	private File tableFile;
	private String fileName;
	private int entryCount = 0;
	
	public TableEntryDisplay(String fileName) throws IOException{
		this.fileName = fileName;
		tableFile = new File("output20_08.txt");
	}
	
	public void parse()  throws IOException{
		FileWriter out = new FileWriter(tableFile);
		RandomAccessFile inFile = new RandomAccessFile(fileName, "r");
		
		while (true) {
			try {
				char firstChar = (char) inFile.readByte();
				char secondChar = (char) inFile.readByte();
				if (firstChar == '%' && secondChar  == '%') { 
					out.write(inFile.getFilePointer()+System.getProperty("line.separator"));
					entryCount++;
				} else {
					inFile.seek(inFile.getFilePointer() - 4);
				}
				inFile.readLine();
			} catch (EOFException eofe) {
				out.flush();
				break;
			}
		}
	}
	

	
	public void randomPrint() throws IOException{

		if (entryCount == 0) return;
		try {
			LineNumberReader lnr = new LineNumberReader(new FileReader(tableFile));
			int lineno = (int) (Math.random() * entryCount);
			String filePointer = "";
			for (int i = 0; i < lineno; i++) {
				lnr.readLine();
			}
			filePointer = lnr.readLine();
			
			RandomAccessFile raf = new RandomAccessFile(fileName, "r");
			raf.seek(Long.parseLong(filePointer));
			System.out.println(raf.readLine());
		} catch (FileNotFoundException e) {
			throw new AssertionError(e.getMessage());
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		
		TableEntryDisplay ted = 
				new TableEntryDisplay("input20_8.txt");
		ted.parse();
		for (int i = 0; i < 10; i++)
			ted.randomPrint();
	}

}
