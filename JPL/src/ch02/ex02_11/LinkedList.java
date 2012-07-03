package ch02.ex02_11;


public class LinkedList {
	
	private LinkedList next = null;
	private Object value = null;
	
	public LinkedList(){
	}
	
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

	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		Vehicle atenza = new Vehicle(200, 10, "hara"); 
		list.add(atenza);
		Vehicle rx8 = new Vehicle(250, 30, "yamashita");
		list.add(rx8);
		list.add(new Vehicle(120, 60, "kidogu"));
		list.add(new Vehicle(2300, 90, "uchida"));
		Vehicle fit = new Vehicle(80, 120, "hayashi"); 
		list.add(fit);
		
		System.out.println(list.toString());
		
		list.remove(atenza);
		System.out.println(list.toString());
		
		list.remove(rx8);
		list.add(atenza);
		System.out.println(list.toString());
		
		list.remove(fit);
		System.out.println(list.toString());
	}
}
