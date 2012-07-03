package ch11.ex11_01;


public class LinkedList<E> implements List<E>{

	
	private LinkedList<E> next = null;
	private E value = null;
	
	public LinkedList(){
	}
	
	public LinkedList(E value) {
		this.value = value;
		this.next = new LinkedList<E>();
	}
	
	public LinkedList(E[] values) {
		add(values);
	}
	
	public void add(E value) {
		if (this.next != null) {
			this.next.add(value);
		} else {
			this.value = value;
			this.next = new LinkedList<E>();
		}
	}
	
	public E getValue(int i) {
		if (i < 0 )
			return null;
		
		if (i == 0)
			return value;
		
		if (next != null)
			return next.getValue(--i);
		
		return null;
	}

	
	public void add(E... values) {
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
	
	
	public E find(E value) throws ObjectNotFoundException {
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
		List<String> list = new LinkedList<String>(arg1);
		
		String arg2 = "test1";
		list.add(arg2);
		
		String arg3 = "test2";
		list.add(arg3);
		
		System.out.println("LinkedList:"+ list);
		
		try {
			list.find(arg1);
			list.find(arg2);
			list.find("test2");
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
