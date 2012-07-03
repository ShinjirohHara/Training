package ch11.ex11_03;

import java.util.Iterator;


public interface Attributed<E> {
	void add(Attr<E> newAttr);
	Attr<E> find(String attrName);
	Attr<E> remove(String attrName);
	Iterator<Attr<E>> attrs();

	
	public class Attr<E> {
		private final String name;
		private E value = null;
		
		public Attr(String name) {
			this.name = name;
		}
		
		public Attr(String name, E value) {
			this.name = name;
			this.value = value;
		}
		
		public String getName() {
			return name;
		}
		
		public E getValue() {
			return value;
		}
		
		public E setValue(E newValue) {
			E oldVal = value;
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
