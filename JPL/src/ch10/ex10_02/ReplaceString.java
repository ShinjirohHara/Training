package ch10.ex10_02;

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
			switch (c) {
			case '\n':
				result = result.concat("\\n");
				break;
			case '\t':
				result = result.concat("\\t");
				break;
			case '\b':
				result = result.concat("\\b");
				break;
			case '\r':
				result = result.concat("\\r");
				break;
			
			case '\f':
				result = result.concat("\\f"); 	
				break;
			
			case '\\':
				result = result.concat("\\\\");
				break;
				
			case '\"':
				result = result.concat("\\\"");
				break;

			case '\'':
				result = result.concat("\\\'");
				break;

			default:
				result = result.concat(String.valueOf(c));
			}
		}
		
		return result;
	}
	

	
	public String toString() {
		return "before:"+ in+ ", after:"+ replace();
	}

}
