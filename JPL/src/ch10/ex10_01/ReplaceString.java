package ch10.ex10_01;

public class ReplaceString {

	private String in;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ReplaceString str = new ReplaceString("aaa\"");
		System.out.println(str);
		
		str = new ReplaceString("\\\\\"\'");
		System.out.println(str);
				

	}
	
	public ReplaceString(String in) {
		this.in = in;
	}
	
	public String replace() {
		String result = "";
		for (int i = 0; i < in.length(); i++) {
			char c = in.charAt(i);
		
			if(c == '\n') {
				result += "\\n";
			} else if (c == '\t') {
				result += "\\t";
			} else if (c == '\b') {
				result += "\\r";
			} else if (c == '\f') {
				result += "\\f";
			} else if (c == '\\') {
				result += "\\\\";
			} else if (c == '\'') {
				result += "\\\'";
			} else if (c == '\"') {
				result += "\\\"";
			} else {
				result += String.valueOf(c);
			}
		}
		
		return result;
	}
	
	public String toString() {
		return "before:"+ in+ ", after:"+ replace();
	}

}
