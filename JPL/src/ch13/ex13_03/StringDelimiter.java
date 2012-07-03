package ch13.ex13_03;

import java.util.ArrayList;
import java.util.List;

public class StringDelimiter {
	private String param;
	StringDelimiter(String param) {
		this.param = param;
	}
	
	public static void main(String[] arags) {
		StringDelimiter target = new StringDelimiter("shinjiroh Hara Shinji hara sahsahina hara shinjiroh");
		String[] result = target.delimitedString('a', 's');
		
		System.out.println("a to s");
		for (String element : result) {
			System.out.println("element: "+ element);
		}
		
		System.out.println("s to a");
		result = target.delimitedString('s', 'a');
		
		for (String element : result) {
			System.out.println("element: "+ element);
		}
	}

	public String[] delimitedString(char start, char end) {
		if (start == end) {
			throw new IllegalArgumentException("");
		}
		
		List<String> result = new ArrayList<String>();
		int startPos = 0;
		int endPos = 0;
		while (true) {
			startPos = param.indexOf(start, startPos);
			endPos = param.indexOf(end, startPos);
			
			if (startPos == -1) {
				break;
			} else if (endPos == -1) {
				result.add(param.substring(startPos));
				break;
			} else {
				result.add(param.substring(startPos, endPos+1));
			}
			startPos = endPos+1;
		}
		
		return result.toArray(new String[0]);
	}

}
