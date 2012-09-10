package ch20.ex20_11;

import java.io.*;

public class ExtensionFilter implements FilenameFilter{
	
	private String extension;


	public ExtensionFilter(String extension) {
		this.extension = extension;
	}


	public static void main(String[] args) {
		File dir = new File("JPL/src/ch20/ex20_10");
		for (String file : dir.list(new ExtensionFilter("java")))
			System.out.println(file);
	}

	
	public boolean accept(File dir, String name) {
		if (name.substring(name.lastIndexOf('.')).equals('.'+extension))
			return true;
		return false;
	}

}
