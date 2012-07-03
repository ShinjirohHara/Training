
public class LinkedList {
	
	private LinkedList next = null;
	private Object value = null;
	
	public LinkedList(Object value) {
		this.value = value;
	}
	
	public LinkedList(Object[] values) {
		for (int i = 0; i < values.length; i++) {
			add(values[i]);
		}
	}
	
	public void add(Object value) {
		if (this.value == null) {
			this.value = value;
		} else if (this.next == null){
			this.next = new LinkedList(value);
		} else {
			this.next.add(value);
		}
	}
	
	public Object remove(Object value) {
		
		if (value == null) return null;
		
		if (value.equals(this.value)) {
			this.value = null;
			return value;
		} else if (this.next != null){
			return next.remove(value);
		} else {
			return null;
		}
	}

}
