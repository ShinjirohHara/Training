package ch02.ex02_06;


public class LinkedList {
	
	private LinkedList next = null;
	private Object value = null;
	
	public void add(Object value) {
		if (this.next == null) {
			LinkedList newElem = new LinkedList();
			newElem.value = value;
			this.next = newElem;
		} else {
			this.next.add(value);
		}
	}
	
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		
		list.add(new Vehicle(200, 10, "hara"));
		list.add(new Vehicle(250, 30, "yamashita"));
		list.add(new Vehicle(120, 60, "kidogu"));
		list.add(new Vehicle(2300, 90, "uchida"));
		list.add(new Vehicle(80, 120, "hayashi"));
	}

}
