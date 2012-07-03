
public class LinkedList {
	
	private LinkedList next = null;
	private Object value = null;
	
	public LinkedList(){
	}
	
	public LinkedList(Object value) {
		this.value = value;
	}
	
	public LinkedList(Object[] values) {
		add(values);
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
	
	public Object getValue() {
		return value;
	}
	
	public void add(Object... values) {
		for (int i = 0; i < values.length; i ++) {
			add(values[i]);
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
	
	
	public int getSize() {
		if (next == null) {
			if (value == null) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (value == null) {
				return next.getSize() + 1;
			} else {
				return next.getSize();
			}
		}
	}
	public String toString() {
		if (next == null) {
			if (value == null) {
				return null;
			} else {
				return value.toString();
			}
		} else {
			if(value == null) {
				return next.toString();
			} else {
				return value.toString()+","+next.toString();
			}
		}
	}

}
