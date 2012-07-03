package ch11.ex11_01;


public interface List<E> {

	public void add(E value);
	
	public int getSize();
	public E getValue(int iPos);
	public E find(E value) throws ObjectNotFoundException;
}
