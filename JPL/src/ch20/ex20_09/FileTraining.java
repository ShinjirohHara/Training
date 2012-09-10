package ch20.ex20_09;

import java.io.*;
import java.util.Date;

public class FileTraining {
	
	public static void main (String[] args) throws IOException{
		File file = new File("JPL/src/ch20/ex20_09/FileTraining.java");
		System.out.println("CanonicalPath:"+file.getCanonicalPath());
		System.out.println("Parent:"+file.getParent());
		System.out.println("TotalSpace:"+file.getTotalSpace());
		System.out.println("LastModified:"+new Date(file.lastModified()));
		if (file.isDirectory())
			for (String name: file.list())
				System.out.println("\tname:"+name);
		
		
	}

}
