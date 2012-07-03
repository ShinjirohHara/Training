import java.io.IOException;

public class BadDataSetException extends Exception{
	
	private static final long serialVersionUID = 1774656447562697409L;
	
	private IOException ex;
	private String name;
	BadDataSetException(String name, IOException ex) {
		this.ex = ex;
		this.name = name;
	}
	
	public String getMessage() {
		return name;
	}
	
	public Throwable getCause() {
		return ex;
	}
}
