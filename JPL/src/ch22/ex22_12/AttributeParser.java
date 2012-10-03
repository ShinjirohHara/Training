package ch22.ex22_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class AttributeParser {
	
	public static Attributed readAttrs(Readable source) throws IOException {
		
		Attributed ret = new ObservableAttributed();
		Scanner in = new Scanner(source);
		String exp = "^(\\S*)(\\s*)=(\\s*)(\\S*)";
		Pattern pat = Pattern.compile(exp, (Pattern.COMMENTS | Pattern.MULTILINE));
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				MatchResult match = in.match();
				ret.add(new Attributed.Attr(match.group(1), match.group(4)));
				in.nextLine();
			} else {
				throw new IOException("input format error");
			}
		}
		
		if (in.ioException() != null) throw in.ioException(); 
			
		
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(new File("input22_12.txt"));
		Attributed result = readAttrs(fr);
		System.out.println(result.toString());
	}

}
