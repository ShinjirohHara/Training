package ch22.ex22_08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CVSParser {
	
	public static List<String[]> readCSVTable(Readable source, int cellNum) throws IOException{ 
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList <String[]>();
		String exp = "^";
		String separator = "";
		for (int i = 0; i <cellNum; i++) {
			exp += separator+"(.*)";
			separator = ",";
			
		}
		// exp += "$";
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				String[] cells = new String[cellNum];
				MatchResult match = in.match();
				for (int i = 0; i < cellNum; i++) {
					cells[i] = match.group(i+1);
					if (cells[i].contains(",")) {
						throw new IOException("input format error");
					}
				}
				vals.add(cells);
				in.nextLine();
			} else {
				if (!"".equals(in.nextLine()))
					throw new IOException("input format error");
			}
		}
		IOException ex = in.ioException();
		if (ex != null)
			throw ex;
		
		
		return vals;
	}
	
	public static void main(String[] args) {
		List<String[]> tokens = null;
		try {
			FileReader fr = new FileReader(new File("input22_07.txt"));
			tokens = readCSVTable(fr, 5);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		for (String[] line : tokens) {
			for (int i = 0; i < line.length; i++) {
				System.out.print(line[i]+",");
			}
			System.out.println();
		}
	}

}
