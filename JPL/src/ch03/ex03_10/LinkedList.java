package ch03.ex03_10;


public class LinkedList implements Cloneable{
	
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
	
	public Object getValue(int i) {
		if (i < 0 )
			return null;
		
		if (i == 0)
			return getValue();
		
		if (next != null)
			return next.getValue(--i);
		
		return null;
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
	
	public LinkedList clone() {
		
		try {
			LinkedList obj = (LinkedList)super.clone();
			if (next != null) {
				obj.next = next.clone();
			}
			return obj;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
	
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		list.add(new Vehicle("hara"));
		list.add(new Vehicle("kidoguchi"));
		list.add(new Vehicle("uchida"));
		
		System.out.println("original:"+list);
		LinkedList clone_list = list.clone();
		System.out.println("clone:"+clone_list);
		clone_list.add(new Vehicle("hayashi"));
		Vehicle uchida = (Vehicle) clone_list.getValue(2);
		uchida.changeSpeed(200);
		System.out.println("original:"+list);
		System.out.println("clone:"+clone_list);
		
		
	}

}
