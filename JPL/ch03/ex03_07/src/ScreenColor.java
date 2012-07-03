
public class ScreenColor {

	private Object color;
	public ScreenColor(Object value) {
		color = value;
	}
	
	public String toString() {
		return "color:"+color.toString();
	}
	
	public int hashCode() {
		return color.hashCode() * 17;
	}

}
