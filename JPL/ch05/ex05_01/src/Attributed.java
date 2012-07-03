import java.util.Iterator;


public interface Attributed {
	void add(Attr newAttr);
	Attr find(String attrName);
	Attr remove(String attrName);
	Iterator<Attr> attrs();

	
	static public class Attr {
		private final String name;
		private Object value = null;
		
		public Attr(String name) {
			this.name = name;
		}
		
		public Attr(String name, Object value) {
			this.name = name;
			this.value = value;
		}
		
		public String getName() {
			return name;
		}
		
		public Object getValue() {
			return value;
		}
		
		public Object setValue(Object newValue) {
			Object oldVal = value;
			value = newValue;
			return oldVal;
		}
		
		public String toString() {
			return name + "='" + value + "'";
		}
		
		public int hashCode() {
			int result = 17;
			int multi = 31;
			result = result * multi + name.hashCode();
			if (value != null) {
				result = result * multi + value.hashCode();
			}
			return result;
		}
	}
}
