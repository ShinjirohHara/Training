package ch12.ex12_01;


public class LinkedList implements Cloneable, List{
	
	private LinkedList next = null;
	private Object value = null;
	
	public LinkedList(){
	}
	
	public LinkedList(Object value) {
		this.value = value;
		this.next = new LinkedList();
	}
	
	public LinkedList(Object[] values) {
		add(values);
	}
	
	public void add(Object value) {
		if (this.next != null) {
			this.next.add(value);
		} else {
			this.value = value;
			this.next = new LinkedList();
		}
	}
	
	public Object getValue(int i) {
		if (i < 0 )
			return null;
		
		if (i == 0)
			return value;
		
		if (next != null)
			return next.getValue(--i);
		
		return null;
	}

	
	public void add(Object... values) {
		for (int i = 0; i < values.length; i ++) {
			add(values[i]);
		}
	}
		
	
	public int getSize() {
		if (next == null) {
			return 1;
		} else {
			return next.getSize();
		}
	}
	public String toString() {
		if (next == null) {
			return "";
		} else {
			return value.toString()+","+next.toString();
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

	
	public Object find(Object value) throws ObjectNotFoundException {
		if (this.value == value) {
			return value;
		} else if (this.next != null) {
			return this.next.find(value);
		} else {
			throw new ObjectNotFoundException(value);
		}
	}
	
	
	public static void main(String[] args) {
		String arg1 = "test";
		List list = new LinkedList(arg1);
		
		String arg2 = "test1";
		list.add(arg2);
		
		String arg3 = "test2";
		list.add(arg3);
		
		System.out.println("LinkedList:"+ list);
		
		try {
			list.find(arg1);
			list.find(arg2);
			list.find("test2");
			list.find("test3");
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
