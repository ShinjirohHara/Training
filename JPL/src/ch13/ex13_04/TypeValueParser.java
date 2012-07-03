package ch13.ex13_04;

import java.util.ArrayList;
import java.util.List;

public class TypeValueParser {
	
	public static void main(String[] args) {
		String input = "Integer 333\nLong 4571\nCharacter t";
		System.out.println(input);
		List<Object> result = parse(input);
		for (Object element: result) {
			System.out.println(element);
		}
	}
	
	public static List<Object> parse(String input) {
		String[] rows = input.split("\n");
		
		List<Object> result = new ArrayList<Object>();
		for (String row : rows) {
			result.add(getData(row));
		}
		
		return result;
		
	}

	private static Object getData(String row) {
		Object result = null;
		String type = row.substring(0, row.indexOf(' '));
		String value = row.substring(row.lastIndexOf(' ')+1);
		if ("Boolean".equals(type)) {
			result = Boolean.valueOf(value);
		} else if ("Byte".equals(type)) {
			result = Byte.valueOf(value);
		} else if ("Character".equals(type)) {
			result = Character.valueOf(value.charAt(0));
		} else if ("Short".equals(type)) {
			result = Short.valueOf(value);
		} else if ("Integer".equals(type)) {			
			result = Integer.valueOf(value);
		} else if("Long".equals(type)) {
			result = Long.valueOf(value);
		} else if ("Float".equals(type)) {
			result = Float.valueOf(value);
		} else if ("Double".equals(type)) {
			result = Double.valueOf(value);
		} else {
			throw new IllegalArgumentException("Illegal type:"+type);
		}
		return result;
	}

}
