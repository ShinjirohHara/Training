package ch24.ex24_01;

import java.util.ListResourceBundle;

public class GlobalRes_ja extends ListResourceBundle{

	private static final Object[][] contents = {
		{GlobalRes.HELLO, "おはよう"},
		{GlobalRes.GOODBYE, "さようなら"}
	};
	
	@Override
	protected Object[][] getContents() {
		
		return contents;
	}

}
