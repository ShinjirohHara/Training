
public class Y extends X {
	private int yMask = 0xff00;
	
	public Y() {
		System.out.println("xMask:"+Integer.toHexString(xMask)+
				", fullMask:"+Integer.toHexString(fullMask)+", yMask:"+Integer.toHexString(yMask));
		fullMask |= yMask;
		System.out.println("xMask:"+Integer.toHexString(xMask)+
				", fullMask:"+Integer.toHexString(fullMask)+", yMask:"+Integer.toHexString(yMask));
	}
	
	public static void main(String args[]) {
		Y test = new Y();
		
	}
}
