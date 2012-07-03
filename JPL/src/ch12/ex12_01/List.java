package ch12.ex12_01;


public interface List{

	public void add(Object value);
	
	public int getSize();
	public Object getValue(int iPos);
	public Object find(Object value) throws ObjectNotFoundException;
}
