package ch24.ex24_01;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class GlobalRes_zh extends ResourceBundle {

	private Map<String, String> contents = new HashMap<String, String>();
	public GlobalRes_zh() {
		contents.put(GlobalRes.HELLO, "ni hao");
		contents.put(GlobalRes.GOODBYE, "zai jian");
	}
	@Override
	protected Object handleGetObject(String key) {
		
		return contents.get(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		return Collections.enumeration(contents.keySet());
	}

}
