package ch24.ex24_03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		parse("2012/10/28");
		parse("2012/01/02");
		parse("2012/1/2");
		parse("2012/1/32");
		parse("1/2/3/4");
		parse("11111/21/20");
	}
	
	private static void parse(String text)  {
		
		Date result;
		try {
			DateFormat format = DateFormat.getDateInstance();
			format.setLenient(true);
			result = format.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("Input:"+text+", Result:"+result);
	}

}
