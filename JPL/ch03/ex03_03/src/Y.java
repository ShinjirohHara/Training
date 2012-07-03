
public class Y extends X {
	private int yMask = 0xff00;
	
	public Y() {
		super(0xff00);
		System.out.println("xMask:"+xMask+", fullMask:"+fullMask+", yMask:"+yMask);
		System.out.println("mask result:"+Integer.toHexString((mask(0xffff))));
	}
	
	public int mask(int orig) {
		return (orig&yMask);
	}
	
	
	public static void main(String args[]) {
		Y test = new Y();
		
	}
}
