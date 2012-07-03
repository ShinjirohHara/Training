package ch13.ex13_05;

public class CommaDelimiter {

	private String value;
	public CommaDelimiter(String value) {
		this.value = value;
	}
	
	public String toString() {
		
		int cuurent = 0;
		int length = value.length();
		StringBuilder result = new StringBuilder((int) (length * 1.4));
		result.append(value.substring(0, length % 3));
		cuurent += length % 3;
		for (; cuurent < length; cuurent+=3) {
			if (result.length() != 0)
				result.append(",");
			result.append(value.subSequence(cuurent, cuurent+3));
		}
		
		return result.toString();
	}
	
	public static void main (String[] args) {
		String input = "123456789";
		CommaDelimiter cd = new CommaDelimiter(input);
		System.out.println("input = "+ input + ", result = "+cd);
		
		input = "1234567";
		cd = new CommaDelimiter(input);
		System.out.println("input = "+ input + ", result = "+cd);
	}
}
