package ch01.ex01_15;


public interface ExtendedLookup extends Lookup {
	public Object add(String name, Object value);
	public Object remove(String name);
	
}
