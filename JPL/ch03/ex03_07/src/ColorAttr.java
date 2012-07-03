
public class ColorAttr extends Attr {
	private ScreenColor myColor;
	
	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}
	
	public ColorAttr(String name) {
		this(name, "transparent");
	}
	
	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}
	
	public Object setValue(Object newValue) {
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}
	
	public ScreenColor setValue(ScreenColor newValue) {
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}
	
	public ScreenColor getColor() {
		return myColor;
	}
	
	protected void decodeColor() {
		if (getValue() == null) {
			myColor = null;
		} else {
			myColor = new ScreenColor(getValue());
		}
	}
	
	public String toString() {
		return super.toString() + ", "+ myColor;
	}
	
	public int hashCode() {
		int result = 17;
		int multi = 31;
		result = result * multi + super.hashCode();
		result = result * multi + (myColor == null ? 0 : myColor.hashCode());
		return result;
	}
	
	
	public static void main(String[] args) {
		ColorAttr red = new ColorAttr("blood", "red");
		ColorAttr transparent = new ColorAttr("water");
		
		System.out.println("toString:"+red);
		System.out.println("toString:"+transparent);
		
		System.out.println("hashCode:"+red.hashCode());
		System.out.println("hashCode:"+transparent.hashCode());
	}
}
