package ch12.ex12_01;

public class ObjectNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object value = null;
	public ObjectNotFoundException(Object object) {
		super(object.toString());
		this.value = object;
	}
}
