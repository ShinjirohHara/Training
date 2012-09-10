package interpret;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DataHolder {
	private static Map<String, Object> data = new HashMap<String, Object>();
	
	public static Object getData(String name) {
		return data.get(name);
	}
	
	public static void putData(String name, Object value) {
		System.out.println("called put data name:"+ name + ", value:"+value);
		data.put(name, value);
	}
	
	public static Set<String> getNameSet() {
		return data.keySet();
	}
	
	
	

}
