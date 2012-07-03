package ch13.ex13_06;

public class CommaDelimiter {

	private String value;
	private int distance;
	public CommaDelimiter(String value, int distance) {
		this.value = value;
		this.distance = distance;
	}
	
	public String toString() {
		
		int current = 0;
		int length = value.length();
		StringBuilder result = new StringBuilder((int) (length * 1.4));
		result.append(value.substring(0, length % distance));
		current += length % distance;
		for (; current < length; current+=distance) {
			if (result.length() != 0)
				result.append(",");
			result.append(value.subSequence(current, current+distance));
		}
		
		return result.toString();
	}
	
	public static void main (String[] args) {
		String input = "123456789";
		CommaDelimiter cd = new CommaDelimiter(input, 4);
		System.out.println("input = "+ input + ", result = "+cd);
		
		input = "1234567";
		cd = new CommaDelimiter(input, 5);
		System.out.println("input = "+ input + ", result = "+cd);
	}
}
