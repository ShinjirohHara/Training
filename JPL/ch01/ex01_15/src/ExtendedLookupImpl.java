
public class ExtendedLookupImpl implements ExtendedLookup {
	private String[] names;
	private Object[] values;
	
	private int element_num = 0;
	private static final int MAX_NUM = 10;
	
	public ExtendedLookupImpl() {
		names = new String[MAX_NUM];
		values = new Object[MAX_NUM];
	}
	
	public Object find(String name) {
		for (int i = 0; i < element_num; i++) {
			if (names[i].equals(name)) {
				return values[i];
			}
		}
		return null;
	}

	
	public Object add(String name, Object value) {
		if (element_num == MAX_NUM) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < element_num; i++) {
			if (names[i].equals(name)) {
				names[i] = name;
				values[i] = value;
				return value;
			}
		}

		names[element_num] = name;
		values[element_num] = value;
		element_num++;
		return value;
	}


	public Object remove(String name) {
		for (int i = 0; i < element_num; i++) {
			if (names[i].equals(name)) {
				Object result = values[i];
				for (int j = i; j < element_num - 1; j++) {
					names[j] = names[j+1];
					values[j] = values[j+1];
				}
				names[element_num - 1] = null;
				values[element_num - 1] = null;
				element_num--;
				return result;
			}
		}
		
		return null;
	}

}
