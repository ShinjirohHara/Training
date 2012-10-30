package ch24.ex24_01;

import java.util.ListResourceBundle;

public class GlobalRes_en extends ListResourceBundle{

	private static final Object[][] contents = {
		{GlobalRes.HELLO, "Hello"},
		{GlobalRes.GOODBYE, "Good bye"}
	};
	
	@Override
	protected Object[][] getContents() {
		
		return contents;
	}

}
