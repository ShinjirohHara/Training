package ch24.ex24_01;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class GlobalRes extends ListResourceBundle {

	public static final String HELLO = "hello";
	public static final String GOODBYE = "goodbye";
	
	
	private static final Object[][] contents = {
		{GlobalRes.HELLO, "Ciao"},
		{GlobalRes.GOODBYE, "Ciao"}
	};
	
	@Override
	protected Object[][] getContents() {
		
		return contents;
	}
	
	
	public static void main(String[] args) {
		
		greet(Locale.getDefault());
		greet(Locale.ENGLISH);
		greet(Locale.CANADA);
		greet(Locale.JAPANESE);
		greet(Locale.CHINA);
		greet(Locale.FRANCE);
	}


	private static void greet(Locale loc) {
		ResourceBundle res;
		res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes", loc);
		System.out.println("arg:"+loc+ ", used:"+res.getLocale());
		System.out.println(res.getString(GlobalRes.HELLO));
		System.out.println(res.getString(GlobalRes.GOODBYE));
	}
}
