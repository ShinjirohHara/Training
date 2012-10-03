package ch22.ex22_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CommentSkip {
	
	private static List<String> result = new ArrayList<String>();
	
	public static void main (String[] args) throws FileNotFoundException {
		Readable source = new FileReader(new File("input22_10.txt"));
		Scanner in  = new Scanner(source);
		
		in.useDelimiter("#");
		while (in.hasNext()) {

			Scanner spaceSkipper = new Scanner(in.next());
			while(spaceSkipper.hasNext()) {
				result.add(spaceSkipper.next());
			}
			if (in.hasNextLine())
				in.nextLine();
		}
		
		for (String token:result) {
			System.out.println(token);
		}
	}

}
