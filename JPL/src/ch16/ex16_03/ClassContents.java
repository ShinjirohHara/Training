package ch16.ex16_03;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassContents {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			System.out.println("===Fields===");
			List<Field> fields = new ArrayList<Field>(Arrays.asList(c.getFields()));
			for (Field elem : c.getDeclaredFields())
				if (!fields.contains(elem)) 
					fields.add(elem);								
			printMembers(fields);
			
			System.out.println("===Constructors===");
			List<Constructor> constructors = new ArrayList<Constructor>(Arrays.asList(c.getConstructors()));
			for (Constructor elem : c.getDeclaredConstructors()) 
				if (!constructors.contains(elem))
					constructors.add(elem);
			printMembers(constructors);
			
			
			System.out.println("===Methods===");
			List<Method> methos = new ArrayList<Method>(Arrays.asList(c.getMethods()));
			for (Method elem : c.getDeclaredMethods())
				if (!methos.contains(elem))
					methos.add(elem);
			printMembers(methos);
			
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}
	
	private static void printMembers(List<? extends Member> mems) {
		for (Member m : mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(decl);
		}
	}
	
	
}
